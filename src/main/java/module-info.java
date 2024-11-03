module com.example.javafxbindingscrud {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxbindingscrud to javafx.fxml;
    exports com.example.javafxbindingscrud;
}