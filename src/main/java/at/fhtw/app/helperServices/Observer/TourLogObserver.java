package at.fhtw.app.helperServices.Observer;

import at.fhtw.app.helperServices.Listener.TourLogListener;

import java.util.ArrayList;
import java.util.List;

public abstract class TourLogObserver {
    //List, register, notify
    private final List<TourLogListener> listeners = new ArrayList<>();

    public void registerTourLogListener(TourLogListener tourLogListener) {
        System.out.println("register TourLog Listener");
        this.listeners.add(tourLogListener);
    }

    public void notifyTourLogListener() {
        System.out.println("notify Listeners");
        for (var listener : listeners) {
            listener.onTourLogListUpdated();
        }
    }
}
