package at.fhtw.app.helperServices.Form;

import at.fhtw.app.helperServices.CustomExceptions.InvalidInputException;
import at.fhtw.app.helperServices.Enums.FormMessages;
import at.fhtw.app.model.FormTour;
import at.fhtw.app.model.Tour;
import at.fhtw.app.model.TourLog;
import at.fhtw.app.viewModel.TourListViewModel;

import java.util.regex.Pattern;

public class FormValidator {
    private static final Pattern SPECIAL_CHARACTERS =
            Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]");

    public void validateInput(FormTour formTour) throws InvalidInputException {
        //return false if it doesn't find anything
        //if it finds anything, throw a  InvalidInputException

        //check if Inputs contain Special characters
        if (SPECIAL_CHARACTERS.matcher(formTour.getName()).find()) { //assignment not comparison
            throw new InvalidInputException(FormMessages.INVALID_NAME.getMessage());
        }
        if (SPECIAL_CHARACTERS.matcher(formTour.getDescription()).find()) { //assignment not comparison
            throw new InvalidInputException(FormMessages.INVALID_DESCRIPTION.getMessage());
        }
        if (SPECIAL_CHARACTERS.matcher(formTour.getFromLocation()).find()) { //assignment not comparison
            throw new InvalidInputException(FormMessages.INVALID_FROM.getMessage());
        }
        if (SPECIAL_CHARACTERS.matcher(formTour.getToLocation()).find()) { //assignment not comparison
            throw new InvalidInputException(FormMessages.INVALID_TO.getMessage());
        }
        if (SPECIAL_CHARACTERS.matcher(formTour.getRouteInformation()).find()) { //assignment not comparison
            throw new InvalidInputException(FormMessages.INVALID_ROUTE_INFORMATION.getMessage());
        }

        //check if input is empty

        if (formTour.getName().isEmpty()) { //assignment not comparison
            throw new InvalidInputException(FormMessages.INVALID_NAME.getMessage());
        }
        if (formTour.getDescription().isEmpty()) { //assignment not comparison
            throw new InvalidInputException(FormMessages.INVALID_DESCRIPTION.getMessage());
        }
        if (formTour.getFromLocation().isEmpty()) { //assignment not comparison
            throw new InvalidInputException(FormMessages.INVALID_FROM.getMessage());
        }
        if (formTour.getToLocation().isEmpty()) { //assignment not comparison
            throw new InvalidInputException(FormMessages.INVALID_TO.getMessage());
        }
        if (formTour.getRouteInformation().isEmpty()) { //assignment not comparison
            throw new InvalidInputException(FormMessages.INVALID_ROUTE_INFORMATION.getMessage());
        }
        if (formTour.getTransportType().isEmpty()) { //assignment not comparison
            throw new InvalidInputException(FormMessages.INVALID_TRANSPORT_TYPE.getMessage());
        }

    }

    public void validateInput(TourLog tourLog) throws InvalidInputException {
        //check if its empty
        if (tourLog.getComment() == null || tourLog.getComment().isEmpty()) {
            throw new InvalidInputException(FormMessages.INVALID_LOG_COMMENT.getMessage());
        }

        if (SPECIAL_CHARACTERS.matcher(tourLog.getComment()).find()) {
            throw new InvalidInputException(FormMessages.INVALID_LOG_COMMENT.getMessage());
        }

        if (tourLog.getDate() == null || tourLog.getDate().isEmpty()) {
            throw new InvalidInputException(FormMessages.INVALID_LOG_DATE.getMessage());
        }
        if (tourLog.getDifficulty() == null) {
            throw new InvalidInputException(FormMessages.INVALID_LOG_DIFFICULTY.getMessage());
        }
        if (tourLog.getRating() == null) {
            throw new InvalidInputException(FormMessages.INVALID_LOG_RATING.getMessage());
        }
    }
}
