package at.fhtw.app.backendApi;
import at.fhtw.app.model.Tour;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class TourApiTest {

    @Test
    void getAllTours() {
        TourApi tourApi = new TourApi();

       List<Tour> tourList = tourApi.getAllTours();
        System.out.println(tourList.toString());
        assertEquals(3, tourList.size());
    }
}