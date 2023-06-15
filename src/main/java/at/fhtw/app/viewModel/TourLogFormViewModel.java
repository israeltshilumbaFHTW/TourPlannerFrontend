package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.helperServices.Observer.TourLogObserver;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.view.TourLogFormView;

import static at.fhtw.app.Application.logger;

public class TourLogFormViewModel extends TourLogObserver {
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
        logger.debug("POST tour LOG id: " + tourId);
        this.tourApi.postTourLog(tourLog, tourId);
        notifyTourLogListener();
    }

}
