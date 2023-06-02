package at.fhtw.app.view;

import at.fhtw.app.helperServices.Enums.FormMessages;
import at.fhtw.app.helperServices.Form.FormInputManager;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.viewModel.TourFormViewModel;
import at.fhtw.app.viewModel.TourListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TourFormView implements Initializable {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    Alert successPrompt = new Alert(Alert.AlertType.INFORMATION);
    private final FormInputManager formInputManager = new FormInputManager();
    @javafx.fxml.FXML
    private TextField formName;
    @javafx.fxml.FXML
    private TextField formDescription;
    @javafx.fxml.FXML
    private Button formSubmitButton;
    @javafx.fxml.FXML
    private TextField formFrom;
    @javafx.fxml.FXML
    private TextField formTo;
    @javafx.fxml.FXML
    private ChoiceBox<String> formTransportType;
    @javafx.fxml.FXML
    private TextArea formRouteInformation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //init ChoiceBox
        String[] choiceBoxChoices = {"public transit", "car", "bike", "foot"};
        formTransportType.getItems().addAll(choiceBoxChoices);
    }

    @FXML
    public void addTour(ActionEvent actionEvent) {
        TourFormViewModel tourFormViewModel = TourFormViewModel.getInstance();
        TourListViewModel tourListViewModel = TourListViewModel.getInstance();

        System.out.println("Button clicked: addTour");
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
    }
}
