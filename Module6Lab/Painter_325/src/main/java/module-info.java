module bcs.csc325.colorchooser_325 {
    requires javafx.controls;
    requires javafx.fxml;

    opens bcs.csc325.colorchooser_325 to javafx.fxml;
    exports bcs.csc325.colorchooser_325;
}
