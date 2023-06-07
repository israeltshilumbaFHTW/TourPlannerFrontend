package at.fhtw.app.view;

import at.fhtw.app.helperServices.Listener.TourListClickListener;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.viewModel.TourListViewModel;
import at.fhtw.app.viewModel.TourLogListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TourLogListView implements Initializable, TourListClickListener {
    //displayed as: Date | Duration | Distance

    public TourLogListViewModel tourLogListViewModel = new TourLogListViewModel();
    @FXML
    private TableView<TourLog> tourLogTable;
    @FXML
    private TableColumn<TourLog, String> tourLogDate;
    @FXML
    private TableColumn<TourLog, String> tourLogComment;
    @FXML
    private TableColumn<TourLog, Integer> tourLogDifficulty;
    @FXML
    private TableColumn<TourLog, Double> tourLogTotalTime;
    @FXML
    private TableColumn<TourLog, Integer> tourLogRating;

    @Override
    public void changeSelection(Tour tour) {
        System.out.println("TourLogListView::changeSelection");
        tourLogTable.setItems(tourLogListViewModel.getTourLogList(tour));
    }

    @Override
    public void initialize(URL location, ResourceBundle rb) {
        //tourLogTable.setItems((ObservableList<TourLog>) tourLogsListViewModel.getTourList().get(0).getTourLogList()); //gets Datatype "Tour"
        TourListViewModel tourLogListViewModel = TourListViewModel.getInstance();
        tourLogListViewModel.registerTourClickListener(this);
        tourLogTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        tourLogDate.setCellValueFactory(new PropertyValueFactory<TourLog, String>("date")); //name of variable in TourLog
        tourLogComment.setCellValueFactory(new PropertyValueFactory<TourLog, String>("comment"));
        tourLogTotalTime.setCellValueFactory(new PropertyValueFactory<TourLog, Double>("totalTime"));
        tourLogDifficulty.setCellValueFactory(new PropertyValueFactory<TourLog, Integer>("difficulty"));
        tourLogRating.setCellValueFactory(new PropertyValueFactory<TourLog, Integer>("rating"));


    }

}
