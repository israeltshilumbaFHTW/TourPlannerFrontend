package at.fhtw.app.view.components;

import at.fhtw.app.helperServices.Form.FormInputManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public abstract class TourFormViewFxComponents {
    protected Alert alert = new Alert(Alert.AlertType.ERROR);
    protected Alert successPrompt = new Alert(Alert.AlertType.INFORMATION);
    //FXML Components
    @FXML
    public ScrollPane tourForm;
    protected final FormInputManager formInputManager = new FormInputManager();
    @FXML
    protected TextField formName;
    @FXML
    protected TextField formDescription;
    @FXML
    protected Button formSubmitButton;
    @FXML
    protected TextField formFrom;
    @FXML
    protected TextField formTo;
    @FXML
    protected ChoiceBox<String> formTransportType;
    @FXML
    protected TextArea formRouteInformation;
}
