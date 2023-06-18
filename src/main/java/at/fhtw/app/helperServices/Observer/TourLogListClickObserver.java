package at.fhtw.app.helperServices.Observer;

import at.fhtw.app.helperServices.Listener.TourLogListClickListener;
import at.fhtw.app.model.TourLog;

import java.util.ArrayList;
import java.util.List;

import static at.fhtw.app.Application.logger;

public abstract class TourLogListClickObserver {
    private final List<TourLogListClickListener> listeners = new ArrayList<>();

    public void registerTouLogClickListener(TourLogListClickListener tourLogListClickListener) {
        logger.debug("register: TourLogListClickListener");
        this.listeners.add(tourLogListClickListener);
    }

    public void notifyTourLogClickListeners(TourLog selectedTourLog) {
        logger.debug("selected TourLog ID: " + selectedTourLog.getId());
        for (var listener : listeners) {
            listener.changeLogSelection(selectedTourLog);
        }
    }
}
