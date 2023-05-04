package at.fhtw.app.viewModel;

import at.fhtw.app.backendApi.TourApi;
import at.fhtw.app.model.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

import java.util.List;

public class TourLogsListViewModel {
    private final TourApi tourApi = new TourApi();

    private final ObservableList<Tour> tourList = FXCollections.observableArrayList();
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
                this::addItem
        );
        //get Data from API
    }


}
