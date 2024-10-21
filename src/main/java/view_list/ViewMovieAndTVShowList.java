package view_list;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import print_statements.Print;

public class ViewMovieAndTVShowList {
	static File parentDir = new File("./src/main/java"); // Get the parent directory
	static Scanner scan;

	public static void showMovieAndTVShowList(String fileName, String typeOfFile) {
		Print.PrintList(typeOfFile);

		try {
			scan = new Scanner(new File(parentDir, fileName));

			scan.useDelimiter("[,\n]"); // used to specify the pattern that separates the words (normally a whitespace)

			String title = "";
			String genre = "";
			String director = "";
			String year = "";
			String rating = "";

			while (scan.hasNext()) {
				title = scan.next();
				genre = scan.next();
				director = scan.next();
				year = scan.next();
				rating = scan.next();

				System.out.printf("%-27s %-27s %-27s %-27s %-27s%n", title, genre, director, year, rating);

			}
			scan.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
