package at.fhtw.app.view;

import at.fhtw.app.model.Tour;
import at.fhtw.app.viewModel.TourListViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TourListView implements Initializable {

    public TourListViewModel tourListViewModel = new TourListViewModel();
    @javafx.fxml.FXML
    private TableColumn<Tour, Integer> colTourId;
    @javafx.fxml.FXML
    private TableView<Tour> tourTable;
    @javafx.fxml.FXML
    private TableColumn<Tour, String> colTourFrom;
    @javafx.fxml.FXML
    private TableColumn<Tour, String> colTourTo;
    @javafx.fxml.FXML
    private TableColumn<Tour, Integer> colTourDistance;
    @javafx.fxml.FXML
    private TableColumn<Tour, String> colTourName;
    @javafx.fxml.FXML
    private TableColumn<Tour, Integer> colTourTime;
    @javafx.fxml.FXML
    private TableColumn<Tour, String> colTourDescription;

    @Override
    public void initialize(URL location, ResourceBundle rb) {


        tourTable.setItems(tourListViewModel.getTourList());
        tourTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        colTourId.setCellValueFactory(new PropertyValueFactory<Tour, Integer>("id"));
        colTourName.setCellValueFactory(new PropertyValueFactory<Tour, String>("name"));
        colTourDescription.setCellValueFactory(new PropertyValueFactory<Tour, String>("description"));
        colTourFrom.setCellValueFactory(new PropertyValueFactory<Tour, String>("from"));
        colTourTo.setCellValueFactory(new PropertyValueFactory<Tour, String>("to"));
        colTourDistance.setCellValueFactory(new PropertyValueFactory<Tour, Integer>("distance"));
        colTourTime.setCellValueFactory(new PropertyValueFactory<Tour, Integer>("time"));

    }
}
