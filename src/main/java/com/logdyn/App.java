package com.logdyn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * JavaFX App
 */
@SpringBootApplication
public class App extends Application {

    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        springContext = SpringApplication.run(App.class);
    }

    @Override
    public void start(Stage stage) throws IOException {
        final FXMLLoader loader = springContext.getBean(FXMLLoader.class);
        loader.setLocation(App.class.getResource("fxml/root.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("JET-FX");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        springContext.stop();
    }

    public static void main(String[] args) {
        launch(App.class, args);
    }

}