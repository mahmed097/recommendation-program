package menu;

import java.util.Scanner;

import modifications.AddToList;
import modifications.DeleteFromList;
import modifications.UpdateFromList;
import print_statements.Print;
import view_list.ViewMovieAndTVShowList;

public class Admin {

	private int choice;
	String deleted;
	String updatedTitle;
	static Scanner scan = new Scanner(System.in);
	AddToList addList = new AddToList(); // instance of AddToList Method
	UpdateFromList updateList = new UpdateFromList();
	Boolean running = true;

	public void AdminMenu() {
		/* Output Admin Menu */
		while (running) {
			Print.AdminMenu();

			if (scan.hasNextInt()) { // were handling error here
				choice = scan.nextInt();
				scan.nextLine(); // Clear the newline
			} else {
				scan.nextLine(); // Clear invalid input
				continue; // Ask for input again
			}

			/* Go to users choice or ask user to input again if invalid input */
			// fix this so that it works in the second iterration

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
				ViewMovieAndTVShowList.showMovieAndTVShowList("/movies_and_tv_shows.txt", "Movie and TV Show List");
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