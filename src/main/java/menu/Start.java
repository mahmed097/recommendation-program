package menu;

import java.util.Scanner;

import print_statements.Print;

public class Start {

	private int choice;
	Scanner scan = new Scanner(System.in);
	Admin admin = new Admin();

	public void StartingMenu() {

		/* Print Out Starting Menu */
		Print.StartingMenu();

		choice = scan.nextInt();

		/* Go to users choice or ask user to input again if invalid input */
		while (true) {

			switch (choice) {
			case 1:
				admin.AdminMenu();
				break;
			case 2:
				RegularUser.RegularUserMenu();
				break;
			default:
				System.out.println("Please Input Either 1 or 2. Choose Again: ");
				choice = scan.nextInt();
				continue;
			}
			break;
		}

	}

}
