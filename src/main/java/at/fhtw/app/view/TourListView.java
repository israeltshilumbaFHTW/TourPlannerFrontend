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

import static at.fhtw.app.Application.logger;

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
        logger.debug("initialize TourListView");
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
        logger.debug("handle TourSelection");
        int selectedTourIndex = tourNamesList.getSelectionModel().getSelectedIndex();
        this.tourListViewModel.selectTour(selectedTourIndex);

    }

    @Override
    public void onTourListUpdated() {
        Platform.runLater(this::updateTourList);  //thread safe update
        this.tourNamesList.setVisible(true);
    }

    public void updateTourList() {
        logger.debug("UPDATE TOUR LIST: TourListView");
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
        logger.debug("Button clicked: startForm");
    }
}