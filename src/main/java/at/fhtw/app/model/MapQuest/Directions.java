package at.fhtw.app.model.MapQuest;

import java.io.Serializable;
import java.time.LocalTime;

public class Directions implements Serializable {
    private double distance;
    private String time;
    private String sessionId;
    private BoundingBox boundingBox;

    // Constructor
    public Directions(double distance, String time, String sessionId) {
        this.distance = distance;
        this.time = time;
        this.sessionId = sessionId;
        this.boundingBox = new BoundingBox();
    }

    public Directions() {
    }

    // Getters
    public double getDistance() {
        return distance;
    }

    public String getTime() {
        return time;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    @Override
    public String toString() {
        return "Directions{" +
                "distance=" + distance +
                ", time=" + time +
                '}';
    }
}
