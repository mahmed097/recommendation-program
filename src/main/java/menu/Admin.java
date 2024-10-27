package menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

import common_functionalities.ListHandler;
import modifications.AddToList;
import modifications.DeleteFromList;
import modifications.UpdateFromList;
import print_statements.Print;

public class Admin extends ListHandler {

	private int choice;
	private String deleted;
	private String updatedTitle;
	private Scanner scan = new Scanner(System.in);
	AddToList addList = new AddToList(); // instance of AddToList Method
	UpdateFromList updateList = new UpdateFromList();
	private Boolean running = true;

	public void AdminMenu() {
		/* Output Admin Menu */
		while (running) {
			Print.AdminMenu();

			if (scan.hasNextInt()) {
				choice = scan.nextInt();
				scan.nextLine(); // Clear the floating newline
			} else {
				scan.nextLine(); // Clear invalid input
				System.out.println("Please Input Either 1, 2, 3, 4, 5, 6 or 7. Choose Again: \n");
				continue; // Ask for input again
			}

			/* Go to users choice or ask user to input again if invalid input */

			switch (choice) {
			case 1:
				addList.addTitleToList(false, "movies_and_tv_shows.txt");
				break;
			case 2:
				System.out.println("What Title Do You Want To Delete From List: ");
				deleted = scan.nextLine();
				DeleteFromList.deleteMovieOrTVShow(deleted, false, "/movies_and_tv_shows.txt");
				break;
			case 3:
				System.out.println("What Title Do You Want To Update From List: ");
				updatedTitle = scan.nextLine();
				updateList.updateMovieOrTVShow(updatedTitle);
				break;
			case 4:
				try {
					readFile("movies_and_tv_shows.txt", "Movie and TV Show List");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				break;
			case 5:
				running = false;
				break;
			default:
				System.out.println("Please Input Either 1, 2, 3, 4, 5, 6 or 7. Choose Again: \n");
			}

		}
		running = true; // Reset running to true for user to re-enter the admin menu later

	}
}