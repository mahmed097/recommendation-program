package menu;

import java.util.Scanner;

import print_statements.Print;

public class Start {

	private int choice;
	Scanner scan = new Scanner(System.in);
	Admin admin = new Admin();
	RegularUser regularUser = new RegularUser();
	Boolean running = true;

	public void StartingMenu() {
		while (running) {
			/* Print Out Starting Menu */
			Print.StartingMenu();

			if (scan.hasNextInt()) { // were handling error here
				choice = scan.nextInt();
				scan.nextLine(); // Clear the newline
			} else {
				scan.nextLine(); // Clear invalid input
				continue; // Ask for input again
			}

			// fix state so you can use switch case statements again

			/* Go to users choice or ask user to input again if invalid input */

			switch (choice) {
			case 1:
				admin.AdminMenu();
				break;
			case 2:
				regularUser.RegularUserMenu();
				break;
			case 3:
				running = false;
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Please Input Either 1, 2 or 3. Choose Again: \n");
			}

		}
		scan.close();
	}

}
