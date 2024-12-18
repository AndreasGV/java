package gestionentreprise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Méthode pour valider une date au format YYYY-MM-DD
    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date, FORMATTER); // Vérifie si la date correspond au format
            return true;
        } catch (DateTimeParseException e) {
            return false; // Retourne false si la date est invalide
        }
    }
}