package at.fhtw.app.view;

import at.fhtw.app.viewModel.TourListViewModel;
import javafx.scene.control.ListView;

public class TourListView {
    public TourListViewModel tourListViewModel = new TourListViewModel();

    @javafx.fxml.FXML
    private ListView<String> toursList;

    @javafx.fxml.FXML
    public void initialize() {
        toursList.setItems(tourListViewModel.getTourNameList());
    }
}