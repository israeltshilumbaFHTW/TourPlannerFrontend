package at.fhtw.app.helperServices.Form;

import at.fhtw.app.model.FormTour;
import at.fhtw.app.model.TourLog;

public abstract class TestDataSetTwo {
    protected FormTour nameWithSpecialCharacter() {
        FormTour formTour = new FormTour(
                "!!",
                "",
                "",
                "",
                "",
                ""
        );

        return formTour;
    }

    protected FormTour emptyName() {
        FormTour formTour = new FormTour(
                "",
                "",
                "",
                "",
                "",
                ""
        );

        return formTour;
    }

    protected TourLog emptyLog() {
        TourLog tourLog = new TourLog();
        return tourLog;
    }

    protected TourLog invalidCharacterComment() {
        TourLog tourLog = new TourLog();
        tourLog.setComment("@");
        return tourLog;
    }

    protected TourLog validTourLog() {
        TourLog tourLog = new TourLog();
        tourLog.setId(1);
        tourLog.setDate("2023-06-21");
        tourLog.setComment("Amazing views along the trail.");
        tourLog.setDifficulty(3);
        tourLog.setTotalTime(180);
        tourLog.setRating(4);
        return tourLog;
    }

    protected FormTour validFormTour() {
        FormTour formTour = new FormTour(
                "test",
                "test",
                "test",
                "test",
                "test",
                "test"
        );

        return formTour;
    }
}
