package at.fhtw.app.view.components;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public abstract class TourLogFormFxComponents {

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
