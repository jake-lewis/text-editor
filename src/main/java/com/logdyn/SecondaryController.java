package com.logdyn;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SecondaryController {

    private final ApplicationContext context;
    @FXML
    public Button secondaryButton;

    @Autowired
    public SecondaryController(ApplicationContext context) {
        this.context = context;
    }

    @FXML
    private void switchToPrimary() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        secondaryButton.getScene().setRoot(fxmlLoader.load());
    }
}