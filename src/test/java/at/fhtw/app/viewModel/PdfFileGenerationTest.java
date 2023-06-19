package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import static at.fhtw.app.Application.logger;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PdfFileGenerationTest extends TestDataSetOne {
    @Test
    void testCreateTourReportOne() {
        Tour testTour = getTestTourOne();
        String home = System.getProperty("user.home");
        String destination = home + "/Downloads/" + testTour.getName() + ".pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(destination));
            document.open();

            document.add(new Paragraph("Tour Name: " + testTour.getName()));
            document.add(new Paragraph("Description: " + testTour.getDescription()));
            document.add(new Paragraph("From: " + testTour.getFrom()));
            document.add(new Paragraph("To: " + testTour.getTo()));
            document.add(new Paragraph("Distance: " + testTour.getDistance()));
            document.add(new Paragraph("Estimated Time: " + testTour.getEstimatedTime()));
            document.add(new Paragraph("Transport Type: " + testTour.getTransportType()));
            document.close();

            File file = new File(destination);
            assertTrue(file.exists());

            // Clean up the created file
            boolean deleted = file.delete();
            assertTrue(deleted);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    void testCreateTourReportTwo() {
        Tour testTour = getTestTourTwo();
        String home = System.getProperty("user.home");
        String destination = home + "/Downloads/" + testTour.getName() + ".pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(destination));
            document.open();

            document.add(new Paragraph("Tour Name: " + testTour.getName()));
            document.add(new Paragraph("Description: " + testTour.getDescription()));
            document.add(new Paragraph("From: " + testTour.getFrom()));
            document.add(new Paragraph("To: " + testTour.getTo()));
            document.add(new Paragraph("Distance: " + testTour.getDistance()));
            document.add(new Paragraph("Estimated Time: " + testTour.getEstimatedTime()));
            document.add(new Paragraph("Transport Type: " + testTour.getTransportType()));
            document.close();

            File file = new File(destination);
            assertTrue(file.exists());

            // Clean up the created file
            boolean deleted = file.delete();
            assertTrue(deleted);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    void testCreateTourDirectoryReport() {
        // Create a temporary file for the PDF
        String home = System.getProperty("user.home");
        String destination = home + "/Downloads/" + "tempFile.pdf";
        File file = new File(destination);

        try {
            // Create a list of tours for testing
            List<Tour> tourList = new ArrayList<>();
            Tour tour1 = getTestTourOne();
            // Set tour1 properties...
            tourList.add(tour1);

            Tour tour2 = getTestTourTwo();
            // Set tour2 properties...
            tourList.add(tour2);

            Document document= new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(destination));
                document.open();

                for (Tour tour:
                        tourList) {
                    String tourInfo = generateTourInfo(tour);
                    document.add(new Paragraph(tourInfo));
                }
                // Close the Document
                document.close();
                logger.debug("PDF created");
            } catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            }

            // Assert that the temporary file was created
            assertTrue(file.exists());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Delete the temporary file after the test
            if (file.exists()) {
                file.delete();
            }
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

}
