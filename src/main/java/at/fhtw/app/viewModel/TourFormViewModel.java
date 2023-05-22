package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.Tour;

public class TourFormViewModel {
    private final TourApi tourApi = new TourApi();

    private void addTour(Tour tour) {
        //send Tour entries to server
    }
}
