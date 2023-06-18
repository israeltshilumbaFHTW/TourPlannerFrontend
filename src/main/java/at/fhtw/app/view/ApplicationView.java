package at.fhtw.app.view;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.helperServices.Listener.TourListClickListener;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.view.components.TourListViewFxComponents;
import at.fhtw.app.viewModel.ApplicationViewModel;
import at.fhtw.app.viewModel.TourListViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONObject;

import javax.swing.text.html.ListView;

import static at.fhtw.app.Application.logger;

public class ApplicationView extends TourListViewFxComponents implements Initializable {
    public ListView listTours;
    private int selectedTourIndex;
    private ApplicationViewModel applicationViewModel;

    @FXML
    public void createTourDirectoryReport(ActionEvent actionEvent) {
        ApplicationViewModel applicationViewModel = ApplicationViewModel.getInstance();
        applicationViewModel.createTourDirectoryReport();
    }

    @FXML
    public void createSingleTourReport(ActionEvent actionEvent) {
        ApplicationViewModel applicationViewModel = ApplicationViewModel.getInstance();
        applicationViewModel.createSingleTourReport();
    }

    @FXML
    public void importTour(ActionEvent actionEvent) {
        ApplicationViewModel applicationViewModel = ApplicationViewModel.getInstance();
        String fileContent = applicationViewModel.importTour();
        if (fileContent == null) {
            importError();
            return;
        }
        Stage stage = new Stage();
        TextArea textArea = new TextArea();

        // Set the file content in the text area
        textArea.setText(fileContent);
        textArea.setEditable(false);

        // Create a layout and add the text area
        VBox vbox = new VBox(textArea);

        // Create a scene with the layout and set it in the stage
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("File Content");
        stage.show();
    }

    @FXML
    public void importError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("File Read Error");
        alert.setContentText("An error occurred while reading the file.");
        alert.showAndWait();
    }
    @FXML
    public void openHelpWindow(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HelpWindow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage helpStage = new Stage();
            helpStage.setTitle("Application Help");
            helpStage.setScene(scene);
            helpStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exportTour(ActionEvent actionEvent) {
        ApplicationViewModel applicationViewModel = ApplicationViewModel.getInstance();
        applicationViewModel.exportTour();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.applicationViewModel = ApplicationViewModel.getInstance();
    }

}
