package at.fhtw.app.helperServices.Form;

import at.fhtw.app.helperServices.Enums.FormMessages;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.model.TourLog;

public class FormInputManager {
    private final FormValidator formValidator;

    public FormInputManager() {
        formValidator = new FormValidator();
    }

    public String validateForm(FormTour formTour) {

        try {
            formValidator.validateInput(formTour);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return FormMessages.VALID_FORM.getMessage();
    }

    public String validateForm(TourLog tourLog) {
        try {
            formValidator.validateInput(tourLog);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return FormMessages.VALID_FORM.getMessage();
    }
}
