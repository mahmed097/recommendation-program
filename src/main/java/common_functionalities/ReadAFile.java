package common_functionalities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import print_statements.Print;

public class ReadAFile {

	public final static File parentDir = new File("./src/main/java");

	public static void readFile(String fileName, String typeOfFile) throws FileNotFoundException {

		Scanner scan;

		scan = new Scanner(new File(parentDir, fileName));

		scan.useDelimiter(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)|\n"); // Split by commas, quotations and
		// new line but exclude the
		// what's inside the quotations
		// commas in the quotes

		String title = "";
		String genre = "";
		String director = "";
		String year = "";
		String rating = "";

		Print.printList(typeOfFile);

		while (scan.hasNext()) {
			title = scan.next();
			title = title.substring(1, title.length() - 1);
			genre = scan.next();
			genre = genre.substring(1, genre.length() - 1);
			director = scan.next();
			director = director.substring(1, director.length() - 1);
			year = scan.next();
			rating = scan.next();

			System.out.printf("%-27s %-27s %-27s %-27s %-27s%n", title, genre, director, year, rating); // Print titles
																										// to console
		}
		scan.close();

	}

}
