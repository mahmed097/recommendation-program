package modifications;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import movies_and_tv_show.MoviesAndTVShow;

public class AddToList {

	File parentDir = new File("./src/main/java"); // Get the parent directory
	Scanner scan = new Scanner(System.in);
	MoviesAndTVShow createMovieOrTVShow = new MoviesAndTVShow();

	public void addTitleToList(boolean justUpdating, String fileName, String title, String genre, String director,
			int year, double rating) {

		createMovieOrTVShow.setTitle(title);

		createMovieOrTVShow.setGenre(genre);

		createMovieOrTVShow.setDirector(director);

		createMovieOrTVShow.setYear(year);

		createMovieOrTVShow.setRating(rating);

		addMovieOrTVShow(createMovieOrTVShow, justUpdating, fileName);

	}

	public void addTitleToList(boolean justUpdating, String fileName) {

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

		addMovieOrTVShow(createMovieOrTVShow, justUpdating, fileName);

	}

	public void addMovieOrTVShow(MoviesAndTVShow movieOrTVShowItem, boolean justUpdating, String fileName) {

		if (movieOrTVShowItem == null) {
			throw new IllegalArgumentException("Movie or TV show cannot be null");
		}

		String title = movieOrTVShowItem.getTitle();
		String genre = movieOrTVShowItem.getGenre();
		String director = movieOrTVShowItem.getDirector();
		int year = movieOrTVShowItem.getYear();
		double rating = movieOrTVShowItem.getRating();

		try (FileWriter writer = // a try catch with resources which closes FileWriter automatically
				new FileWriter(new File(parentDir, "/" + fileName), true)) {

			writer.write(title + "," + genre + "," + director + "," + year + "," + rating + "\n");
			if (!justUpdating) {
				System.out.println("Title Has Been Added!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addToWatchList(Map<String, List<String>> suggestedList) {
		boolean continueAdding = true;
		Scanner scanner = new Scanner(System.in);
		while (continueAdding) {

			if (suggestedList.isEmpty()) {
				System.out.println("No Title Matches That Parameters, Try again.");
				/*
				 * switch for the user to try again Fix this so that you handle when the list is
				 * empty
				 */

			}
			System.out.println("\nDo you want to add a title to the WatchList? (yes/no)");
			String yesOrNo = scanner.next().toLowerCase();

			if (yesOrNo.equals("yes")) {
				System.out.println("What title do you want to add to WatchList?: ");
				String titleName = scanner.next();

				if (suggestedList.get(titleName) == null) {
					System.out.println("No Title Matches That Parameters, Try again.");
				} else {
					/*
					 * Fix null-pointer error
					 * 
					 * returns null-pointer if the title is not in the map, thus we need to fix it
					 * to get an error
					 */

					String title = suggestedList.get(titleName).get(0);
					String genre = suggestedList.get(titleName).get(1);
					String director = suggestedList.get(titleName).get(2);
					String year = suggestedList.get(titleName).get(3);
					String rating = suggestedList.get(titleName).get(4);

					addTitleToList(false, "watchlist.txt", title, genre, director, Integer.valueOf(year),
							Double.valueOf(rating));
				}

			} else if (yesOrNo.equals("no")) {
				continueAdding = false; // Exit loop
			} else {
				System.out.println("Please enter 'yes' or 'no'.");
			}
		}
		scanner.close();
	}

	public void addToWatchList(String title, String genre, String director, int year, double rating) {
		boolean continueAdding = true;
		Scanner scanner = new Scanner(System.in);
		while (continueAdding) {
			System.out.println("\nDo you want to add title to the watchlist? (yes/no)");
			String yesOrNo = scanner.next().toLowerCase();

			if (yesOrNo.equals("yes")) {
				addTitleToList(false, "watchlist.txt", title, genre, director, year, rating);
				continueAdding = false;
			} else if (yesOrNo.equals("no")) {
				continueAdding = false; // Exit loop
			} else {
				System.out.println("Please enter 'yes' or 'no'.");
			}
		}
		scanner.close();
	}

}
