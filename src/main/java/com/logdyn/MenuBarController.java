package com.logdyn;

import javafx.fxml.FXML;
import org.springframework.stereotype.Component;

@Component
public class MenuBarController {

    private final CommandDelegator commandDelegator;

    public MenuBarController(CommandDelegator commandDelegator) {
        this.commandDelegator = commandDelegator;
    }

    @FXML
    public void newFile() throws ExecutionException {
        System.out.println("newFile");
        commandDelegator.subscribe(command -> {
            System.out.println("subscribed");
        }, Command.class);
        commandDelegator.publish(() -> "new File");
    }

    @FXML
    public void open() {
        System.out.println("open");
    }

    @FXML
    public void close() {
        System.out.println("close");
    }

    @FXML
    public void save() {
        System.out.println("save");
    }

    @FXML
    public void saveAs() {
        System.out.println("saveAs");
    }

    @FXML
    public void saveAll() {
        System.out.println("saveAll");
    }

    @FXML
    public void exit() {
        System.out.println("exit");
    }

    @FXML
    public void undo() {
        System.out.println("undo");
    }

    @FXML
    public void redo() {
        System.out.println("redo");
    }

    @FXML
    public void find() {
        System.out.println("find");
    }

    @FXML
    public void preferences() {
        System.out.println("preferences");
    }

    @FXML
    public void about() {
        System.out.println("about");
    }
}
