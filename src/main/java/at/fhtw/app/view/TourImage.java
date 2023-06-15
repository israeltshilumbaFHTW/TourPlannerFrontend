package at.fhtw.app.view;

import at.fhtw.app.helperServices.Listener.TourListClickListener;
import at.fhtw.app.model.Tour;
import at.fhtw.app.viewModel.TourListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

import static at.fhtw.app.Application.logger;

public class TourImage implements Initializable, TourListClickListener {


    @FXML
    public ImageView routeImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TourListViewModel tourListViewModel = TourListViewModel.getInstance();
        tourListViewModel.registerTourClickListener(this);
        String imageUrl = "https://www.mapquestapi.com/staticmap/v5/map?start=San+Francisco,CA&end=Los+Angeles,JP&routeArc=false&size=800,600@2x&key=nathu9TckDPtj5j4LKlMMv2Zh0nxDlYg";
        Image image = new Image(imageUrl);
        routeImageView.setImage(image);
        routeImageView.setPreserveRatio(true);
    }

    @Override
    public void changeSelection(Tour tour) {
        logger.debug("ChangeSelection Image");
        Image image = new Image(tour.getImageUrl());
        logger.debug("tourImageUrl:" + tour.getImageUrl());
        routeImageView.setImage(image);
    }
}
