package junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import common_functionalities.WriteToFile;
import modifications.DeleteFromList;

public class RecommendationProgramTest {

	private WriteToFile myWriteToFile;

	@BeforeEach
	void setUp() {
		myWriteToFile = new WriteToFile();
	}

	@Test
	void testDeleting() {
		assertEquals(true, DeleteFromList.deleteMovieOrTVShow("Breaking Bad", false, "/movies_and_tv_shows.txt"),
				"Deleted File Should Exist And Return True"); // Check if the movie get deleted from list
	}

	@Test
	void writingToFile() {
		assertThrows(IllegalArgumentException.class, () -> { // Check the IllegalArgumentException for writeFile()
																// method
			myWriteToFile.writeFile(null, false, "/movies_and_tv_shows.txt");
		});

	}

}
