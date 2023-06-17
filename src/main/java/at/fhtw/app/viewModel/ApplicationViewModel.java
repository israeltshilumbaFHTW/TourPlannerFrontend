package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.view.components.TourListViewFxComponents;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.json.JSONArray;

import javax.swing.text.html.ListView;

public class ApplicationViewModel extends TourListViewFxComponents {
    public ListView listTours;
    @FXML
    public void createTourDirectoryReport(ActionEvent actionEvent) {
        String home = System.getProperty("user.home");
        String destination = home + "/Downloads/AllTours.pdf";

        TourApi tourApi = new TourApi();
        List<Tour> tourList = tourApi.getAllTours();
        System.out.println(tourList.toString());
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(destination));
            document.open();

            for (Tour tour:
                 tourList) {
                String tourInfo = generateTourInfo(tour);
                document.add(new Paragraph(tourInfo));
                /* TODO: check if this works. Does getAllTourLogs(index) take the index of the tour in
                    the tour_log table (wrong) or from the tour table (FK) (correct)*/
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
            System.out.println("PDF created");
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

    @FXML
    public void createSingleTourReport(ActionEvent actionEvent) {
        int selectedTourIndex = 1; // TODO: don't know how to do it, tried like this: 'tourNamesList.getSelectionModel().getSelectedIndex();', didn't work
        Tour tour;

        try {
            TourApi tourApi = new TourApi();
            tour = tourApi.getTourWithIndex(selectedTourIndex);
            // System.out.println(tour.getName()); // Wie kann er getName() verstehen, wenn ich in TourApi nirgendwo gesagt hab was der name ist, description, etc.?
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String home = System.getProperty("user.home");
        String destination = home + "/Downloads/" + tour.getName() + ".pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(destination));
            document.open();

            createTourDocument(document, tour);

            document.close();
            System.out.println("PDF created");
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

    public void importTour(ActionEvent actionEvent) {
    }

    public void importTourLogs(ActionEvent actionEvent) {
    }

    public void exportTours(ActionEvent actionEvent) {
        TourApi tourApi = new TourApi();
        String home = System.getProperty("user.home");
        String destination = "/Downloads/allTours.json";
        File file = new File(home + destination);
        String info = "tours";

        writeFile(tourApi, file, info);
    }

    public void exportTourLogs(ActionEvent actionEvent) {
        TourApi tourApi = new TourApi();
        String home = System.getProperty("user.home");
        String destination = "/Downloads/allTourLogs.json";
        File file = new File(home + destination);
        String info = "logs";

        writeFile(tourApi, file, info);
    }

    private static void writeFile(TourApi tourApi, File file, String info) {
        try {
            JSONArray jsonArray = tourApi.getAllToursInfoJson(info);
            if (jsonArray == null) {
                System.err.println("Can't export data!");
                return;
            }
            System.out.println(jsonArray);
            FileWriter fileWriter = new FileWriter(file);
            new ObjectMapper().writeValue(fileWriter, jsonArray.toString());
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
