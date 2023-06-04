package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.MapQuestDirectionsApi;
import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.model.MapQuest.Directions;
import at.fhtw.app.model.Tour;

import java.util.Date;

public class TourFormViewModel {
    private static TourFormViewModel TourFormViewModelInstance = null;
    private final TourApi tourApi;

    private TourFormViewModel() {
        this.tourApi = new TourApi();
    }


    public static TourFormViewModel getInstance() {
        if (TourFormViewModelInstance == null) {
            TourFormViewModelInstance = new TourFormViewModel();
        }
        return TourFormViewModelInstance;
    }

    public void postTour(FormTour formTour) { //
        MapQuestDirectionsApi mapQuestDirectionsApi = new MapQuestDirectionsApi(formTour);
        Directions directions = mapQuestDirectionsApi.getDirection();
        String imageUrl = mapQuestDirectionsApi.buildStaticMapUrl(directions);
        Tour tour = new Tour(
                formTour.getName(),
                formTour.getDescription(),
                formTour.getFromLocation(),
                formTour.getToLocation(),
                formTour.getTransportType(),
                directions.getDistance(),
                directions.getTime(),
                imageUrl
        );
        //send Tour entries to server
        //Get Image Url

        String response = tourApi.postTour(tour);
        System.out.println(response);
        //notify ListView to update
    }
}
