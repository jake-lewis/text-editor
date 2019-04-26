module com.logdyn {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.logdyn to javafx.fxml;
    exports com.logdyn;
}