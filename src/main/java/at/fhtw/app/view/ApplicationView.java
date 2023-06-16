package at.fhtw.app.view;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.Tour;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ApplicationView {
    @FXML
    public void createTourDirectory(ActionEvent actionEvent) {
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
            }

            document.close();
            System.out.println("PDF created");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String generateTourInfo(Tour tour) {
        return "Tour Name: " + tour.getName();
    }

}
