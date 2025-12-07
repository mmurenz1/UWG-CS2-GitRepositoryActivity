module edu.westga.cs1302.e3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens edu.westga.cs1302.e3.view to javafx.fxml;
    exports edu.westga.cs1302.e3;
}
