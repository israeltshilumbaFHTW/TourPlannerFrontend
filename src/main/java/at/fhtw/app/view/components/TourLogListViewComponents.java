package at.fhtw.app.view.components;

import at.fhtw.app.model.TourLog;
import at.fhtw.app.viewModel.TourListViewModel;
import at.fhtw.app.viewModel.TourLogFormViewModel;
import at.fhtw.app.viewModel.TourLogListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public abstract class TourLogListViewComponents {
    protected TourLogListViewModel tourLogListViewModel = TourLogListViewModel.getInstance();
    protected TourLogFormViewModel tourLogFormViewModel = TourLogFormViewModel.getInstance();
    protected TourListViewModel tourListViewModel = TourListViewModel.getInstance();
    @FXML
    public AnchorPane tourLogForm;
    @FXML
    protected TableView<TourLog> tourLogTable;
    @FXML
    protected TableColumn<TourLog, String> tourLogDate;
    @FXML
    protected TableColumn<TourLog, String> tourLogComment;
    @FXML
    protected TableColumn<TourLog, Integer> tourLogDifficulty;
    @FXML
    protected TableColumn<TourLog, Double> tourLogTotalTime;
    @FXML
    protected TableColumn<TourLog, Integer> tourLogRating;
    protected Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    protected ButtonType confirmButton = new ButtonType("Yes");
    protected ButtonType cancelButton = new ButtonType("No");
}
