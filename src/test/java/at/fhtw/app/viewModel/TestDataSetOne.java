package at.fhtw.app.viewModel;

import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;

import java.util.ArrayList;
import java.util.List;

public abstract class TestDataSetOne {
    protected Tour getTestTourOne() {
        Tour tour = new Tour();
        List<TourLog> tourLogList = new ArrayList<>();
        tour.setId(1);
        tour.setName("Mountain Hike");
        tour.setDescription("A scenic mountain hike through breathtaking trails.");
        tour.setFromLocation("City A");
        tour.setToLocation("Mountain Peak");
        tour.setTransportType("Hiking");
        tour.setDistance(10.5);
        tour.setEstimatedTime("4 hours");
        tour.setDate("2023-06-20");
        tour.setImageUrl("https://example.com/image.jpg");
        tour.setRouteInformation("Trail maps and directions provided.");
        tour.setPopularity(8);
        tour.setChildFriendliness(4.5);
        tour.setTourLogList(new ArrayList<>());  // Empty list for tour logs

        TourLog tourLog = new TourLog();
        tourLog.setId(1);
        tourLog.setDate("2023-06-21");
        tourLog.setComment("Amazing views along the trail.");
        tourLog.setDifficulty(3);
        tourLog.setTotalTime(180);
        tourLog.setRating(4);

        TourLog tourLog2 = new TourLog();
        tourLog2.setId(1);
        tourLog2.setDate("2023-06-21");
        tourLog2.setComment("Amazing views along the trail.");
        tourLog2.setDifficulty(2);
        tourLog2.setTotalTime(180);
        tourLog2.setRating(5);

        tourLogList.add(tourLog);
        tourLogList.add(tourLog2);

        tour.setTourLogList(tourLogList);
        return tour;
    }

    protected Tour getTestTourTwo() {
        Tour tour = new Tour();
        List<TourLog> tourLogList = new ArrayList<>();
        tour.setId(2);
        tour.setName("Mountain Hike");
        tour.setDescription("A scenic mountain hike through breathtaking trails.");
        tour.setFromLocation("City A");
        tour.setToLocation("Mountain Peak");
        tour.setTransportType("Hiking");
        tour.setDistance(10.5);
        tour.setEstimatedTime("4 hours");
        tour.setDate("2023-06-20");
        tour.setImageUrl("https://example.com/image.jpg");
        tour.setRouteInformation("Trail maps and directions provided.");
        tour.setPopularity(8);
        tour.setChildFriendliness(4.5);
        tour.setTourLogList(new ArrayList<>());  // Empty list for tour logs

        TourLog tourLog = new TourLog();
        tourLog.setId(1);
        tourLog.setDate("2023-06-21");
        tourLog.setComment("Amazing views along the trail.");
        tourLog.setDifficulty(1);
        tourLog.setTotalTime(180);
        tourLog.setRating(3);

        TourLog tourLog2 = new TourLog();
        tourLog2.setId(1);
        tourLog2.setDate("2023-06-21");
        tourLog2.setComment("Amazing views along the trail.");
        tourLog2.setDifficulty(1);
        tourLog2.setTotalTime(180);
        tourLog2.setRating(2);

        tourLogList.add(tourLog);
        tourLogList.add(tourLog2);

        tour.setTourLogList(tourLogList);
        return tour;
    }
}
