package print_statements;

public class Print {

	public static void adminMenu() {
		System.out.println("**************************************************\n"
				+ "*                     Admin                      *\n"
				+ "**************************************************\n"
				+ "                  Select Option:                   \n" + "\n"
				+ "|  1. | Add To Movie & T.V Show List\n" + "|  2. | Delete From Movie & T.V Show List\n"
				+ "|  3. | Update Movie & T.V Show List\n" + "|  4. | View List of Movies & T.V Shows\n"
				+ "|  5. | Go Back\n");
	}

	public static void regularUserMenu() {
		System.out.println("**************************************************\n"
				+ "*                  Regular User                  *\n"
				+ "**************************************************\n"
				+ "                  Select Option:                   \n" + "\n"
				+ "|  1. | Suggest a Movie or T.V Show\n" + "|  2. | Choose Random Movie or T.V Show\n"
				+ "|  3. | View Watchlist\n" + "|  4. | Delete From Watchlist\n" + "|  5. | Go Back\n");
	}

	public static void startingMenu() {
		System.out.println("**************************************************\n"
				+ "*                     Login                      *\n"
				+ "**************************************************\n"

				+ "                   Choose Role:                   \n" + "\n" + "|  1. | Admin\n"
				+ "|  2. | Regular User\n" + "|  3. | Exit Program\n");
	}

	public static void printList(String typeOfFile) {
		if (typeOfFile.equals("WatchList")) {
			System.out.println(
					"**************************************************************************************************************************\n"
							+ "*                                                      " + typeOfFile
							+ "                                                         *\n"
							+ "**************************************************************************************************************************\n");
		} else {
			System.out.println(
					"**************************************************************************************************************************\n"
							+ "*                                                 " + typeOfFile
							+ "                                                 *\n"
							+ "**************************************************************************************************************************\n");
		}
		// Line format to have an x amount of characters wide
		System.out.printf("%-25s | %-25s | %-25s | %-25s | %-25s%n", "Title", "Genre", "Director", "Year", "Rating");
		System.out.println("\n");

	}

	public static void printDetails(String title, String genre, String director, int year, double rating) {
		System.out.println("\nTitle: " + title + " Genre: " + genre + " Director: " + director + " Year: " + year
				+ " Rating: " + rating);
	}

	public static void filterMessage(String filter) {
		System.out.println("\nPlease input " + filter + " that you want to filter from: ");
	}

}
