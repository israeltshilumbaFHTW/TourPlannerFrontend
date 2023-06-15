package at.fhtw.app.view;

import at.fhtw.app.helperServices.Enums.FormMessages;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.view.components.TourFormViewFxComponents;
import at.fhtw.app.viewModel.TourFormViewModel;
import at.fhtw.app.viewModel.TourListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static at.fhtw.app.Application.logger;

public class TourFormView extends TourFormViewFxComponents implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //init ChoiceBox


        String[] choiceBoxChoices = {"fastest", "shortest", "pedestrian", "bicycle"};
        formTransportType.getItems().addAll(choiceBoxChoices);
    }

    @FXML
    public void addTour(ActionEvent actionEvent) {
        TourFormViewModel tourFormViewModel = TourFormViewModel.getInstance();
        TourListViewModel tourListViewModel = TourListViewModel.getInstance();

        logger.debug("Button clicked: addTour");
        //validate Input
        FormTour formTour = new FormTour(formName.getText(), formDescription.getText(), formFrom.getText(), formTo.getText(), formTransportType.getValue(), formRouteInformation.getText());
        String validationString = formInputManager.validateForm(formTour);

        if (Objects.equals(validationString, FormMessages.VALID_FORM.getMessage())) {
            //post them to DB
            System.out.print("VALID INPUT");
            System.out.printf(validationString);

            tourFormViewModel.postTour(formTour);
            tourListViewModel.updateList();
            successPrompt.setTitle("Tour has been added");
            successPrompt.setContentText(FormMessages.FORM_ADDED.getMessage());
            successPrompt.setHeaderText("");
            successPrompt.showAndWait();
        } else {
            //show error message
            alert.setTitle("INVALID INPUT");
            alert.setContentText(validationString);
            alert.setHeaderText("");
            alert.showAndWait();
            System.out.printf(validationString);

        }
        tourForm.setVisible(false);
    }
}
