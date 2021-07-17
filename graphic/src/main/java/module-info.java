module main {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    opens View to javafx.fxml;
    exports View;
}