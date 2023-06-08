package at.fhtw.app.view.components;

import at.fhtw.app.helperServices.Form.FormInputManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public abstract class TourLogFormFxComponents {
    protected FormInputManager formInputManager;
    protected Alert alert = new Alert(Alert.AlertType.ERROR);
    protected Alert successPrompt = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    protected AnchorPane tourLogForm;
    @FXML
    protected ChoiceBox<Integer> tourLogDifficulty;
    @FXML
    protected DatePicker tourLogDate;
    @FXML
    protected TextArea tourLogComment;
    @FXML
    protected ChoiceBox<Integer> tourLogRating;
    @FXML
    protected TextField tourLogTotalTime;
}
