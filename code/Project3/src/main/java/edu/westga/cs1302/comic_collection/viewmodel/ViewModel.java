package edu.westga.cs1302.comic_collection.viewmodel;

import edu.westga.cs1302.comic_collection.model.Collection;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * ViewModel for the Comic Collection application.
 * 
 * @author Mickel Ishema Murenzi
 * @version Fall 2025
 */
public class ViewModel {
    private StringProperty collectionName;
    private ObservableList<Collection> collections;
    private Collection selectedCollection;

    /**
     * Creates a new ViewModel.
     * 
     * @precondition none
     * @postcondition collectionName is initialized and empty
     *                collections list is initialized and empty
     *                selectedCollection is null
     */
    public ViewModel() {
        this.collectionName = new SimpleStringProperty("");
        this.collections = FXCollections.observableArrayList();
        this.selectedCollection = null;
    }

    /**
     * Gets the collection name property.
     * 
     * @return the collection name property
     */
    public StringProperty collectionNameProperty() {
        return this.collectionName;
    }

    /**
     * Gets the list of collections.
     * 
     * @return the observable list of collections
     */
    public ObservableList<Collection> getCollections() {
        return this.collections;
    }

    /**
     * Gets the currently selected collection.
     * 
     * @return the selected collection, or null if none selected
     */
    public Collection getSelectedCollection() {
        return this.selectedCollection;
    }

    /**
     * Sets the currently selected collection.
     * 
     * @param collection the collection to select
     */
    public void setSelectedCollection(Collection collection) {
        this.selectedCollection = collection;
    }

    /**
     * Adds a new collection with the current collection name.
     * 
     * @precondition collectionName is not null or empty
     * @postcondition new collection is added to collections list
     *                collectionName is cleared
     */
    public void addCollection() {
        String name = this.collectionName.get();
        Collection newCollection = new Collection(name);
        this.collections.add(newCollection);
        this.collectionName.set("");
    }

    /**
     * Removes the selected collection from the list.
     * 
     * @precondition selectedCollection != null
     * @postcondition selectedCollection is removed from collections list
     *                selectedCollection is set to null
     */
    public void removeSelectedCollection() {
        if (this.selectedCollection != null) {
            this.collections.remove(this.selectedCollection);
            this.selectedCollection = null;
        }
    }
}