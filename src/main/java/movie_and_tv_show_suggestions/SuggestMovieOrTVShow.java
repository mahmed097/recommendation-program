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
	File parentDir = new File("./src/main/java"); // Get the parent directory
	Scanner scan;
	Scanner scanner;
	AddToList add = new AddToList();
//	RegularUser menu = new RegularUser();

	public void suggestedMovieOrTVShow(String choice, int filter) {

		String title, genre, director;
		int year;
		double rating;

		try {
			scan = new Scanner(new File(parentDir, "/movies_and_tv_shows.txt"));
			scan.useDelimiter("[,\n]");
			scanner = new Scanner(System.in);
			Map<String, List<String>> suggestedList = new HashMap<>();

			while (scan.hasNext()) {
				title = scan.next();
				genre = scan.next();
				director = scan.next();
				year = scan.nextInt();
				rating = scan.nextDouble();

				/* rating always updates for year and not the rating itself */
				switch (filter) {
				case 1:
					if (title.equalsIgnoreCase(choice)) {
						Print.printDetails(title, genre, director, year, rating);
						suggestedList.put(title,
								Arrays.asList(title, genre, director, Integer.toString(year), Double.toString(rating)));
					}
					break;
				case 2:
					if (genre.equalsIgnoreCase(choice)) {
						Print.printDetails(title, genre, director, year, rating);
						suggestedList.put(title,
								Arrays.asList(title, genre, director, Integer.toString(year), Double.toString(rating)));
					}
					break;
				case 3:
					if (director.equalsIgnoreCase(choice)) {
						Print.printDetails(title, genre, director, year, rating);
						suggestedList.put(title,
								Arrays.asList(title, genre, director, Integer.toString(year), Double.toString(rating)));
					}
					break;
				case 4:
					if (year == Integer.valueOf(choice)) {
						Print.printDetails(title, genre, director, year, rating);
						suggestedList.put(title,
								Arrays.asList(title, genre, director, Integer.toString(year), Double.toString(rating)));
					}
					break;
				case 5:
					if (rating == Double.valueOf(choice)) {
						Print.printDetails(title, genre, director, year, rating);
						suggestedList.put(title,
								Arrays.asList(title, genre, director, Integer.toString(year), Double.toString(rating)));
					}
					break;
				}

			}

			if (suggestedList.isEmpty()) {
				System.out.println("No Title Matches That Parameters.");
			} else {

				add.addToWatchList(suggestedList);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
