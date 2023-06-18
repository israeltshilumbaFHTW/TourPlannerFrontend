package at.fhtw.app.view;

import at.fhtw.app.helperServices.Enums.FormMessages;
import at.fhtw.app.helperServices.Listener.TourListClickListener;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.view.components.TourLogFormFxComponents;
import at.fhtw.app.viewModel.TourListViewModel;
import at.fhtw.app.viewModel.TourLogFormViewModel;
import at.fhtw.app.viewModel.TourLogListViewModel;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

import static at.fhtw.app.Application.logger;

public class TourLogFormView extends TourLogFormFxComponents implements Initializable, TourListClickListener {

    private int tourId;
    TourLogFormViewModel tourLogFormViewModel = TourLogFormViewModel.getInstance();
    private final TourListViewModel tourListViewModel = TourListViewModel.getInstance();
    private final TourLogListViewModel tourLogListViewModel = TourLogListViewModel.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Integer[] choiceBoxChoices = {1, 2, 3, 4, 5};
        this.tourLogDifficulty.getItems().addAll(choiceBoxChoices);
        this.tourLogRating.getItems().addAll(choiceBoxChoices);
        this.tourListViewModel.registerTourClickListener(this);
    }

    @Override
    public void changeSelection(Tour tour) {
        this.tourId = tour.getId();
    }

    public void addTourLog(MouseEvent mouseEvent) {
        logger.debug("Button clicked: addTourLog");
        if (this.tourLogDate.getValue() == null) {
            alert.setTitle("INVALID INPUT");
            alert.setContentText("Date cannot be empty");
            alert.setHeaderText("");
            alert.showAndWait();
            return;
        }
        if (Objects.equals(this.tourLogTotalTime.getText(), "")) {
            alert.setTitle("INVALID INPUT");
            alert.setContentText("Total Time cannot be empty");
            alert.setHeaderText("");
            alert.showAndWait();
            return;
        }
        LocalDate selectedDate = this.tourLogDate.getValue();
        String formattedDate = selectedDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        TourLog tourLog = new TourLog(
                this.tourId,
                formattedDate,
                this.tourLogComment.getText(),
                this.tourLogDifficulty.getValue(),
                Integer.parseInt(this.tourLogTotalTime.getText()),
                this.tourLogRating.getValue()
        );

        //validate tourLog
        String validationString = formInputManager.validateForm(tourLog);
        if (Objects.equals(validationString, FormMessages.VALID_FORM.getMessage())) {
            logger.debug(validationString);

            this.tourLogFormViewModel.postTourLog(tourLog, this.tourId);
            this.tourLogListViewModel.updateList(tourId);

            successPrompt.setTitle("Tour Log has been added");
            successPrompt.setContentText(FormMessages.LOG_FORM_ADDED.getMessage());
            successPrompt.setHeaderText("");
            successPrompt.showAndWait();
        } else {
            alert.setTitle("INVALID INPUT");
            alert.setContentText(validationString);
            alert.setHeaderText("");
            alert.showAndWait();
            System.out.printf(validationString);
        }
        this.tourLogForm.setVisible(false);

        //Post to db
        //set form invisible
    }
}
