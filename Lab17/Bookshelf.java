package Lab17;

public class Bookshelf {
	private int size;
	private Book[] books;

	public Bookshelf() {
		size = 2;
		books = new Book[size];
		for (int i = 0; i < size; i++) {
			books[i] = null;
		}
	}

	public Bookshelf(int size) {
		this.size = size;
		this.books = new Book[size];
	}

	public Book[] getBooks() {
		return books;
	}

	public int getSize() {
		return size;
	}

	public void addBook(Book book) {
		for (int i = 0; i < books.length; i++) {
			if (books[i] == null) {
				books[i] = book;
				break;
			}
		}
	}

	public void removeBook(int position) {
		books[position] = null;
	}

	public void emptyBookshelf() {
		for (int i = 0; i < books.length; i++)
			books[i] = null;
	}
}
