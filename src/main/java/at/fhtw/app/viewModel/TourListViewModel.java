package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class TourListViewModel {
    private final TourApi tourApi = new TourApi();
    private final ObservableList<String> tourNameList = FXCollections.observableArrayList();

    public ObservableList<String> getTourNameList() {
        initList();
        return this.tourNameList;
    }

    public void addItem(Tour tour) {
        tourNameList.add(tour.getName());
    }

    public void initList() {
        List<Tour> tourList = tourApi.getAllTours();
        tourList.forEach(
                this::addItem
        );
    }
}
