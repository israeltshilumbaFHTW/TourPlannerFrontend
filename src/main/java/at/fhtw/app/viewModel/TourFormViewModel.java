package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.model.Tour;

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
        //send Tour entries to server
        System.out.println("Form Tour: " + formTour.toString());
        String response = tourApi.postTour(formTour);
        System.out.println(response);
        //notify ListView to update
    }
}
