package at.fhtw.app.view.components;

import at.fhtw.app.model.Tour;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public abstract class TourListViewFxComponents {

    //FXML Components
    @FXML
    protected ListView<String> tourNamesList;
    @FXML
    protected ScrollPane tourForm;
    @FXML
    protected ChoiceBox<String> formTransportType = new ChoiceBox<>();
    @FXML
    protected Button addButton;
    @FXML
    protected Button deleteButton;
    @FXML
    public ListView<Integer> currentTour;

    protected Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    protected ButtonType confirmButton = new ButtonType("Yes");
    protected ButtonType cancelButton = new ButtonType("No");
}
