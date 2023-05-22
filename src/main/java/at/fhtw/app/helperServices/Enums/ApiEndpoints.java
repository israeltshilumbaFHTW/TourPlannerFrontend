package at.fhtw.app.helperServices.Enums;

public enum ApiEndpoints {
    GET_TOURS("http://localhost:8080/tours"),
    POST_TOUR("http://localhost:8080/tours"),
    GET_TOUR_LOGS("http://localhost:8080/tourLogs/"),
    POST_TOUR_LOGS("http://localhost:8080/tourLogs/");

    private final String endPoint;

    private ApiEndpoints(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return this.endPoint;
    }
}
