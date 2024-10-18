package modifications;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import movies_and_tv_show.MoviesAndTVShow;

public class AddToList {

	File parentDir = new File("./src/main/java"); // Get the parent directory
	Scanner scan = new Scanner(System.in);
	MoviesAndTVShow createMovieOrTVShow = new MoviesAndTVShow();

	public void addTitleToList(boolean justUpdating) {

		System.out.println("Please Input Title, Genre, Director, Year and Rating of Movie or T.V Show");

		System.out.println("Title: ");
		createMovieOrTVShow.setTitle(scan.nextLine());

		System.out.println("Genre: ");
		createMovieOrTVShow.setGenre(scan.nextLine());

		System.out.println("Director: ");
		createMovieOrTVShow.setDirector(scan.nextLine());

		System.out.println("Year: ");
		createMovieOrTVShow.setYear(scan.nextInt());
		scan.nextLine();

		System.out.println("Rating: ");
		createMovieOrTVShow.setRating(scan.nextDouble());
		scan.nextLine();

		addMovieOrTVShow(createMovieOrTVShow, justUpdating);

	}

	public void addMovieOrTVShow(MoviesAndTVShow movieOrTVShowItem, boolean justUpdating) {

		if (movieOrTVShowItem == null) {
			throw new IllegalArgumentException("Movie or TV show cannot be null");
		}

		String title = movieOrTVShowItem.getTitle();
		String genre = movieOrTVShowItem.getGenre();
		String director = movieOrTVShowItem.getDirector();
		int year = movieOrTVShowItem.getYear();
		double rating = movieOrTVShowItem.getRating();

		try (FileWriter writer = // a try catch with resources which closes FileWriter automatically
				new FileWriter(new File(parentDir, "/movies_and_tv_shows.txt"), true)) {

			writer.write(title + "," + genre + "," + director + "," + year + "," + rating + "\n");
			if (!justUpdating) {
				System.out.println("Title Has Been Added!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
