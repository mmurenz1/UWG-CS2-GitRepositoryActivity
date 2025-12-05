module edu.westga.cs1302.comic_collection {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens edu.westga.cs1302.comic_collection.view to javafx.fxml;
    exports edu.westga.cs1302.comic_collection;
}
