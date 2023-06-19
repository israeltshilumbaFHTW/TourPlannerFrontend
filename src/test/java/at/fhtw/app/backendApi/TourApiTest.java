package at.fhtw.app.backendApi;
import at.fhtw.app.helperServices.Enums.ApiResponse;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static at.fhtw.app.Application.logger;
import static org.junit.jupiter.api.Assertions.*;

class TourApiTest extends TestDataSetThree{

    TourApi tourApi = new TourApi();

    @Test
    void getAllTours() {
        List<Tour> tourList = new ArrayList<>();
        Tour tour1 = getTestTourOne();
        Tour tour2 = getTestTourTwo();
        tourList.add(tour1);
        tourList.add(tour2);
        System.out.println(tourList.toString());
        assertEquals(2, tourList.size());
    }

    @Test
    void getAllTourLogs() {
        List<TourLog> tourLogList = tourApi.getAllTourLogs(1);
        System.out.println(tourLogList.toString());
    }

    @Test
    void postTourLog() {
        TourLog tourLog = new TourLog("10:10:2022", " pooop", 5, 40, 3);
        String response = this.tourApi.postTourLog(tourLog, 1);
        logger.debug(response);
    }

    @Test
    void deleteTour() {
        String response = this.tourApi.deleteTour(2);
        assertEquals(response, ApiResponse.DELETE_SUCCESS.getResponseMessage());
        logger.debug(response);
    }

    @Test
    void deleteTourLog() {
        String response = this.tourApi.deleteTourLog(1);
        assertEquals(response, ApiResponse.DELETE_SUCCESS.getResponseMessage());
        logger.debug(response);
    }
}