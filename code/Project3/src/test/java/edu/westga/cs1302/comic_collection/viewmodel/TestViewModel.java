package edu.westga.cs1302.comic_collection.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Collection;

import edu.westga.cs1302.comic_collection.model.Comic;

/**
 * Tests for the ViewModel class.
 * 
 * @author Mickel Ishema Murenzi
 * @version Fall 2025
 */
class TestViewModel {

    @Test
    void testConstructor() {
        ViewModel vm = new ViewModel();
        
        assertEquals("", vm.collectionNameProperty().get());
        assertEquals(0, vm.getCollections().size());
        assertNull(vm.getSelectedCollection());
    }

    @Test
    void testAddCollection() {
        ViewModel vm = new ViewModel();
        vm.collectionNameProperty().set("Marvel");
        
        vm.addCollection();
        
        assertEquals(1, vm.getCollections().size());
        assertEquals("Marvel", vm.getCollections().get(0).getName());
        assertEquals("", vm.collectionNameProperty().get());
    }

    @Test
    void testAddMultipleCollections() {
        ViewModel vm = new ViewModel();
        
        vm.collectionNameProperty().set("Marvel");
        vm.addCollection();
        
        vm.collectionNameProperty().set("DC");
        vm.addCollection();
        
        assertEquals(2, vm.getCollections().size());
        assertEquals("Marvel", vm.getCollections().get(0).getName());
        assertEquals("DC", vm.getCollections().get(1).getName());
    }

    @Test
    void testRemoveSelectedCollection() {
        ViewModel vm = new ViewModel();
        vm.collectionNameProperty().set("Marvel");
        vm.addCollection();
        
        Collection toRemove = vm.getCollections().get(0);
        vm.setSelectedCollection(toRemove);
        vm.removeSelectedCollection();
        
        assertEquals(0, vm.getCollections().size());
        assertNull(vm.getSelectedCollection());
    }

    @Test
    void testRemoveWithNoSelection() {
        ViewModel vm = new ViewModel();
        vm.collectionNameProperty().set("Marvel");
        vm.addCollection();
        
        vm.removeSelectedCollection();
        
        assertEquals(1, vm.getCollections().size());
    }

    @Test
    void testSetSelectedCollection() {
        ViewModel vm = new ViewModel();
        vm.collectionNameProperty().set("Marvel");
        vm.addCollection();
        
        Collection collection = vm.getCollections().get(0);
        vm.setSelectedCollection(collection);
        
        assertEquals(collection, vm.getSelectedCollection());
    }
    
    @Test
    void testAddComic() {
        ViewModel vm = new ViewModel();
        vm.collectionNameProperty().set("Marvel");
        vm.addCollection();
        vm.setSelectedCollection(vm.getCollections().get(0));
        
        vm.comicTitleProperty().set("Spider-Man");
        vm.comicIssueNumberProperty().set(1);
        vm.addComic();
        
        assertEquals(1, vm.getComicsInSelectedCollection().size());
        assertEquals("Spider-Man", vm.getComicsInSelectedCollection().get(0).getTitle());
        assertEquals(1, vm.getComicsInSelectedCollection().get(0).getIssueNumber());
        assertEquals("", vm.comicTitleProperty().get());
        assertEquals(0, vm.comicIssueNumberProperty().get());
    }

    @Test
    void testRemoveSelectedComic() {
        ViewModel vm = new ViewModel();
        vm.collectionNameProperty().set("Marvel");
        vm.addCollection();
        vm.setSelectedCollection(vm.getCollections().get(0));
        
        vm.comicTitleProperty().set("Spider-Man");
        vm.comicIssueNumberProperty().set(1);
        vm.addComic();
        
        Comic toRemove = vm.getComicsInSelectedCollection().get(0);
        vm.setSelectedComic(toRemove);
        vm.removeSelectedComic();
        
        assertEquals(0, vm.getComicsInSelectedCollection().size());
        assertNull(vm.getSelectedComic());
    }
    
    @Test
    void testFindComicFound() {
        ViewModel vm = new ViewModel();
        vm.collectionNameProperty().set("Marvel");
        vm.addCollection();
        vm.setSelectedCollection(vm.getCollections().get(0));
        
        vm.comicTitleProperty().set("Spider-Man");
        vm.comicIssueNumberProperty().set(1);
        vm.addComic();
        
        Comic found = vm.findComic("Spider-Man", 1);
        
        assertNotNull(found);
        assertEquals("Spider-Man", found.getTitle());
        assertEquals(1, found.getIssueNumber());
    }

    @Test
    void testFindComicNotFound() {
        ViewModel vm = new ViewModel();
        vm.collectionNameProperty().set("Marvel");
        vm.addCollection();
        vm.setSelectedCollection(vm.getCollections().get(0));
        
        vm.comicTitleProperty().set("Spider-Man");
        vm.comicIssueNumberProperty().set(1);
        vm.addComic();
        
        Comic found = vm.findComic("Batman", 1);
        
        assertNull(found);
    }

    @Test
    void testFindComicNoCollectionSelected() {
        ViewModel vm = new ViewModel();
        
        Comic found = vm.findComic("Spider-Man", 1);
        
        assertNull(found);
    }
}
