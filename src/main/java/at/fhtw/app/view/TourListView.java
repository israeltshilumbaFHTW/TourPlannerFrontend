package at.fhtw.app.view;

import at.fhtw.app.helperServices.Form.FormInputManager;
import at.fhtw.app.helperServices.Listener.TourListListener;
import at.fhtw.app.view.components.TourListViewFxComponents;
import at.fhtw.app.viewModel.TourListViewModel;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TourListView extends TourListViewFxComponents implements TourListListener, Initializable {

    public TourListViewModel tourListViewModel;
    public FormInputManager formInputManager;


    public TourListView() {
        this.formInputManager = new FormInputManager();
        this.tourListViewModel = TourListViewModel.getInstance();
    }

    //Form Components


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tourListViewModel.registerTourNameListObserver(this);
        //init List

        this.tourNamesList.setItems(tourListViewModel.getTourNameList());
        this.tourNamesList.setOnMouseClicked(this::handleTourSelection);
        this.tourNamesList.getSelectionModel().selectFirst();

        //init ChoiceBox
        String[] choiceBoxChoices = {"public transit", "car", "bike", "foot"};
        formTransportType.getItems().addAll(choiceBoxChoices);
    }

    private void handleTourSelection(MouseEvent event) {
        System.out.println("handleTourSelection");
        int selectedTourIndex = tourNamesList.getSelectionModel().getSelectedIndex();
        this.tourListViewModel.selectTour(selectedTourIndex);

    }

    @Override
    public void onTourListUpdated() {
        Platform.runLater(this::updateTourList);  //thread safe update
        this.tourNamesList.setVisible(true);
    }

    public void updateTourList() {
        System.out.println("UPDATE TOUR LIST: TourListView");
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