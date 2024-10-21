package movie_and_tv_show_suggestions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import modifications.AddToList;
import print_statements.Print;

public class SuggestRandomMovieOrTVShow {

	File parentDir = new File("./src/main/java"); // Get the parent directory
	AddToList add = new AddToList();

	public void randomMovieOrTVShow() {
		Path file = Paths.get(parentDir + "/movies_and_tv_shows.txt");

		try {
			long count = Files.lines(file).count(); // get how many lines there are in the file
			double rand = Math.floor(Math.random() * (count - 0));// get random number from max number of lines to min
																	// number of lines
			String randomLine = Files.readAllLines(file).get((int) rand); /* Get a random line from List */
			String title, genre, director;
			int year;
			double rating;

			String[] myArray = randomLine.split(","); // Split the random line to print out to the user
			title = myArray[0];
			genre = myArray[1];
			director = myArray[2];
			year = Integer.valueOf(myArray[3]);
			rating = Double.valueOf(myArray[4]);

			Print.printDetails(title, genre, director, year, rating);

			add.addToWatchList(title, genre, director, year, rating);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
