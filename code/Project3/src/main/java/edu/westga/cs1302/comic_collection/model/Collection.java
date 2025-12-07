package edu.westga.cs1302.comic_collection.model;

/**
 * Represents a collection of comics.
 * 
 * @author Mickel Ishema Murenzi
 * @version Fall 2025
 */
public class Collection {
    private String name;

    /**
     * Creates a new Collection with the specified name.
     * 
     * @precondition name != null && !name.isEmpty()
     * @postcondition getName() == name
     * 
     * @param name the name of the collection
     */
    public Collection(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    /**
     * Gets the name of the collection.
     * 
     * @return the collection name
     */
    public String getName() {
        return this.name;
    }
}
