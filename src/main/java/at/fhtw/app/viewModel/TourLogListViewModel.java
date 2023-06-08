package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class TourLogListViewModel {
    private final TourApi tourApi = new TourApi();

    private final ObservableList<TourLog> tourLogList = FXCollections.observableArrayList();

    public ObservableList<TourLog> getTourLogList(Tour tour) {
        tourLogList.clear();
        tour.getTourLogList().forEach(this::addItem);
        return this.tourLogList;
    }

    public void addItem(TourLog tourLog) {
        tourLogList.add(tourLog);
        //make API CALL
    }

    public void initList() {
        //get Data from API
    }
}
