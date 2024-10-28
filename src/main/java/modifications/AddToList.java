package modifications;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import common_functionalities.WriteToFile;
import movies_and_tv_show.MoviesAndTVShow;

public class AddToList extends WriteToFile {

	Scanner scan = new Scanner(System.in);
	MoviesAndTVShow createMovieOrTVShow = new MoviesAndTVShow();
	private boolean isInputValid = false;

	public void addTitleToList(boolean justUpdating, String fileName, String title, String genre, String director,
			int year, double rating) {

		createMovieOrTVShow.setTitle("\"" + title + "\"");

		createMovieOrTVShow.setGenre("\"" + genre + "\"");

		createMovieOrTVShow.setDirector("\"" + director + "\"");

		createMovieOrTVShow.setYear(year);

		createMovieOrTVShow.setRating(rating);

		writeFile(createMovieOrTVShow, justUpdating, fileName); // Add title to desired file

	}

	public void addTitleToList(boolean justUpdating, String fileName) {

		while (!isInputValid) {
			try {
				System.out.println("Please input title, genre, director, year and rating of Movie or T.V Show:");

				System.out.println("Title: ");
				createMovieOrTVShow.setTitle("\"" + scan.nextLine() + "\"");

				System.out.println("Genre: ");
				createMovieOrTVShow.setGenre("\"" + scan.nextLine() + "\"");

				System.out.println("Director: ");
				createMovieOrTVShow.setDirector("\"" + scan.nextLine() + "\"");

				System.out.println("Year: ");
				createMovieOrTVShow.setYear(scan.nextInt());
				scan.nextLine();

				System.out.println("Rating: ");
				createMovieOrTVShow.setRating(scan.nextDouble());
				scan.nextLine();

				writeFile(createMovieOrTVShow, justUpdating, fileName); // Add title to desired file
				isInputValid = true;
			} catch (InputMismatchException e) {
				System.out.println(
						"Invalid input. Please enter a string for Title, Genre, Director, a Integer for Year and a Double value for Rating!");
				scan.nextLine();
			}
		}

		isInputValid = false; // Reset state for isInputValid
	}

	public void addToWatchList(Map<String, List<String>> suggestedList) {
		boolean continueAdding = true;

		while (continueAdding) {

			System.out.println("\nDo you want to add a title to the WatchList? (yes/no)");
			String yesOrNo = scan.next().toLowerCase();

			if (yesOrNo.equals("yes")) {
				System.out.println("What title do you want to add to WatchList?: ");
				scan.nextLine();
				String titleName = scan.nextLine();
				if (suggestedList.get(titleName) == null) {
					System.out.println("No title matches in the filtered list, try again!");
				} else {

					// Get title from suggestedList and put it into the watchlist file
					String title = suggestedList.get(titleName).get(0);
					String genre = suggestedList.get(titleName).get(1);
					String director = suggestedList.get(titleName).get(2);
					String year = suggestedList.get(titleName).get(3);
					String rating = suggestedList.get(titleName).get(4);

					addTitleToList(false, "watchlist.txt", title, genre, director, Integer.valueOf(year),
							Double.valueOf(rating));
					continueAdding = false;
				}

			} else if (yesOrNo.equals("no")) {
				continueAdding = false; // Exit loop
			} else {
				System.out.println("Please enter 'yes' or 'no'.");
			}
		}

	}

	public void addToWatchList(String title, String genre, String director, int year, double rating) {
		boolean continueAdding = true;

		while (continueAdding) {
			System.out.println("\nDo you want to add title to the watchlist? (yes/no)");
			String yesOrNo = scan.next().toLowerCase();

			if (yesOrNo.equals("yes")) {
				addTitleToList(false, "watchlist.txt", title, genre, director, year, rating);
				continueAdding = false;
			} else if (yesOrNo.equals("no")) {
				continueAdding = false; // Exit loop
			} else {
				System.out.println("Please enter 'yes' or 'no'.");
			}
		}

	}

}
