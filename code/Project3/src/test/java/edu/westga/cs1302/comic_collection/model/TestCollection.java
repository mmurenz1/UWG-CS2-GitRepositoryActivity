package edu.westga.cs1302.comic_collection.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests for the Collection class.
 * 
 * @author Mickel Ishema Murenzi
 * @version Fall 2025
 */
class TestCollection {

    @Test
    void testConstructorWithValidName() {
        Collection collection = new Collection("Marvel Comics");
        assertEquals("Marvel Comics", collection.getName());
    }

    @Test
    void testConstructorWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Collection(null);
        });
    }

    @Test
    void testConstructorWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Collection("");
        });
    }
    
    @Test
    void testAddComic() {
        Collection collection = new Collection("Marvel");
        Comic comic = new Comic("Spider-Man", 1);
        
        collection.addComic(comic);
        
        assertEquals(1, collection.getComics().size());
        assertEquals(comic, collection.getComics().get(0));
    }

    @Test
    void testAddNullComic() {
        Collection collection = new Collection("Marvel");
        
        assertThrows(IllegalArgumentException.class, () -> {
            collection.addComic(null);
        });
    }

    @Test
    void testRemoveComic() {
        Collection collection = new Collection("Marvel");
        Comic comic = new Comic("Spider-Man", 1);
        collection.addComic(comic);
        
        collection.removeComic(comic);
        
        assertEquals(0, collection.getComics().size());
    }
}
