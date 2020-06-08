package intg.com.kafkaLearning.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.kafkaLearning.domain.Book;
import com.kafkaLearning.domain.LibraryEvent;
import com.kafkaLearning.domain.LibraryEventType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LibraryEventsRestServiceIntegerationTest {
	
	/*@Autowired
	TestRestTemplate restTemplate; 

	@Test
	void postLibraryEvent() {
		
		Book book = Book.builder().bookId(505).
				bookName("Spring Kafka").bookAuthor("Kumar Nagaraju").build();
		
		LibraryEvent libraryEvent = LibraryEvent.builder().libraryEventId(null).
				book(book).libraryEventType(LibraryEventType.NEW).build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<LibraryEvent> httpEntity = new HttpEntity<LibraryEvent>(libraryEvent,headers);
		ResponseEntity<LibraryEvent> reponseEntity = restTemplate.exchange("/v1/libraryevent", HttpMethod.POST, httpEntity, LibraryEvent.class);
		
		assertEquals(HttpStatus.CREATED, reponseEntity.getStatusCode());
	}*/
}
