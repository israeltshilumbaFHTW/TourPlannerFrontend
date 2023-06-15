package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.view.TourLogFormView;

public class TourLogFormViewModel {
    private static TourLogFormViewModel TourLogFormViewModelInstance = null;
    private final TourApi tourApi;

    private TourLogFormViewModel() {
        this.tourApi = new TourApi();
    }

    public static TourLogFormViewModel getInstance() {
        if (TourLogFormViewModelInstance == null) {
            TourLogFormViewModelInstance = new TourLogFormViewModel();
        }
        return TourLogFormViewModelInstance;
    }

    public void postTourLog(TourLog tourLog, int tourId) {
        System.out.println("POST tour LOG id: " + tourId);
        this.tourApi.postTourLog(tourLog, tourId);
    }

}
