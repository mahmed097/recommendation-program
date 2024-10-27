package junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import common_functionalities.ListHandler;
import modifications.DeleteFromList;

public class RecommendationProgramTest {

	@Test
	void testDeleting() {
		assertEquals(true, DeleteFromList.deleteMovieOrTVShow("Breaking Bad", false, "/movies_and_tv_shows.txt"), // Fix
																													// Breaking
																													// Bad
				"Deleted File Should Exist And Return True"); // Check if the movie get deleted from list
	}

	@Test
	void readingFile() {
		assertThrows(FileNotFoundException.class, () -> { // Check the FileNotFoundException for readFile() method
			ListHandler.readFile("test.txt", "Test File");
		});

	}

}
