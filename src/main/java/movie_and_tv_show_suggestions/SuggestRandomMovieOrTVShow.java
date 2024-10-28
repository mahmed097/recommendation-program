package movie_and_tv_show_suggestions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import modifications.AddToList;
import print_statements.Print;

public class SuggestRandomMovieOrTVShow {

	AddToList add = new AddToList();
	private final static File parentDir = new File("./src/main/java");

	public void randomMovieOrTVShow() {
		Path file = Paths.get(parentDir + "/movies_and_tv_shows.txt");

		try {
			long count = Files.lines(file).count(); // Get how many lines there are in the file
			double rand = Math.floor(Math.random() * (count - 0));
			String randomLine = Files.readAllLines(file).get((int) rand); // Get a random line from List
			String title, genre, director;
			int year;
			double rating;

			String[] myArray = randomLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // Split by commas, quotations and
																						// new line but exclude the
																						// what's inside the quotations

			title = myArray[0];
			title = title.substring(1, title.length() - 1); // Remove Quotes
			genre = myArray[1];
			genre = genre.substring(1, genre.length() - 1);
			director = myArray[2];
			director = director.substring(1, director.length() - 1);
			year = Integer.valueOf(myArray[3]);
			rating = Double.valueOf(myArray[4]);

			Print.printDetails(title, genre, director, year, rating);

			add.addToWatchList(title, genre, director, year, rating);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
