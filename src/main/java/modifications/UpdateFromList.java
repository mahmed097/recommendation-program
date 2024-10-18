package modifications;

public class UpdateFromList {

	public void updateMovieOrTVShow(String title) {

		DeleteFromList.deleteMovieOrTVShow(title, true);
		if (DeleteFromList.titleDoesExists) {
			AddToList addList = new AddToList(); // instance of AddToList Method
			addList.addTitleToList(true);
			System.out.println("Title Has Been Updated!");
		}
	}

}
