package com.logdyn;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Component
public class FooterController implements PropertyChangeListener {

    @FXML
    private Label statusLabel;
    private CommandDelegator commandDelegator;

    public FooterController(CommandDelegator commandDelegator) {
        this.commandDelegator = commandDelegator;
    }

    @Override
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getSource() instanceof CommandDelegator) {

            commandDelegator.getLatestExecutionRecord().ifPresent(record -> {
                statusLabel.setText(String.format("%s %s", record.getOperation(), record.getCommand().getName()));
            });
        }
    }
}
