package at.fhtw.app.view.components;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public abstract class TourListViewFxComponents {
    @FXML
    public ListView<String> tourList = new ListView<>();
    @FXML
    public ScrollPane tourForm;
    @FXML
    public TextField formFrom;
    public ChoiceBox<String> formTransportType = new ChoiceBox<>();
    public TextField formTo;
    @FXML
    public TextField formName;
    @FXML
    public TextField formDescription;
    @FXML
    public Button formSubmitButton;
    public TextArea formRouteInformation;
}
