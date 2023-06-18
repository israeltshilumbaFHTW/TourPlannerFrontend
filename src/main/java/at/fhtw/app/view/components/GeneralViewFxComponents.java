package at.fhtw.app.view.components;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.text.Text;

abstract public class GeneralViewFxComponents {
    @FXML
    protected Tab general;
    @FXML
    protected Text tourName;
    @FXML
    protected Text tourFrom;
    @FXML
    protected Text tourTo;
    @FXML
    protected Text tourDescription;
    @FXML
    protected Text routeInformation;
    @FXML
    protected Text tourPopularity;
    @FXML
    protected Text tourChildFriendliness;
    @FXML
    protected Text rating;
}
