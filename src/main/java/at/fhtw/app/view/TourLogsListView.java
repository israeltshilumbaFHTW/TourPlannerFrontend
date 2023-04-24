package at.fhtw.app.view;

import at.fhtw.app.model.Tour;
import at.fhtw.app.viewModel.TourLogsListViewModel;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TourLogsListView implements Initializable {

    public TourLogsListViewModel tourLogsListViewModel = new TourLogsListViewModel();
    @javafx.fxml.FXML
    private TableView<Tour> tourTable;
    public TableColumn<Tour,String> colTourName;
    @javafx.fxml.FXML
    private TableColumn<Tour, Integer> colTourDistance;
    @javafx.fxml.FXML
    private TableColumn<Tour, Integer> colTourTime;
    @javafx.fxml.FXML
    private TableColumn<Tour, String> colTourDate;
    @Override
    public void initialize(URL location, ResourceBundle rb) {


        tourTable.setItems(tourLogsListViewModel.getTourList()); //gets Datatype "Tour"
        tourTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        colTourName.setCellValueFactory(new PropertyValueFactory<Tour, String>("name"));
        colTourDate.setCellValueFactory(new PropertyValueFactory<Tour, String>("date")); //name of variable in Tour
        colTourDistance.setCellValueFactory(new PropertyValueFactory<Tour, Integer>("distance"));
        colTourTime.setCellValueFactory(new PropertyValueFactory<Tour, Integer>("time"));

    }
}
