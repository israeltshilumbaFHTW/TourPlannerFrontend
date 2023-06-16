package at.fhtw.app.helperServices.Enums;

public enum ApiResponse {
    POST_SUCCESS("POST success"),
    POST_FAIL("POST failed"),
    DELETE_SUCCESS("DELETE success"),
    DELETE_FAIL("DELETE failed");

    private final String responseMessage;

    ApiResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
