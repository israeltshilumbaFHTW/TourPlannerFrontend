package at.fhtw.app.helperServices.Observer;

import at.fhtw.app.helperServices.Listener.TourListClickListener;
import at.fhtw.app.model.Tour;

import java.util.ArrayList;
import java.util.List;

import static at.fhtw.app.Application.logger;

public abstract class TourListClickObserver {

    private final List<TourListClickListener> listeners = new ArrayList<>();

    public void registerTourClickListener(TourListClickListener tourListClickListener) {
        logger.debug("registerTourClickListener");
        this.listeners.add(tourListClickListener);
    }

    public void notifyTourClickListeners(Tour selectedTour) {
        logger.debug("selected Tour ID: " + selectedTour.getId());
        for (var listener : listeners) {
            listener.changeSelection(selectedTour);
        }
    }
}
