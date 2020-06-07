package com.kafkaLearning.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkaLearning.domain.LibraryEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LibraryEventsProducer {
	
	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;
	
	@Autowired
	ObjectMapper objectMapper;
	
	public void sendLibraryEvent(LibraryEvent libraryEvent) throws JsonProcessingException {
		Integer key = libraryEvent.getLibraryEventId();
		String value = objectMapper.writeValueAsString(libraryEvent);
		//read topic from application.properties
		ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send("library-events",key, value);
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

			@Override
			public void onSuccess(SendResult<Integer, String> result) {
				// TODO Auto-generated method stub
				handleSuccess(key, value, result);
			}


			@Override
			public void onFailure(Throwable ex) {
				handleFailure(key, value, ex);
				
			}
		
		});
	}

	protected void handleFailure(Integer key, String value, Throwable ex) {
		log.error("Error while sending the message & exception is {}", ex.getMessage());
		
	}

	private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
		// TODO Auto-generated method stub
		log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value, result.getRecordMetadata().partition());
		log.info("RecordMeta ="+result.getRecordMetadata().toString());
	}
}
