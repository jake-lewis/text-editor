package com.logdyn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
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
        Scene scene = new Scene(loadFxml("primary", springContext));
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

    public static Parent loadFxml(String fxmlName, ApplicationContext context) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlName + ".fxml"));
        loader.setControllerFactory(context::getBean);
        return loader.load();
    }

}