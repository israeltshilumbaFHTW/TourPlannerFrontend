package at.fhtw.app.helperServices.Enums;

public enum FormMessages {
    INVALID_NAME("INVALID NAME"),
    INVALID_DESCRIPTION("INVALID DESCRIPTION"),
    INVALID_FROM("INVALID FROM"),
    INVALID_TO("INVALID TO"),
    INVALID_TRANSPORT_TYPE("INVALID TRANSPORT TYPE"),
    INVALID_ROUTE_INFORMATION("INVALID ROUTE INFORMATION"),
    VALID_FORM("VALID FORM"),
    FORM_ADDED("Your form has been successfully added");

    private String message = "MESSAGE";

    private FormMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
