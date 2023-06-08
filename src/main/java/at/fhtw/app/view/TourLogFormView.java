package at.fhtw.app.view;

import at.fhtw.app.helperServices.Listener.TourListClickListener;
import at.fhtw.app.model.Tour;
import at.fhtw.app.view.components.TourLogFormFxComponents;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TourLogFormView extends TourLogFormFxComponents implements Initializable, TourListClickListener {

    private int tourId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Integer[] choiceBoxChoices = {1, 2, 3, 4, 5};
        this.tourLogDifficulty.getItems().addAll(choiceBoxChoices);
        this.tourLogRating.getItems().addAll(choiceBoxChoices);
    }

    @Override
    public void changeSelection(Tour tour) {
        this.tourId = tour.getId();
    }

    public void addTourLog(MouseEvent mouseEvent) {

    }
}
