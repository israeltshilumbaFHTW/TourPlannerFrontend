package at.fhtw.app.viewModel;

import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.view.GeneralView;

import java.util.List;

import static at.fhtw.app.Application.logger;

public class GeneralViewModel {
    private static GeneralViewModel Instance = null;

    private GeneralViewModel() {
    }

    public static GeneralViewModel getInstance() {
        if (Instance == null) {
            Instance = new GeneralViewModel();
        }
        return Instance;
    }

    public int getTourLogSize(Tour tour) {
        return tour.getTourLogList().size();
    }

    public Double getPopularity(Tour tour) {
        int tourLogSize = getTourLogSize(tour);
        List<TourLog> tourLogList;
        tourLogList = tour.getTourLogList();
        int absoluteRating = 0;
        double relativeRating;

        for (TourLog tourLog : tourLogList) {
            absoluteRating += tourLog.getRating();
        }
        relativeRating = (double) absoluteRating / tourLogSize;

        return relativeRating;
    }

    public String getChildFriendliness(Tour tour) {
        int tourLogSize = getTourLogSize(tour);
        logger.debug("GeneralViewModel: getChildFriendliness TourLog Size: " + tourLogSize);
        //child friendliness
        String childFriendliness;
        int absoluteTourNumber = 0;

        for (TourLog tourLog : tour.getTourLogList()) {
            absoluteTourNumber += tourLog.getDifficulty();
        }
        double relativeDifficulty = (double) absoluteTourNumber / tourLogSize;
        if (relativeDifficulty < 2.5) {
            return "yes";
        } else {
            return "no";
        }
    }
}
