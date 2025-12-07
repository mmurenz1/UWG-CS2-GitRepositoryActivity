package edu.westga.cs1302.comic_collection.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Collection;

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
}
