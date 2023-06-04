package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.helperServices.Observer.TourListClickObserver;
import at.fhtw.app.helperServices.Listener.TourListListener;
import at.fhtw.app.model.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class TourListViewModel extends TourListClickObserver {
    private static TourListViewModel TourListViewModelInstance = null;
    private final TourApi tourApi = new TourApi();
    private final ObservableList<String> tourNameList;
    private final ObservableList<Tour> tourList;
    //Observer Pattern
    private List<TourListListener> observers = new ArrayList<>();

    private TourListViewModel() {
        this.tourNameList = FXCollections.observableArrayList();
        this.tourList = FXCollections.observableArrayList();
    }

    public static TourListViewModel getInstance() {
        if (TourListViewModelInstance == null) {
            TourListViewModelInstance = new TourListViewModel();
        }
        return TourListViewModelInstance;
    }

    public void registerTourNameListObserver(TourListListener observer) {
        this.observers.add(observer);
    }

    public void unregisterTourNameListObserver(TourListListener observer) {
        this.observers.remove(observer);
    }

    private void notifyTourNameListObservers() {
        for (TourListListener observer : this.observers) {
            observer.onTourListUpdated();
        }
    }

    public ObservableList<Tour> getTourList() {
        if (this.tourList.isEmpty()) {
            initList();
        }
        return this.tourList;
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
        notifyTourNameListObservers();
    }

    public void addItem(Tour tour) {
        tourNameList.add(tour.getName());
        tourList.add(tour);
    }

    public void selectTour(int tourIndex) {
        notifyTourClickListeners(this.tourList.get(tourIndex));
    }

    public void initList() {
        List<Tour> tourList = tourApi.getAllTours();
        tourList.forEach(
                this::addItem
        );
    }
}
