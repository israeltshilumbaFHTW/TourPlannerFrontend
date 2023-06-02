package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.helperServices.Observer.TourListObserver;
import at.fhtw.app.model.Tour;
import at.fhtw.app.view.TourListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class TourListViewModel {
    private static TourListViewModel TourListViewModelInstance = null;
    private final TourApi tourApi = new TourApi();
    private final ObservableList<String> tourNameList;
    //Observer Pattern
    private List<TourListObserver> observers = new ArrayList<>();

    private TourListViewModel() {
        this.tourNameList = FXCollections.observableArrayList();
    }

    public static TourListViewModel getInstance() {
        if (TourListViewModelInstance == null) {
            TourListViewModelInstance = new TourListViewModel();
        }
        return TourListViewModelInstance;
    }

    public void registerObserver(TourListObserver observer) {
        this.observers.add(observer);
    }

    public void unregisterObserver(TourListObserver observer) {
        this.observers.remove(observer);
    }

    private void notifyObservers() {
        for (TourListObserver observer : this.observers) {
            observer.onTourListUpdated();
        }
    }

    public ObservableList<String> getTourNameList() {
        if (this.tourNameList.isEmpty()) {
            initList();
        }
        return this.tourNameList;
    }

    public void updateList() {
        System.out.println("UPDATE LIST");
        tourNameList.clear();

        List<Tour> tourList = tourApi.getAllTours();
        tourList.forEach(this::addItem);
        notifyObservers();
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
