package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.model.Tour;

public class TourFormViewModel {
    private final TourApi tourApi = new TourApi();

    public void postTour(FormTour formTour) { //
        //send Tour entries to server
        System.out.println("Form Tour: " + formTour.toString());
        String response = tourApi.postTour(formTour);
        System.out.println(response);
        //notify ListView to update
    }
}
