package edu.westga.cs1302.comic_collection.viewmodel;

import edu.westga.cs1302.comic_collection.model.Collection;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import edu.westga.cs1302.comic_collection.model.Comic;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import java.util.HashMap;
import java.util.Map;

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
    private StringProperty comicTitle;
    private IntegerProperty comicIssueNumber;
    private ObservableList<Comic> comicsInSelectedCollection;
    private Comic selectedComic;

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
        
        this.comicTitle = new SimpleStringProperty("");
        this.comicIssueNumber = new SimpleIntegerProperty(0);
        this.comicsInSelectedCollection = FXCollections.observableArrayList();
        this.selectedComic = null;
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
    
    public StringProperty comicTitleProperty() {
        return this.comicTitle;
    }

    public IntegerProperty comicIssueNumberProperty() {
        return this.comicIssueNumber;
    }

    public ObservableList<Comic> getComicsInSelectedCollection() {
        return this.comicsInSelectedCollection;
    }

    public Comic getSelectedComic() {
        return this.selectedComic;
    }

    public void setSelectedComic(Comic comic) {
        this.selectedComic = comic;
    }

    public void addComic() {
        String title = this.comicTitle.get();
        int issueNumber = this.comicIssueNumber.get();
        Comic newComic = new Comic(title, issueNumber);
        this.selectedCollection.addComic(newComic);
        this.comicsInSelectedCollection.add(newComic);
        this.comicTitle.set("");
        this.comicIssueNumber.set(0);
    }

    public void removeSelectedComic() {
        if (this.selectedComic != null) {
            this.selectedCollection.removeComic(this.selectedComic);
            this.comicsInSelectedCollection.remove(this.selectedComic);
            this.selectedComic = null;
        }
    }
    
    public Comic findComic(String title, int issueNumber) {
        if (this.selectedCollection == null) {
            return null;
        }
        
        Map<String, Comic> comicMap = new HashMap<>();
        for (Comic comic : this.selectedCollection.getComics()) {
            String key = comic.getTitle() + "-" + comic.getIssueNumber();
            comicMap.put(key, comic);
        }
        
        String searchKey = title + "-" + issueNumber;
        return comicMap.get(searchKey);
    }
}