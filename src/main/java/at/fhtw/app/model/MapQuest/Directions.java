package at.fhtw.app.model.MapQuest;

import java.io.Serializable;

public class Directions implements Serializable {
    private double distance;
    private int time;
    private String mapUrl;

    // Constructor
    public Directions(double distance, int time, String mapUrl) {
        this.distance = distance;
        this.time = time;
        this.mapUrl = mapUrl;
    }

    public Directions() {
    }

    // Getters
    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    @Override
    public String toString() {
        return "Directions{" +
                "distance=" + distance +
                ", time=" + time +
                ", mapUrl='" + mapUrl + '\'' +
                '}';
    }
}