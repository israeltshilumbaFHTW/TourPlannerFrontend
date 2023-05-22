package at.fhtw.app.view;

import at.fhtw.app.viewModel.TourListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class TourListView {
    public TourListViewModel tourListViewModel = new TourListViewModel();

    //Form Components
    @FXML
    public AnchorPane tourForm;
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

    @FXML
    public void addTour(ActionEvent event) {
        System.out.println("Button clicked: addTour");
    }

    public void addTourFormShow(ActionEvent event) {
        //make TourList invisible
        tourList.setVisible(false);
        tourForm.setVisible(true);
        System.out.println("Button clicked: startForm");
    }

    @javafx.fxml.FXML
    public void initialize() {
        //init List
        ObservableList<String> tourNameListList = FXCollections.observableArrayList();
        tourNameListList = tourListViewModel.getTourNameList();
        System.out.printf(tourNameListList.toString());
        tourList.setItems(tourNameListList);

        //init ChoiceBox
        String[] choiceBoxChoices = {"public transit", "car", "bike", "foot"};
        formTransportType.getItems().addAll(choiceBoxChoices);
    }

}