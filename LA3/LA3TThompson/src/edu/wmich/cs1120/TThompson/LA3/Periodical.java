package edu.wmich.cs1120.TThompson.LA3;

public class Periodical extends Library {

	private String title;
	private String volume;
	private String issue;
	private String subject;

	/**
	 * Periodical constructor. Information about the periodical.
	 * @param title
	 * @param volume
	 * @param issue
	 * @param subject
	 */
	public Periodical(String title, String volume, String issue, String subject) {
		this.setTitle(title);
		this.setVolume(volume);
		this.setIssue(issue);
		this.setSubject(subject);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
