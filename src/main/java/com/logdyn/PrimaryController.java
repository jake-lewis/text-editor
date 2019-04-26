package com.logdyn;

import java.io.IOException;
import javafx.fxml.FXML;
import org.springframework.stereotype.Component;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        FxApp.setRoot("secondary");
    }
}
