package at.fhtw.app.model;

import java.util.Date;

public class Tour {
    private Integer id;
    private String name;
    private String description;
    private String fromLocation;
    private String toLocation;
    private String transportType;
    private Double distance;
    private Double estimatedTime;
    private String date;

    public Tour(Integer id, String name, String description, String fromLocation, String toLocation, String transportType, Double distance, Double estimatedTime, String date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.transportType = transportType;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrom() {
        return fromLocation;
    }

    public void setFrom(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getTo() {
        return toLocation;
    }

    public void setTo(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getTime() {
        return estimatedTime;
    }

    public void setTime(Double estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

