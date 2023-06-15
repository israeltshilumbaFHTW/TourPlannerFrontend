package at.fhtw.app;

import at.fhtw.app.view.TourListView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Application extends javafx.application.Application {
    public static final Logger logger = LogManager.getLogger(Application.class);
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