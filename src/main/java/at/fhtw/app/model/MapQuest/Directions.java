package at.fhtw.app.model.MapQuest;

import java.io.Serializable;
import java.time.LocalTime;

public class Directions implements Serializable {
    private double distance;
    private String time;
    private String sessionId;

    // Constructor
    public Directions(double distance, String time, String sessionId) {
        this.distance = distance;
        this.time = time;
        this.sessionId = sessionId;
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


    @Override
    public String toString() {
        return "Directions{" +
                "distance=" + distance +
                ", time=" + time +
                ", sessionId=" + sessionId +
                '}';
    }
}
