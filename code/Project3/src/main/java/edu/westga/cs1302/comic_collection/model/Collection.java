package edu.westga.cs1302.comic_collection.model;

import java.util.ArrayList;

/**
 * Represents a collection of comics.
 * 
 * @author Mickel Ishema Murenzi
 * @version Fall 2025
 */
public class Collection {
    private String name;
    private ArrayList<Comic> comics;

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
        this.comics = new ArrayList<Comic>();
    }

    /**
     * Gets the name of the collection.
     * 
     * @return the collection name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the list of comics in this collection.
     * 
     * @return the list of comics
     */
    public ArrayList<Comic> getComics() {
        return this.comics;
    }

    /**
     * Adds a comic to this collection.
     * 
     * @param comic the comic to add
     */
    public void addComic(Comic comic) {
        if (comic == null) {
            throw new IllegalArgumentException("Comic cannot be null");
        }
        this.comics.add(comic);
    }

    /**
     * Removes a comic from this collection.
     * 
     * @param comic the comic to remove
     */
    public void removeComic(Comic comic) {
        this.comics.remove(comic);
    }
}