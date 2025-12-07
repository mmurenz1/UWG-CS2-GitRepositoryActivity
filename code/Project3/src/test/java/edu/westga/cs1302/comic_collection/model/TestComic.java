package edu.westga.cs1302.comic_collection.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests for the Comic class.
 * 
 * @author Mickel Ishema Murenzi
 * @version Fall 2025
 */
class TestComic {

    @Test
    void testConstructorWithValidData() {
        Comic comic = new Comic("Spider-Man", 1);
        assertEquals("Spider-Man", comic.getTitle());
        assertEquals(1, comic.getIssueNumber());
    }

    @Test
    void testConstructorWithNullTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Comic(null, 1);
        });
    }

    @Test
    void testConstructorWithEmptyTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Comic("", 1);
        });
    }

    @Test
    void testConstructorWithNegativeIssueNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Comic("Spider-Man", -1);
        });
    }
}