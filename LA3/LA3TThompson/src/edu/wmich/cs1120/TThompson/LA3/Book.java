package edu.wmich.cs1120.TThompson.LA3;

public class Book extends Library {

	private String title;
	private String author;
	private String genre;

	
	/**
	 * Book constructor. information about the book.
	 * @param title
	 * @param author
	 * @param genre
	 */
	public Book(String title, String author, String genre) {
		this.setTitle(title);
		this.setAuthor(author);
		this.setGenre(genre);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
