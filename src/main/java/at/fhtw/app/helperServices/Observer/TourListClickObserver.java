package at.fhtw.app.helperServices.Observer;

import at.fhtw.app.helperServices.Listener.TourListClickListener;
import at.fhtw.app.model.Tour;

import java.util.ArrayList;
import java.util.List;

public abstract class TourListClickObserver {

    private final List<TourListClickListener> listeners = new ArrayList<>();

    public void registerTourClickListener(TourListClickListener tourListClickListener) {
        System.out.println("registerTourClickListener");
        this.listeners.add(tourListClickListener);
    }

    public void notifyTourClickListeners(Tour selectedTour) {
        for (var listener : listeners) {
            listener.changeSelection(selectedTour);
        }
    }
}
