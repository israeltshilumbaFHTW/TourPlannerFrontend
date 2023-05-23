package at.fhtw.app.view;

import at.fhtw.app.helperServices.Form.FormInputManager;
import at.fhtw.app.helperServices.Enums.FormMessages;
import at.fhtw.app.helperServices.Observer.TourListObserver;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.model.Tour;
import at.fhtw.app.viewModel.TourFormViewModel;
import at.fhtw.app.viewModel.TourListViewModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Objects;

public class TourListView implements TourListObserver {
    public TourListViewModel tourListViewModel = new TourListViewModel();
    public TourFormViewModel tourFormViewModel = new TourFormViewModel();
    public FormInputManager formInputManager = new FormInputManager();

    Alert alert = new Alert(Alert.AlertType.ERROR);
    Alert successPrompt = new Alert(Alert.AlertType.INFORMATION);

    //Form Components
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
    @FXML
    public ListView<String> tourList = new ListView<>();
    public TextArea formRouteInformation;

    @Override
    public void onTourListUpdated() {
        Platform.runLater(this::updateTourList);  //thread safe update
    }

    public void updateTourList() {
        System.out.println("UPDATE TOUR LIST: TourListView");
        ObservableList<String> tourNameList = tourListViewModel.getTourNameList();
        this.tourList.getItems().setAll(tourNameList);
        this.tourList.refresh();
    }

    @FXML
    public void addTour(ActionEvent event) {
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

    public void addTourFormShow(ActionEvent event) {
        //make TourList invisible
        if (tourList.isVisible()) {
            tourList.setVisible(false);
            tourForm.setVisible(true);
        } else {
            tourList.setVisible(true);
            tourForm.setVisible(false);
        }
        System.out.println("Button clicked: startForm");
    }

    @javafx.fxml.FXML
    public void initialize() {
        tourListViewModel.registerObserver(this);
        //init List
        ObservableList<String> tourNameListList = FXCollections.observableArrayList();
        tourNameListList = tourListViewModel.getTourNameList();
        this.tourList.setItems(tourNameListList);

        //init ChoiceBox
        String[] choiceBoxChoices = {"public transit", "car", "bike", "foot"};
        formTransportType.getItems().addAll(choiceBoxChoices);
    }

}