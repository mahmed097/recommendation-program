package modifications;

public class UpdateFromList {

	public void updateMovieOrTVShow(String title) {

		DeleteFromList.deleteMovieOrTVShow(title, true, "/movies_and_tv_shows.txt");
		if (DeleteFromList.titleDoesExists) {
			AddToList addList = new AddToList(); // instance of AddToList Method
			addList.addTitleToList(true, "movies_and_tv_shows.txt");
			System.out.println("Title Has Been Updated!");
		}
	}

}
