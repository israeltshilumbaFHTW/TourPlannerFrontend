package at.fhtw.app.helperServices.Form;

import at.fhtw.app.helperServices.Enums.FormMessages;
import at.fhtw.app.model.FormTour;

public class FormInputManager {
    private FormValidator formValidator;

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
}
