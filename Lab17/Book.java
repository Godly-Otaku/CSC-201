package Lab17;

public class Book {
	private String title;
	private String[] authors;

	public Book() {
		title = "Test";
	}

	public Book(String title, String[] authors) {
		this.title = title;
		this.authors = authors;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String[] getAuthors() {
		return authors;
	}

	public String getTitle() {
		return title;
	}

	public String toString() {
		String allAuthors = "";
		if (authors.length > 1) {
			for (int i = 0; i < authors.length; i++) {
				if (i != authors.length - 1)
					allAuthors += authors[i] + " & ";
				else
					allAuthors += authors[i];
			}
		} else {
			allAuthors = authors[0];
		}
		return "\"" + title + "\" by " + allAuthors;
	}
}
