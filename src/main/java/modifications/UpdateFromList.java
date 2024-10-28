package modifications;

public class UpdateFromList {
	private String filePath = "movies_and_tv_shows.txt";

	public void updateMovieOrTVShow(String title) {

		if (DeleteFromList.deleteMovieOrTVShow(title, true, "/" + filePath)) { // First delete title from list
			AddToList addList = new AddToList();
			addList.addTitleToList(true, filePath); // Add updated title to list
			System.out.println("Title has been updated!");
		}
	}

}
