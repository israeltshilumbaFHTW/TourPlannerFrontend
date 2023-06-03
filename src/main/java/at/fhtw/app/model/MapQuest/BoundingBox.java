package at.fhtw.app.model.MapQuest;

public class BoundingBox {
    private Coordinate upperLeftLocation;
    private Coordinate lowerRightLocation;

    public BoundingBox() {
    }

    public BoundingBox(Coordinate upperLeftLocation, Coordinate lowerRightLocation) {
        this.upperLeftLocation = upperLeftLocation;
        this.lowerRightLocation = lowerRightLocation;
    }

    public Coordinate getUpperLeftLocation() {
        return upperLeftLocation;
    }

    public void setUpperLeftLocation(Coordinate upperLeftLocation) {
        this.upperLeftLocation = upperLeftLocation;
    }

    public Coordinate getLowerRightLocation() {
        return lowerRightLocation;
    }

    public void setLowerRightLocation(Coordinate lowerRightLocation) {
        this.lowerRightLocation = lowerRightLocation;
    }
}
