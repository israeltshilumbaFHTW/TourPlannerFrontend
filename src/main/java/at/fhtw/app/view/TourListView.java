package at.fhtw.app.view;

import at.fhtw.app.helperServices.Form.FormInputManager;
import at.fhtw.app.helperServices.Enums.FormMessages;
import at.fhtw.app.helperServices.Observer.TourListObserver;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.view.components.TourListViewFxComponents;
import at.fhtw.app.viewModel.TourFormViewModel;
import at.fhtw.app.viewModel.TourListViewModel;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TourListView extends TourListViewFxComponents implements TourListObserver, Initializable {

    public TourListViewModel tourListViewModel;
    public TourFormViewModel tourFormViewModel;
    public FormInputManager formInputManager;

    Alert alert = new Alert(Alert.AlertType.ERROR);
    Alert successPrompt = new Alert(Alert.AlertType.INFORMATION);

    public TourListView() {
        this.formInputManager = new FormInputManager();
        this.tourListViewModel = TourListViewModel.getInstance();
    }

    //Form Components


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tourListViewModel.registerObserver(this);
        //init List

        this.tourNamesList.setItems(tourListViewModel.getTourNameList());

        //init ChoiceBox
        String[] choiceBoxChoices = {"public transit", "car", "bike", "foot"};
        formTransportType.getItems().addAll(choiceBoxChoices);
    }

    @Override
    public void onTourListUpdated() {
        Platform.runLater(this::updateTourList);  //thread safe update
    }

    public void updateTourList() {
        System.out.println("UPDATE TOUR LIST: TourListView");
        ObservableList<String> tourNameList = tourListViewModel.getTourNameList();
        this.tourNamesList.getItems().add("testSTring");
        this.tourNamesList.refresh();
    }


    public void addTourFormShow(MouseEvent event) {
        //make TourList invisible
        if (tourNamesList.isVisible()) {
            tourNamesList.setVisible(false);
            tourForm.setVisible(true);
        } else {
            tourNamesList.setVisible(true);
            tourForm.setVisible(false);
        }
        System.out.println("Button clicked: startForm");
    }
}