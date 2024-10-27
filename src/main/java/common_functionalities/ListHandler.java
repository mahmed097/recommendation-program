package common_functionalities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import movies_and_tv_show.MoviesAndTVShow;
import print_statements.Print;

public class ListHandler {

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
				System.out.println("Title Has Been Added!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean deleteFile(File fileName) {

		return fileName.delete();

	}

	public static boolean renameFile(File oldFile, File newFile) {
		return newFile.renameTo(oldFile);
	}

	public static void readFile(String fileName, String typeOfFile) throws FileNotFoundException {

		Scanner scan;

		scan = new Scanner(new File(parentDir, fileName));

		scan.useDelimiter(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)|\n"); // Change the delimiter pattern to split for
																	// every comma, brackets or line breaks

		String title = "";
		String genre = "";
		String director = "";
		String year = "";
		String rating = "";

		Print.PrintList(typeOfFile);
		while (scan.hasNext()) {
			title = scan.next();
			title = title.substring(1, title.length() - 1);
			genre = scan.next();
			genre = genre.substring(1, genre.length() - 1);
			director = scan.next();
			director = director.substring(1, director.length() - 1);
			year = scan.next();
			rating = scan.next();

			System.out.printf("%-27s %-27s %-27s %-27s %-27s%n", title, genre, director, year, rating);

		}
		scan.close();

	}

}
