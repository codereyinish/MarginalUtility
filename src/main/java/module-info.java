module com.example.marginalutility {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.marginalutility to javafx.fxml;
    exports com.example.marginalutility;
}