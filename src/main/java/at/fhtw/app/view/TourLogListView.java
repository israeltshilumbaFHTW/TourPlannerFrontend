package at.fhtw.app.view;

import at.fhtw.app.helperServices.Listener.TourListClickListener;
import at.fhtw.app.helperServices.Listener.TourLogListener;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.viewModel.TourListViewModel;
import at.fhtw.app.viewModel.TourLogFormViewModel;
import at.fhtw.app.viewModel.TourLogListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static at.fhtw.app.Application.logger;

public class TourLogListView implements Initializable, TourListClickListener, TourLogListener {


    public TourLogListViewModel tourLogListViewModel = TourLogListViewModel.getInstance();
    public TourLogFormViewModel tourLogFormViewModel = TourLogFormViewModel.getInstance();
    public TourListViewModel tourListViewModel = TourListViewModel.getInstance();
    @FXML
    public AnchorPane tourLogForm;
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
    private int selectedTourLogIndex;

    @Override
    public void changeSelection(Tour tour) {
        logger.debug("TourLogListView::changeSelection::should set visible");
        tourLogTable.setItems(tourLogListViewModel.getTourLogList(tour.getId()));
    }

    @Override
    public void onTourLogListUpdated() {
        this.tourLogTable.setVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle rb) {
        //tourLogTable.setItems((ObservableList<TourLog>) tourLogsListViewModel.getTourList().get(0).getTourLogList()); //gets Datatype "Tour"
        this.tourListViewModel.registerTourClickListener(this);
        this.tourLogFormViewModel.registerTourLogListener(this);
        this.tourLogTable.setOnMouseClicked(this::handleTourLogSelection);
        this.tourLogTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        tourLogDate.setCellValueFactory(new PropertyValueFactory<TourLog, String>("date")); //name of variable in TourLog
        tourLogComment.setCellValueFactory(new PropertyValueFactory<TourLog, String>("comment"));
        tourLogTotalTime.setCellValueFactory(new PropertyValueFactory<TourLog, Double>("totalTime"));
        tourLogDifficulty.setCellValueFactory(new PropertyValueFactory<TourLog, Integer>("difficulty"));
        tourLogRating.setCellValueFactory(new PropertyValueFactory<TourLog, Integer>("rating"));


    }

    private void handleTourLogSelection(MouseEvent event) {
        logger.debug("handle TourLogSelection");
        this.selectedTourLogIndex = this.tourLogTable.getSelectionModel().getSelectedIndex();
        this.tourLogListViewModel.selectTourLog(this.selectedTourLogIndex);
    }

    public void addTourLogFormShow(MouseEvent mouseEvent) {
        if (this.tourLogTable.isVisible()) {
            this.tourLogTable.setVisible(false);
            this.tourLogForm.setVisible(true);
        } else {
            this.tourLogTable.setVisible(true);
            this.tourLogForm.setVisible(false);
        }
        logger.debug("Button clicked: startLogForm");
    }

}
