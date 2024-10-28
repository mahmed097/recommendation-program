package movie_and_tv_show_suggestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import modifications.AddToList;
import print_statements.Print;

public class SuggestMovieOrTVShow {
	Scanner scan;
	Scanner scanner;
	AddToList add = new AddToList();
	private final static File parentDir = new File("./src/main/java");

	public void suggestedMovieOrTVShow(String filter, int suggest) {

		String title, genre, director;
		int year;
		double rating;
		Map<String, List<String>> suggestedList;

		try {
			scan = new Scanner(new File(parentDir, "/movies_and_tv_shows.txt"));
			scan.useDelimiter(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)|\n"); // Split by commas, quotations and
			// new line but exclude the
			// what's inside the quotations
			// commas in the quotes
			scanner = new Scanner(System.in);
			suggestedList = new HashMap<>();

			while (scan.hasNext()) { // Scan file
				title = scan.next();
				genre = scan.next();
				director = scan.next();
				year = scan.nextInt();
				rating = scan.nextDouble();

				// Removing quotes from title, genre and director
				String cleanTitle = title.substring(1, title.length() - 1);
				String cleanGenre = genre.substring(1, genre.length() - 1);
				String cleanDirector = director.substring(1, director.length() - 1);

				// Filter based on user choice
				switch (suggest) {
				case 1:
					if (cleanTitle.equalsIgnoreCase(filter)) {

						printTitleAndPutInSuggestedList(cleanTitle, cleanGenre, cleanDirector, year, rating,
								suggestedList);
					}
					break;
				case 2:
					if (cleanGenre.equalsIgnoreCase(filter)) {
						printTitleAndPutInSuggestedList(cleanTitle, cleanGenre, cleanDirector, year, rating,
								suggestedList);
					}
					break;
				case 3:
					if (cleanDirector.equalsIgnoreCase(filter)) {
						printTitleAndPutInSuggestedList(cleanTitle, cleanGenre, cleanDirector, year, rating,
								suggestedList);
					}
					break;
				case 4:
					if (year == Integer.valueOf(filter)) {
						printTitleAndPutInSuggestedList(cleanTitle, cleanGenre, cleanDirector, year, rating,
								suggestedList);
					}
					break;
				case 5:
					if (rating == Double.valueOf(filter)) {
						printTitleAndPutInSuggestedList(cleanTitle, cleanGenre, cleanDirector, year, rating,
								suggestedList);
					}
					break;
				}

			}

			if (suggestedList.isEmpty()) {
				System.out.println("No title matches that parameters.");
			} else {

				add.addToWatchList(suggestedList);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println(
					"Invalid input. Please enter a string for Title, Genre, Director, a Integer for Year and a Double value for Rating!");
		}
	}

	// Print filtered details and put the title in suggested list
	private static void printTitleAndPutInSuggestedList(String title, String genre, String director, int year,
			double rating, Map<String, List<String>> suggestedList) {
		Print.printDetails(title, genre, director, year, rating);

		suggestedList.put(title,
				Arrays.asList(title, genre, director, Integer.toString(year), Double.toString(rating)));

	}

}
