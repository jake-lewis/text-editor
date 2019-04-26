package com.logdyn;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class PrimaryController {

    private final ApplicationContext context;
    @FXML
    public Button primaryButton;

    @Autowired
    public PrimaryController(ApplicationContext context) {
        this.context = context;
    }

    @FXML
    private void switchToSecondary() throws IOException {
        primaryButton.getScene().setRoot(App.loadFxml("secondary", context));
    }
}
