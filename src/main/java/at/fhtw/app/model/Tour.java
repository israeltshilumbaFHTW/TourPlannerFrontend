package at.fhtw.app.model;

public class Tour {
    private Integer id;
    private String from;
    private String to;
    private Integer distance;

    public Tour(Integer id, String from, String to, Integer distance) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
