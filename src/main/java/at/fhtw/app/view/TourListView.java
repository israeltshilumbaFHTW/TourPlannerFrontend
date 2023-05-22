package at.fhtw.app.view;

import at.fhtw.app.viewModel.TourListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class TourListView {
    public TourListViewModel tourListViewModel = new TourListViewModel();

    //Form Components
    @FXML
    private TextField formName;
    @FXML
    private TextField formDescription;
    @FXML
    private Button formSubmitButton;
    @javafx.fxml.FXML
    private ListView<String> tourList = new ListView<>();

    @FXML
    public void addTour(ActionEvent event) {
        System.out.println("Button clicked: addTour");
    }

    public void addTourFormShow(ActionEvent event) {
        //make TourList invisible
        tourList.setVisible(false);
        System.out.println("Button clicked: startForm");
    }

    @javafx.fxml.FXML
    public void initialize() {
        ObservableList<String> tourNameListList = FXCollections.observableArrayList();
        tourNameListList = tourListViewModel.getTourNameList();
        System.out.printf(tourNameListList.toString());
        tourList.setItems(tourNameListList);
    }

}