package at.fhtw.app.backendApi;
import at.fhtw.app.helperServices.Enums.ApiResponse;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TourApiTest {

    TourApi tourApi = new TourApi();

    @Test
    void getAllTours() {

        List<Tour> tourList = tourApi.getAllTours();
        System.out.println(tourList.toString());
        assertEquals(3, tourList.size());
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
        System.out.println(response);
    }

    @Test
    void deleteTour() {
        String response = this.tourApi.deleteTour(2);
        assertEquals(response, ApiResponse.DELETE_SUCCESS.getResponseMessage());
        System.out.println(response);
    }
}