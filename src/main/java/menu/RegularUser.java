package menu;

import java.util.Scanner;

import modifications.DeleteFromList;
import movie_and_tv_show_suggestions.SuggestMovieOrTVShow;
import movie_and_tv_show_suggestions.SuggestRandomMovieOrTVShow;
import print_statements.Print;
import view_list.ViewMovieAndTVShowList;

public class RegularUser {

	private int choice;
	private int suggest;
	private String deleted;
	private String filter;
	SuggestMovieOrTVShow suggestMovieOrTVShow = new SuggestMovieOrTVShow();
	SuggestRandomMovieOrTVShow randomMovieOrTVShow = new SuggestRandomMovieOrTVShow();

	Scanner scan = new Scanner(System.in);

	public void RegularUserMenu() {
		/* Output Regular User Menu */
		Print.RegularUserMenu();

		choice = scan.nextInt();
		scan.nextLine();

		/* Go to users choice or ask user to input again if invalid input */
		while (true) {

			switch (choice) {
			case 1:
				handleSuggestionMenu();
				break;
			case 2:
				// System.out.println("What Title Do You Want To Delete From List: ");
				randomMovieOrTVShow.randomMovieOrTVShow();
				break;
			case 3:
				ViewMovieAndTVShowList.showMovieAndTVShowList("watchlist.txt", "WatchList");

				break;
			case 4:
				System.out.println("What Title Do You Want To Delete From WatchList: ");
				deleted = scan.nextLine();
				DeleteFromList.deleteMovieOrTVShow(deleted, false, "/watchlist.txt");
				break;
			default:
				System.out.println("Please Input Either 1, 2, 3 or 4 Choose Again: ");
				choice = scan.nextInt();
				continue;
			}
			break;
		}

	}

	/* fix below */

	private void handleSuggestionMenu() {
		System.out.println("Please input number of choice do you want to filter from: \n");
		System.out.println("1.Ttile\n" + "2.Genre\n" + "3.Director\n" + "4.Year\n" + "5.Rating\n");
		suggest = scan.nextInt(); // Filter to only suggest 1-5 (Handle Exception)
		scan.nextLine();

		while (true) {
			switch (suggest) {
			case 1:
				System.out.println("\nPlease input Title do you want to filter from: ");
				filter = scan.nextLine();
				break;
			case 2:
				System.out.println("\nPlease input Genre do you want to filter from: ");
				filter = scan.nextLine();
				break;
			case 3:
				System.out.println("\nPlease input Director do you want to filter from: ");
				filter = scan.nextLine();
				break;
			case 4:
				System.out.println("\nPlease input Year do you want to filter from: ");
				filter = scan.nextLine();
				break;
			case 5:
				System.out.println("\nPlease input Rating do you want to filter from: ");
				filter = scan.nextLine();
				break;
			default:
				System.out.println("\nPlease Input Either 1, 2, 3, 4 or 5, Choose Again: ");
				suggest = scan.nextInt();
				continue;
			}
			break;
		}
		suggestMovieOrTVShow.suggestedMovieOrTVShow(filter, suggest);

	}
}
