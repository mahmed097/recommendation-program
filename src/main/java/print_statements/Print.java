package print_statements;

public class Print {

	public static void AdminMenu() {
		System.out.println("**************************************************\n"
				+ "*                     Admin                      *\n"
				+ "**************************************************\n"
				+ "                  Select Option:                   \n" + "\n"
				+ "|  1. | Add To Movie & T.V Show List\n" + "|  2. | Delete From Movie & T.V Show List\n"
				+ "|  3. | Update Movie & T.V Show List\n" + "|  4. | View List of Movie & T.V Show\n");
	}

	public static void RegularUserMenu() {
		System.out.println("**************************************************\n"
				+ "*                  Regular User                  *\n"
				+ "**************************************************\n"
				+ "                  Select Option:                   \n" + "\n"
				+ "|  1. | Suggest a Movie or T.V Show\n" + "|  2. | Choose Random Movie or T.V Show\n"
				+ "|  3. | View Watchlist\n" + "|  4. | Delete From Watchlist\n");
	}

	public static void StartingMenu() {
		System.out.println("**************************************************\n"
				+ "*                     Login                      *\n"
				+ "**************************************************\n"

				+ "                   Choose Role:                   \n" + "\n" + "|  1. | Admin\n"
				+ "|  2. | Regular User\n");
	}

	public static void PrintList(String typeOfFile) {
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
		/* Line format to have an x amount of characters wide */
		System.out.printf("%-25s | %-25s | %-25s | %-25s | %-25s%n", "Title", "Genre", "Director", "Year", "Rating");
		System.out.println("\n");

	}

	public static void printDetails(String title, String genre, String director, int year, double rating) {
		System.out.println("\nTitle: " + title + " Genre: " + genre + " Director: " + director + " Year: " + year
				+ " Rating: " + rating);
	}

}
