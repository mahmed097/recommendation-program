package menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

import common_functionalities.ReadAFile;
import modifications.AddToList;
import modifications.DeleteFromList;
import modifications.UpdateFromList;
import print_statements.Print;

public class Admin extends ReadAFile {

	private int choice;
	private String deleted;
	private String updatedTitle;
	private Scanner scan = new Scanner(System.in);
	AddToList addList = new AddToList();
	UpdateFromList updateList = new UpdateFromList();
	private Boolean running = true;

	public void adminMenu() {
		// Output admin menu
		while (running) {

			Print.adminMenu();

			if (scan.hasNextInt()) {
				choice = scan.nextInt();
				scan.nextLine();
			} else {
				scan.nextLine(); // Clear invalid input
				System.out.println("Please input either 1, 2, 3, 4, 5, 6 or 7. Choose again: \n");
				continue; // Ask for input again
			}

			// Go to users choice or ask user to input again if invalid input

			switch (choice) {
			case 1:
				// Add to List
				addList.addTitleToList(false, "movies_and_tv_shows.txt");
				break;
			case 2:
				// Delete from list
				System.out.println("What title do you want to delete from list: ");
				deleted = scan.nextLine();
				DeleteFromList.deleteMovieOrTVShow(deleted, false, "/movies_and_tv_shows.txt");
				break;
			case 3:
				// Update the list
				System.out.println("What title do you want to update from list: ");
				updatedTitle = scan.nextLine();
				updateList.updateMovieOrTVShow(updatedTitle);
				break;
			case 4:
				try {
					// View the list
					readFile("movies_and_tv_shows.txt", "Movie and TV Show List");
				} catch (FileNotFoundException e) {
					System.out.println("File not found!");
					e.printStackTrace();
				}

				break;
			case 5:
				// Go back to login menu
				running = false;
				break;
			default:
				System.out.println("Please input either 1, 2, 3, 4, 5, 6 or 7. Choose sgain: \n");
			}

		}
		running = true; // Reset the state for running to true

	}
}