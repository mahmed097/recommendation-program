package common_functionalities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import movies_and_tv_show.MoviesAndTVShow;

public class WriteToFile {

	public final static File parentDir = new File("./src/main/java");

	public void writeFile(MoviesAndTVShow movieOrTVShowItem, boolean justUpdating, String fileName) {

		if (movieOrTVShowItem == null) {
			throw new IllegalArgumentException("Movie or TV show cannot be null");
		}

		String title = movieOrTVShowItem.getTitle();
		String genre = movieOrTVShowItem.getGenre();
		String director = movieOrTVShowItem.getDirector();
		int year = movieOrTVShowItem.getYear();
		double rating = movieOrTVShowItem.getRating();

		try (FileWriter writer = new FileWriter(new File(parentDir, "/" + fileName), true)) {

			writer.write(title + "," + genre + "," + director + "," + year + "," + rating + "\n"); // Write title to
																									// designated file
			if (!justUpdating) {
				System.out.println("Title has been added!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
