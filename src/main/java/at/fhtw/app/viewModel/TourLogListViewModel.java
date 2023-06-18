package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.helperServices.Observer.TourLogListClickObserver;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

import static at.fhtw.app.Application.logger;

public class TourLogListViewModel extends TourLogListClickObserver {
    private static TourLogListViewModel TourLogListViewModelInstance = null;
    private final TourApi tourApi = new TourApi();

    private final ObservableList<TourLog> tourLogList = FXCollections.observableArrayList();

    private TourLogListViewModel() {

    }

    public static TourLogListViewModel getInstance() {
        if (TourLogListViewModelInstance == null) {
            TourLogListViewModelInstance = new TourLogListViewModel();
        }
        return TourLogListViewModelInstance;
    }

    public ObservableList<TourLog> getTourLogList(int tourId) {
        tourLogList.clear();
        List<TourLog> tourLogList = tourApi.getAllTourLogs(tourId);
        tourLogList.forEach(this::addItem);
        //TODO: get Data from API directly not just the class, this makes post/get easier later on
        //tour.getTourLogList().forEach(this::addItem);
        return this.tourLogList;
    }

    public void addItem(TourLog tourLog) {
        tourLogList.add(tourLog);
        //make API CALL
    }

    public void initList() {
        //get Data from API
    }

    public void updateList(int tourId) {
        logger.debug("UPDATE LOG LIST");
        this.tourLogList.clear();
        List<TourLog> tourLogList = tourApi.getAllTourLogs(tourId);
    }

    public void selectTourLog(int selectedTourLogIndex) {
        notifyTourLogClickListeners(this.tourLogList.get(selectedTourLogIndex));
    }
}
