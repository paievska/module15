package com.example.module15;

import com.example.module15.entities.Note;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Module15ApplicationTests {

	@Test
	void testNote() {
		String expectedTitle = "Test Title";
		String content = "Test Content";

		Note note = new Note(expectedTitle, content);

		assertEquals(expectedTitle, note.getTitle());
	}

}
