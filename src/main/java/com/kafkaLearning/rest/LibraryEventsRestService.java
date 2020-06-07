package com.kafkaLearning.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkaLearning.domain.LibraryEvent;
import com.kafkaLearning.producer.LibraryEventsProducer;

@RestController
public class LibraryEventsRestService {
	
	@Autowired
	LibraryEventsProducer libraryEventsProducer;
	
	@PostMapping("/v1/libraryevent")
	public ResponseEntity<LibraryEvent> addBookToLibrary(@RequestBody LibraryEvent libraryEvent) throws JsonProcessingException {
		
		//invoke kafka producer.
		libraryEventsProducer.sendLibraryEvent(libraryEvent);
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
		
	}

}
