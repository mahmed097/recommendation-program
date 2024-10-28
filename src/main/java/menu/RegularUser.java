package menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

import common_functionalities.ReadAFile;
import modifications.DeleteFromList;
import movie_and_tv_show_suggestions.SuggestMovieOrTVShow;
import movie_and_tv_show_suggestions.SuggestRandomMovieOrTVShow;
import print_statements.Print;

public class RegularUser extends ReadAFile {

	private int choice;
	private int suggest;
	private String deleted;
	private String filter;
	SuggestMovieOrTVShow suggestMovieOrTVShow = new SuggestMovieOrTVShow();
	SuggestRandomMovieOrTVShow randomMovieOrTVShow = new SuggestRandomMovieOrTVShow();
	private Boolean running = true;

	private Scanner scan = new Scanner(System.in);

	public void regularUserMenu() {

		while (running) {
			// Output regular user menu
			Print.regularUserMenu();

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
				// Suggest a title from users filter
				handleSuggestion();
				break;
			case 2:
				// Suggest a random movie
				randomMovieOrTVShow.randomMovieOrTVShow();
				break;
			case 3:
				try {
					// View watchlist
					readFile("watchlist.txt", "WatchList");
				} catch (FileNotFoundException e) {
					System.out.println("File not found!");
					e.printStackTrace();
				}
				break;
			case 4:
				// Delete from watchlist
				System.out.println("What title do you want to delete from watchList: ");
				deleted = scan.nextLine();
				DeleteFromList.deleteMovieOrTVShow(deleted, false, "/watchlist.txt");
				break;
			case 5:
				// Go back to login menu
				running = false;
				break;
			default:
				System.out.println("Please input either 1, 2, 3, 4, 5, 6 or 7. Choose again: \n");
			}

		}
		running = true; // Reset State for running to true

	}

	private void handleSuggestion() {
		System.out.println("Please input number of choice do you want to filter from: \n");
		System.out.println("1.Ttile\n" + "2.Genre\n" + "3.Director\n" + "4.Year\n" + "5.Rating\n");

		while (true) {
			if (scan.hasNextInt()) {
				suggest = scan.nextInt();
				scan.nextLine();

				if (suggest >= 1 && suggest <= 5) {
					break;
				} else {
					System.out.println("Please input either 1, 2, 3, 4 or 5. Choose again: \n");
				}
			} else {
				scan.nextLine(); // Clear invalid input
				System.out.println("Please input either 1, 2, 3, 4 or 5. Choose again: \n");

			}
		}

		switch (suggest) {
		case 1:
			Print.filterMessage("title");
			filter = scan.nextLine();
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
