package at.fhtw.app.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;

public class FormTour implements Serializable {
    @JsonAlias({"name"})
    private String name;
    @JsonAlias({"description"})
    private String description;
    @JsonAlias({"from_location"})
    private String from_location;
    @JsonAlias({"to_location"})
    private String to_location;

    @JsonAlias({"transport_type"})
    private String transportType;
    @JsonAlias({"route_information"})
    private String routeInformation;

    public FormTour(String name, String description, String from_location, String to_location, String transportType, String routeInformation) {
        this.name = name;
        this.description = description;
        this.from_location = from_location;
        this.to_location = to_location;
        this.transportType = transportType;
        this.routeInformation = routeInformation;
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

    public String getFromLocation() {
        return from_location;
    }

    public void setFromLocation(String from_location) {
        this.from_location = from_location;
    }

    public String getToLocation() {
        return this.to_location;
    }

    public void setToLocation(String from_to) {
        this.to_location = to_location;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getRouteInformation() {
        return routeInformation;
    }

    public void setRouteInformation(String routeInformation) {
        this.routeInformation = routeInformation;
    }

}
