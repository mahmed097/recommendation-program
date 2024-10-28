package menu;

import java.util.Scanner;

import print_statements.Print;

public class Start {

	private int choice;
	private Scanner scan = new Scanner(System.in);
	Admin admin = new Admin();
	RegularUser regularUser = new RegularUser();
	private Boolean running = true;

	public void startingMenu() {

		while (running) {
			// Print Out Login Menu
			Print.startingMenu();

			if (scan.hasNextInt()) {
				choice = scan.nextInt();
				scan.nextLine();
			} else {
				scan.nextLine(); // Clear invalid input
				System.out.println("Please input either 1, 2 or 3. Choose again: \n");
				continue; // Ask for input again
			}

			// Go to users choice or ask user to input again if invalid input

			switch (choice) {
			case 1:
				// Go to admin menu
				admin.adminMenu();
				break;
			case 2:
				// Go to regular user menu
				regularUser.regularUserMenu();
				break;
			case 3:
				// Exit program
				running = false;
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Please input either 1, 2 or 3. Choose again: \n");
			}

		}
		running = true;
		scan.close();
	}

}
