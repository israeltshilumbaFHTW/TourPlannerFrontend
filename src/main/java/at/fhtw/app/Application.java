package at.fhtw.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view/Application.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 600);
        //scene.getStylesheets().add("/styles/style.css");
        stage.setWidth(1000);
        stage.setTitle("Tour Planner");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}