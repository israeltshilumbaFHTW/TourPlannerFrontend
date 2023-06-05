package at.fhtw.app.view;

import at.fhtw.app.helperServices.Listener.TourListClickListener;
import at.fhtw.app.model.Tour;
import at.fhtw.app.view.components.GeneralViewFxComponents;
import at.fhtw.app.viewModel.TourListViewModel;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneralView extends GeneralViewFxComponents implements TourListClickListener, Initializable {

    @Override
    public void changeSelection(Tour tour) {
        this.tourName.setText(tour.getName());
        this.tourDescription.setText(tour.getDescription());
        this.tourFrom.setText(tour.getFrom());
        this.tourTo.setText(tour.getTo());
        this.routeInformation.setText(tour.getRouteInformation());
        this.tourPopularity.setText(tour.getPopularity().toString());
        this.tourChildFriendliness.setText(tour.getChildFriendliness().toString());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TourListViewModel tourListViewModel = TourListViewModel.getInstance();
        tourListViewModel.registerTourClickListener(this);
    }
}
