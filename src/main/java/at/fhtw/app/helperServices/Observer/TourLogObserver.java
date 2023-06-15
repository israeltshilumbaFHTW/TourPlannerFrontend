package at.fhtw.app.helperServices.Observer;

import at.fhtw.app.helperServices.Listener.TourLogListener;

import java.util.ArrayList;
import java.util.List;

import static at.fhtw.app.Application.logger;

public abstract class TourLogObserver {
    //List, register, notify
    private final List<TourLogListener> listeners = new ArrayList<>();

    public void registerTourLogListener(TourLogListener tourLogListener) {
        logger.debug("register TourLog Listener");
        this.listeners.add(tourLogListener);
    }

    public void notifyTourLogListener() {
        logger.debug("notify Listeners");
        for (var listener : listeners) {
            listener.onTourLogListUpdated();
        }
    }
}
