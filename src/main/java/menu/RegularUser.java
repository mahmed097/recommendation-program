package menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

import common_functionalities.ListHandler;
import modifications.DeleteFromList;
import movie_and_tv_show_suggestions.SuggestMovieOrTVShow;
import movie_and_tv_show_suggestions.SuggestRandomMovieOrTVShow;
import print_statements.Print;

public class RegularUser extends ListHandler {

	private int choice;
	private int suggest;
	private String deleted;
	private String filter;
	SuggestMovieOrTVShow suggestMovieOrTVShow = new SuggestMovieOrTVShow();
	SuggestRandomMovieOrTVShow randomMovieOrTVShow = new SuggestRandomMovieOrTVShow();
	private Boolean running = true;

	private Scanner scan = new Scanner(System.in);

	public void RegularUserMenu() {
		while (running) {
			/* Output Regular User Menu */
			Print.RegularUserMenu();

			if (scan.hasNextInt()) { // Were handling error here
				choice = scan.nextInt();
				scan.nextLine(); // Clear the newline
			} else {
				scan.nextLine(); // Clear invalid input
				System.out.println("Please Input Either 1, 2, 3, 4, 5, 6 or 7. Choose Again: \n");
				continue; // Ask for input again
			}

			/* Go to users choice or ask user to input again if invalid input */

			switch (choice) {
			case 1:
				handleSuggestion();
				break;
			case 2:
				// System.out.println("What Title Do You Want To Delete From List: ");
				randomMovieOrTVShow.randomMovieOrTVShow();
				break;
			case 3:
				try {
					readFile("watchlist.txt", "WatchList");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("What Title Do You Want To Delete From WatchList: ");
				deleted = scan.nextLine();
				DeleteFromList.deleteMovieOrTVShow(deleted, false, "/watchlist.txt");
				break;
			case 5:
				running = false;
				break;
			default:
				System.out.println("Please Input Either 1, 2, 3, 4, 5, 6 or 7. Choose Again: \n");
			}

		}
		running = true; // Reset running to true for user to re-enter the Regular user menu later
						// (handling state)

	}

	private void handleSuggestion() {
		System.out.println("Please input number of choice do you want to filter from: \n");
		System.out.println("1.Ttile\n" + "2.Genre\n" + "3.Director\n" + "4.Year\n" + "5.Rating\n");

		while (true) {
			if (scan.hasNextInt()) { // Were handling error here
				suggest = scan.nextInt();
				scan.nextLine(); // Clear the newline

				if (suggest >= 1 && suggest <= 5) {
					break;
				} else {
					System.out.println("Please Input Either 1, 2, 3, 4 or 5. Choose Again: \n");
				}
			} else {
				scan.nextLine(); // Clear invalid input
				System.out.println("Please Input Either 1, 2, 3, 4 or 5. Choose Again: \n");

			}
		}

		switch (suggest) {
		case 1:
			Print.filterMessage("title");
			filter = scan.nextLine(); // handle input mismatch exception
			break;
		case 2:
			Print.filterMessage("genre");
			filter = scan.nextLine();
			break;
		case 3:
			Print.filterMessage("director");
			filter = scan.nextLine();
			break;
		case 4:
			Print.filterMessage("year");
			filter = scan.nextLine();
			break;
		case 5:
			Print.filterMessage("rating");
			filter = scan.nextLine();
			break;

		}

		suggestMovieOrTVShow.suggestedMovieOrTVShow(filter, suggest);

	}
}
