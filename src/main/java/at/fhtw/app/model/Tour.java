package at.fhtw.app.model;

import at.fhtw.app.backendApi.TourApi;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tour {
    private Integer id;
    private String name;
    private String description;
    private String fromLocation;
    private String toLocation;
    private String transportType;
    private Double distance;
    private String estimatedTime;
    private String date;
    private String imageUrl;
    private String routeInformation;
    private Integer popularity;
    private Double childFriendliness;
    private List<TourLog> tourLogList;

    public Tour() {
    }

    public Tour(String name, String description, String fromLocation, String toLocation, String transportType, Double distance, String estimatedTime, String imageUrl, String routeInformation) {
        this.name = name;
        this.description = description;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.transportType = transportType;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
        this.imageUrl = imageUrl;
        this.routeInformation = routeInformation;
        this.popularity = 0;
        this.childFriendliness = 0.00;
        this.tourLogList = new ArrayList<>();
    }

    @JsonCreator
    public Tour(@JsonProperty("id") Integer id,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description,
                @JsonProperty("fromLocation") String fromLocation,
                @JsonProperty("toLocation") String toLocation,
                @JsonProperty("transportType") String transportType,
                @JsonProperty("distance") Double distance,
                @JsonProperty("estimatedTime") String estimatedTime,
                @JsonProperty("date") String date,
                @JsonProperty("imageUrl") String imageUrl,
                @JsonProperty("routeInformation") String routeInformation,
                @JsonProperty("popularity") Integer popularity,
                @JsonProperty("childFriendliness") Double childFriendliness,
                @JsonProperty("tourLogList") List<TourLog> tourLogList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.transportType = transportType;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
        this.date = date;
        this.imageUrl = imageUrl;
        this.routeInformation = routeInformation;
        this.popularity = popularity;
        this.childFriendliness = childFriendliness;
        this.tourLogList = tourLogList;
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

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRouteInformation() {
        return routeInformation;
    }

    public void setRouteInformation(String routeInformation) {
        this.routeInformation = routeInformation;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Double getChildFriendliness() {
        return childFriendliness;
    }

    public void setChildFriendliness(Double childFriendliness) {
        this.childFriendliness = childFriendliness;
    }

    public List<TourLog> getTourLogList() {
        return tourLogList;
    }

    public void setTourLogList(List<TourLog> tourLogList) {
        this.tourLogList = tourLogList;
    }
}

