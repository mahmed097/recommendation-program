package modifications;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import common_functionalities.DeleteOrRenameFile;

public class DeleteFromList extends DeleteOrRenameFile {

	private static Scanner scan;
	private static Boolean titleDoesExists = false;

	public static boolean deleteMovieOrTVShow(String Key, boolean justUpdating, String fileName) {
		titleDoesExists = false; // Reset state for titleDoesExists
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
				PrintWriter pw = new PrintWriter(bw);) { // A try catch with resources which closes FileWriter,
															// BufferWriter, PrintWriter automatically

			scan = new Scanner(new File(parentDir, fileName));
			scan.useDelimiter(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)|\n"); // Split by commas, quotations and
			// new line but exclude the
			// what's inside the quotations
			// commas in the quotes

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

			if (oldFile.length() == 0 || !titleDoesExists) { // If file is empty or title doesn't exist in list
				System.out.println("Title doesn't exist in the list");
				deleteFile(newFile);
			} else {
				deleteFile(oldFile);
				renameFile(oldFile, newFile);
				if (!justUpdating) {
					System.out.println("Title has been deleted!");
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
