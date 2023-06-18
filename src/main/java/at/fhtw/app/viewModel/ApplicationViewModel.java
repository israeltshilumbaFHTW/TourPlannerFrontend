package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.helperServices.Listener.TourListClickListener;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.view.ApplicationView;
import at.fhtw.app.view.components.TourListViewFxComponents;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import org.json.JSONObject;

import javax.swing.text.html.ListView;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;

import static at.fhtw.app.Application.logger;

public class ApplicationViewModel extends TourListViewFxComponents implements TourListClickListener, Initializable {
    public ListView listTours;
    private int selectedTourIndex;
    private Tour tour;

    private static ApplicationViewModel Instance = null;

    public static ApplicationViewModel getInstance() {
        if (Instance == null) {
            Instance = new ApplicationViewModel();
        }
        return Instance;
    }

    private ApplicationViewModel() {

        TourListViewModel tourListViewModel = TourListViewModel.getInstance();
        tourListViewModel.registerTourClickListener(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void createTourDirectoryReport() {
        String home = System.getProperty("user.home");
        String destination = home + "/Downloads/AllTours.pdf";

        TourApi tourApi = new TourApi();
        List<Tour> tourList = tourApi.getAllTours();
        logger.debug(tourList.toString());
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(destination));
            document.open();

            for (Tour tour:
                 tourList) {
                String tourInfo = generateTourInfo(tour);
                document.add(new Paragraph(tourInfo));
                List<TourLog> tourLogList = tourApi.getAllTourLogs(tour.getId());

                if (!tourLogList.isEmpty()) {
                    for (TourLog tourlog:
                         tourLogList) {
                        String tourLogInfo = generateTourLogInfo(tourlog);
                        document.add(new Paragraph(tourLogInfo));
                    }
                }
            }

            document.close();
            logger.debug("PDF created");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String generateTourInfo(Tour tour) {
        String tourInfo =
                "\nTour Name: " + tour.getName() +
                "\nDescription: " + tour.getDescription() +
                "\nFrom: " + tour.getFrom() +
                "\nTo: " + tour.getTo() +
                "\nDistance: " + tour.getDistance() +
                "\nEstimated Time: " + tour.getEstimatedTime() +
                "\nTransport Type: " + tour.getTransportType();
        return tourInfo;
    }

    private String generateTourLogInfo(TourLog tourlog) {
        String tourLogInfo =
                "\nDate of entry: " + tourlog.getDate() +
                "\nComment: " + tourlog.getComment() +
                "\nDifficulty (1-10): " + tourlog.getDifficulty() +
                "\nCompletion Time: " + tourlog.getTotalTime() +
                "\nRating: " + tourlog.getRating();
        return tourLogInfo;
    }

    public void createSingleTourReport() {

        String home = System.getProperty("user.home");
        String destination = home + "/Downloads/" + this.tour.getName() + ".pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(destination));
            document.open();

            createTourDocument(document, this.tour);

            document.close();
            logger.debug("PDF created");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createTourDocument(Document document, Tour tour) throws DocumentException {
        document.add(new Paragraph("Tour Name: " + tour.getName()));
        document.add(new Paragraph("Description: " + tour.getDescription()));
        document.add(new Paragraph("From: " + tour.getFrom()));
        document.add(new Paragraph("To: " + tour.getTo()));
        document.add(new Paragraph("Distance: " + tour.getDistance()));
        document.add(new Paragraph("Estimated Time: " + tour.getEstimatedTime()));
        document.add(new Paragraph("Transport Type: " + tour.getTransportType()));
    }

    public String importTour() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        Tour tour;

        // Show the file chooser dialog
        File selectedFile = fileChooser.showOpenDialog(null);


        if (selectedFile != null) {
            try {
                // Read the content of the selected JSON file
                String fileContent = Files.readString(selectedFile.toPath());
                fileContent = removeFirstAndLastCharacter(fileContent);

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                tour = objectMapper.readValue(fileContent, Tour.class);

                System.out.println(tour.getName());

                // Print the file content in the terminal
                System.out.println(fileContent);
                return "success";
            } catch (IOException e) {
                e.printStackTrace();
                // Display an error message if there was an error reading the file
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("File Read Error");
                alert.setContentText("An error occurred while reading the file.");
                alert.showAndWait();
                return "fail";
            }
        }
        return "success";
    }

    public static String removeFirstAndLastCharacter(String str) {
        if (str.length() <= 2) {
            return "";
        } else {
            return str.substring(1, str.length() - 1);
        }
    }

    public void exportTour() {
        try {
            TourApi tourApi = new TourApi();
            // TODO: this.selectedTourIndex is always 0
            JSONObject jsonObject = tourApi.getTourAsJson(this.selectedTourIndex);
            String home = System.getProperty("user.home");
            String destination = "/Downloads/" + tour.getName() + ".json";

            File file = new File(home + destination);
            if (tour == null) {
                logger.error("Can't export data!");
                return;
            }
            logger.debug(jsonObject.toString());
            FileWriter fileWriter = new FileWriter(file);
            new ObjectMapper().writeValue(fileWriter, jsonObject.toString());
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeSelection(Tour tour) {
        logger.debug("ApplicationViewModel: Tour ID: " + tour.getId());
        this.selectedTourIndex = tour.getId();
        this.tour = tour;
    }

}
