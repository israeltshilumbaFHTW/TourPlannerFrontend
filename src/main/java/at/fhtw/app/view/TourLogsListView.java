package at.fhtw.app.view;

import at.fhtw.app.model.Tour;
import at.fhtw.app.viewModel.TourLogsListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TourLogsListView implements Initializable {
    //displayed as: Date | Duration | Distance

    public TourLogsListViewModel tourLogsListViewModel = new TourLogsListViewModel();
    @FXML
    public TableView<Tour> tourLogsTable;
    @FXML
    public TableColumn<Tour, String> colTourDate;
    @FXML
    private TableColumn<Tour, Double> colTourDuration;
    @FXML
    private TableColumn<Tour, Double> colTourDistance;

    @Override
    public void initialize(URL location, ResourceBundle rb) {


        tourLogsTable.setItems(tourLogsListViewModel.getTourList()); //gets Datatype "Tour"
        tourLogsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        colTourDate.setCellValueFactory(new PropertyValueFactory<Tour, String>("date")); //name of variable in Tour
        colTourDistance.setCellValueFactory(new PropertyValueFactory<Tour, Double>("distance"));
        colTourDuration.setCellValueFactory(new PropertyValueFactory<Tour, Double>("estimatedTime"));

    }
}
