package at.fhtw.app.view;

import at.fhtw.app.helperServices.Listener.TourListClickListener;
import at.fhtw.app.helperServices.Listener.TourLogListClickListener;
import at.fhtw.app.helperServices.Listener.TourLogListener;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.view.components.TourLogListViewComponents;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import static at.fhtw.app.Application.logger;

public class TourLogListView extends TourLogListViewComponents implements Initializable, TourListClickListener, TourLogListener, TourLogListClickListener {
    private int selectedTourLogIndex;
    private int tourId;

    @Override
    public void changeSelection(Tour tour) {
        logger.debug("TourLogListView::changeSelection::should set visible");
        this.tourId = tour.getId();//important for delete
        this.tourLogTable.setItems(tourLogListViewModel.getTourLogList(tour.getId()));
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
        this.tourLogListViewModel.registerTouLogClickListener(this);
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

    public void deleteTourLogForm(MouseEvent event) {
        this.alert.setTitle("Confirmation Dialog");
        this.alert.setHeaderText("Are you sure?");
        this.alert.setContentText("DELETING TOUR LOG ID: " + this.selectedTourLogIndex);

        this.alert.getButtonTypes().setAll(confirmButton, cancelButton);

        this.alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == confirmButton) {
                logger.debug("User confirmed: Deleting TourLog entry with index: " + this.selectedTourLogIndex);
                this.tourLogListViewModel.deleteTourLog(this.selectedTourLogIndex, this.tourId);
                //Platform.runLater(this::updateTourList);  //thread safe update
                // Perform your desired action here
            } else if (buttonType == cancelButton) {
                logger.debug("User cancelled: TourLog entry with index: " + this.selectedTourLogIndex);
            }
        });
    }

    @Override
    public void changeLogSelection(TourLog selectedTourLog) {
        this.selectedTourLogIndex = selectedTourLog.getId();
    }
}
