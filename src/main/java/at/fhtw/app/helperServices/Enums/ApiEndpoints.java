package at.fhtw.app.helperServices.Enums;

public enum ApiEndpoints {
    GET_TOUR("http://localhost:8080/tours/"),
    GET_TOURS("http://localhost:8080/tours"),
    POST_TOUR("http://localhost:8080/tours"),
    GET_TOUR_LOGS("http://localhost:8080/tourLogs/"),
    POST_TOUR_LOGS("http://localhost:8080/tourLogs/"),
    DELETE_TOUR("http://localhost:8080/tours/"),
    DELETE_TOUR_LOG("http://localhost:8080/tourLogs/delete/");


    private final String endPoint;

    ApiEndpoints(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return this.endPoint;
    }
}
