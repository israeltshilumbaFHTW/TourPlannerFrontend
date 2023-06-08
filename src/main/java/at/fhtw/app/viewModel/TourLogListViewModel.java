package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class TourLogListViewModel {
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
        System.out.println("UPDATE LOG LIST");
        this.tourLogList.clear();
        List<TourLog> tourLogList = tourApi.getAllTourLogs(tourId);
    }
}
