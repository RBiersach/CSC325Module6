module bcs.csc325.colorchooser {
    requires javafx.controls;
    requires javafx.fxml;

    opens bcs.csc325.colorchooser to javafx.fxml;
    exports bcs.csc325.colorchooser;
}
