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

	public void AdminMenu() {
		/* Output Admin Menu */
		Print.AdminMenu();

		choice = scan.nextInt();
		scan.nextLine();

		/* Go to users choice or ask user to input again if invalid input */
		while (true) {

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
			default:
				System.out.println("Please Input Either 1, 2, 3 or 4. Choose Again: ");
				choice = scan.nextInt();
				continue;
			}
			break;
		}

	}
}