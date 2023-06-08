package at.fhtw.app.view.components;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public abstract class TourListViewFxComponents {

    //FXML Components
    @FXML
    public ListView<String> tourNamesList;
    @FXML
    public ScrollPane tourForm;
    @FXML
    public ChoiceBox<String> formTransportType = new ChoiceBox<>();
    @FXML
    public Button addButton;
}
