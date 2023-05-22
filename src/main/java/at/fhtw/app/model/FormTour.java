package at.fhtw.app.model;

import org.apache.http.entity.SerializableEntity;

import java.io.Serializable;

public class FormTour implements Serializable {
    private String name;
    private String description;
    private String from;
    private String to;
    private String transportType;
    private String routeInformation;

    public FormTour(String name, String description, String from, String to, String transportType, String routeInformation) {
        this.name = name;
        this.description = description;
        this.from = from;
        this.to = to;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
