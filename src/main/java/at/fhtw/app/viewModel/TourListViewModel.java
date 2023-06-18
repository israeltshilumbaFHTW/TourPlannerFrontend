package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.helperServices.Listener.TourLogListener;
import at.fhtw.app.helperServices.Observer.TourListClickObserver;
import at.fhtw.app.helperServices.Listener.TourListListener;
import at.fhtw.app.helperServices.Observer.TourLogObserver;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

import static at.fhtw.app.Application.logger;

public class TourListViewModel extends TourListClickObserver implements TourLogListener {
    private static TourListViewModel TourListViewModelInstance = null;
    private final TourApi tourApi = new TourApi();
    private final ObservableList<String> tourNameList;
    private final ObservableList<Tour> tourList;
    //Observer Pattern
    private final List<TourListListener> observers = new ArrayList<>();
    private int selectedTourId;
    private Tour selectedTour;

    private TourListViewModel() {
        TourLogFormViewModel tourLogFormViewModel = TourLogFormViewModel.getInstance();
        tourLogFormViewModel.registerTourLogListener(this);
        this.tourNameList = FXCollections.observableArrayList();
        this.tourList = FXCollections.observableArrayList();
        this.selectedTourId = 0;
        this.selectedTour = null;
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
        logger.debug("UPDATE LIST");
        this.tourNameList.clear();
        this.tourList.clear();

        List<Tour> tourList = tourApi.getAllTours();
        tourList.forEach(this::addItem);
        logger.debug("tourObjectSize" + this.tourList.size());
        logger.debug("tourListSize" + tourNameList.size());
        notifyTourNameListObservers();
    }

    public void addItem(Tour tour) {
        tourNameList.add(tour.getName());
        tourList.add(tour);
    }

    public Boolean deleteTour(int tourId) {
        //Todo: change this logic
        String response = this.tourApi.deleteTour(tourId);
        updateList();
        notifyTourNameListObservers();
        return true;
    }

    public void selectTour(int tourIndex) {
        this.selectedTour = this.tourList.get(tourIndex);
        notifyTourClickListeners(this.tourList.get(tourIndex));
    }

    public void initList() {
        List<Tour> tourList = tourApi.getAllTours();
        tourList.forEach(
                this::addItem
        );
    }

    public int getSelectedTourId() {
        return this.selectedTour.getId();
    }

    @Override
    public void onTourLogListUpdated() {
        updateList();
    }
}
