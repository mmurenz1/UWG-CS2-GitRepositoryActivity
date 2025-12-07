package edu.westga.cs1302.comic_collection.model;

/**
 * Represents a comic book.
 * 
 * @author Mickel Ishema Murenzi
 * @version Fall 2025
 */
public class Comic {
    private String title;
    private int issueNumber;

    /**
     * Creates a new Comic.
     * 
     * @param title the comic title
     * @param issueNumber the issue number
     */
    public Comic(String title, int issueNumber) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (issueNumber < 0) {
            throw new IllegalArgumentException("Issue number cannot be negative");
        }
        this.title = title;
        this.issueNumber = issueNumber;
    }

    /**
     * Gets the comic title.
     * 
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the issue number.
     * 
     * @return the issue number
     */
    public int getIssueNumber() {
        return this.issueNumber;
    }
}