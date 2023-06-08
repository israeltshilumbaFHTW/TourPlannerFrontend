package at.fhtw.app.helperServices.Enums;

public enum FormMessages {
    INVALID_NAME("INVALID NAME"),
    INVALID_DESCRIPTION("INVALID DESCRIPTION"),
    INVALID_FROM("INVALID FROM"),
    INVALID_TO("INVALID TO"),
    INVALID_TRANSPORT_TYPE("INVALID TRANSPORT TYPE"),
    INVALID_ROUTE_INFORMATION("INVALID ROUTE INFORMATION"),
    INVALID_LOG_COMMENT("INVALID LOG COMMENT"),
    INVALID_LOG_DATE("INVALID LOG DATE"),
    INVALID_LOG_DIFFICULTY("INVALID LOG DIFFICULTY"),
    INVALID_LOG_TOTAL_TIME("INVALID LOG TOTAL TIME"),
    INVALID_LOG_RATING("INVALID LOG RATING"),
    VALID_FORM("VALID FORM"),
    LOG_FORM_ADDED("Your form has been successfully added"),
    FORM_ADDED("Your form has been successfully added");


    private String message = "MESSAGE";

    FormMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
