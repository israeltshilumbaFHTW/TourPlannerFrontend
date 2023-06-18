package at.fhtw.app.viewModel;

import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static at.fhtw.app.Application.logger;
import static org.junit.jupiter.api.Assertions.*;

class GeneralViewModelTest extends TestDataSetOne {

    GeneralViewModel generalViewModel = GeneralViewModel.getInstance();

    @Test
    void getAvgRating() { //Ratings: 4 and 5 -> 4.5
        Tour testTour = getTestTourOne();
        String averageRating = generalViewModel.getAvgRating(testTour);
        logger.debug("avg Rating Test: " + averageRating);
        assertEquals("4,50", averageRating);
    }

    @Test
    void changeAvgRating() { //changing Rating for 4|5 to 1|5 = 3
        Tour testTour = getTestTourOne();
        testTour.getTourLogList().get(0).setRating(1);
        String averageRating = generalViewModel.getAvgRating(testTour);
        logger.debug("avg Rating Test: " + averageRating);
        assertEquals("3,00", averageRating);
    }

    @Test
    void getChildFriendlinessNo() { //avg is 2.5
        Tour testTour = getTestTourOne();
        String childFriendliness = generalViewModel.getChildFriendliness(testTour);
        logger.debug("childFriendliness Test: " + childFriendliness);
        assertEquals("no", childFriendliness);
    }

    @Test
    void getChildFriendlinessYes() { //avg is 2
        Tour testTour = getTestTourTwo();
        GeneralViewModel generalViewModel = GeneralViewModel.getInstance();
        String childFriendliness = generalViewModel.getChildFriendliness(testTour);
        logger.debug("childFriendliness Test: " + childFriendliness);
        assertEquals("yes", childFriendliness);
    }

    @Test
    void getChildFriendlinessFromYesToNoAfterChange() {//change difficulty from 1 and 1 -> 5 and 1
        Tour testTour = getTestTourTwo();
        testTour.getTourLogList().get(0).setDifficulty(5);
        GeneralViewModel generalViewModel = GeneralViewModel.getInstance();
        String childFriendliness = generalViewModel.getChildFriendliness(testTour);
        logger.debug("childFriendliness Test: " + childFriendliness);
        assertEquals("no", childFriendliness);
    }
}