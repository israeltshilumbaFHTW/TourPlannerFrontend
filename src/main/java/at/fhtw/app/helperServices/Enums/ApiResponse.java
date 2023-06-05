package at.fhtw.app.helperServices.Enums;

public enum ApiResponse {
    SUCCESS("POST success"),
    FAIL("POST failed");

    private final String responseMessage;

    ApiResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
