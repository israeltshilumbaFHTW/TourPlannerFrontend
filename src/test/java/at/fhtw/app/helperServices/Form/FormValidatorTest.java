package at.fhtw.app.helperServices.Form;

import at.fhtw.app.helperServices.CustomExceptions.InvalidInputException;
import at.fhtw.app.helperServices.Enums.FormMessages;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.model.TourLog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormValidatorTest extends TestDataSetTwo {


    FormValidator formValidator = new FormValidator();

    @Test
    void invalidCharacterNameTest() {
        FormTour formTour = nameWithSpecialCharacter();
        try {
            formValidator.validateInput(formTour);
        } catch (Exception e) {
            assertEquals(e.getMessage(), FormMessages.INVALID_NAME.getMessage());
        }
    }

    @Test
    void invalidEmptyNameTest() {
        FormTour formTour = emptyName();
        try {
            formValidator.validateInput(formTour);
        } catch (Exception e) {
            assertEquals(e.getMessage(), FormMessages.INVALID_NAME.getMessage());
        }
    }

    @Test
    void validFormTourTest() {
        FormTour formTour = validFormTour();
        try {
            formValidator.validateInput(formTour);
        } catch (Exception ignored) {
        }
    }

    @Test
    void logInvalidEmptyLogTest() {
        TourLog tourLog = emptyLog();
        try {
            formValidator.validateInput(tourLog);
        } catch (Exception e) {
            assertEquals(e.getMessage(), FormMessages.INVALID_LOG_COMMENT.getMessage());
        }
    }

    @Test
    void logInvalidCharacterTest() {
        TourLog tourLog = invalidCharacterComment();
        try {
            formValidator.validateInput(tourLog);
        } catch (Exception e) {
            assertEquals(e.getMessage(), FormMessages.INVALID_LOG_COMMENT.getMessage());
        }
    }

    @Test
    void validTourLogTest() {
        TourLog tourLog = validTourLog();
        try {
            formValidator.validateInput(tourLog);
        } catch (Exception ignored) {
        }
    }
}