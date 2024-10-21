package modifications;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DeleteFromList {
	static File parentDir = new File("./src/main/java"); // Get the parent directory
	static Scanner scan;
	static Boolean titleDoesExists = false;

	public static void deleteMovieOrTVShow(String Key, boolean justUpdating, String fileName) {

		// delete to newfile and rename

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
			scan.useDelimiter("[,\n]");

			while (scan.hasNext()) {
				title = scan.next();
				genre = scan.next();
				director = scan.next();
				year = scan.next();
				rating = scan.next();

				if (!title.equals(Key)) {
					pw.println(title + "," + genre + "," + director + "," + year + "," + rating);
				} else {
					titleDoesExists = true;
				}
			}

			if (oldFile.length() == 0 || !titleDoesExists) {
				System.out.println("Title Doesn't Exist In The List");
				newFile.delete();
			} else {
				oldFile.delete();
				File dump = new File(parentDir, fileName);
				newFile.renameTo(dump);
				if (!justUpdating) {
					System.out.println("Title Has Been Deleted!");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}

	}

}
