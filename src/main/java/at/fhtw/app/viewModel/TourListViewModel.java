package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class TourListViewModel {
    private TourApi tourApi = new TourApi();

    private ObservableList<Tour> tourList = FXCollections.observableArrayList();

    public ObservableList<Tour> getTourList(){
        initList();
        return this.tourList;
    }

    public void addItem(Tour tour) {
       tourList.add(tour);

       //make API CALL
    }
    public void initList() {
        List<Tour> tourList = tourApi.getAllTours();
        tourList.forEach(
                tour -> {
                    addItem(tour);
                }
        );
        //get Data from API
    }


}
