package modifications;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import common_functionalities.ListHandler;

public class DeleteFromList extends ListHandler {

	private static Scanner scan;
	private static Boolean titleDoesExists = false;

	public static boolean deleteMovieOrTVShow(String Key, boolean justUpdating, String fileName) {
		titleDoesExists = false;
		String tempFile = "temp.txt";
		File oldFile = new File(parentDir, fileName);
		File newFile = new File(tempFile);

		String title = "";
		String genre = "";
		String director = "";
		String year = "";
		String rating = "";

		try (FileWriter fw = new FileWriter(tempFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);) { // a try catch with resources which closes FileWriter,
															// BufferWriter, PrintWriter automatically

			scan = new Scanner(new File(parentDir, fileName));
			scan.useDelimiter(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)|\n"); // Change the delimiter pattern to split for
																		// every comma, brackets or line breaks

			while (scan.hasNext()) {
				title = scan.next();
				genre = scan.next();
				director = scan.next();
				year = scan.next();
				rating = scan.next();

				if (!(title.substring(1, title.length() - 1)).equals(Key)) { // Writing all the titles that aren't the
																				// title that the user wants to delete
																				// in a new file
					pw.println(title + "," + genre + "," + director + "," + year + "," + rating);
				} else {
					titleDoesExists = true;
				}
			}

			if (oldFile.length() == 0 || !titleDoesExists) { // If File is empty or title doesn't exist in list
				System.out.println("Title Doesn't Exist In The List");
				deleteFile(newFile);
			} else {
				deleteFile(oldFile);
				renameFile(oldFile, newFile);
				if (!justUpdating) {
					System.out.println("Title Has Been Deleted!");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
		return titleDoesExists;
	}

}
