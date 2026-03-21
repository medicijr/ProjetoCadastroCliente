package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validador {

    public static boolean validarData(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(data, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean validarEmail(String email) {
        return email.contains("@") && email.contains(".com");
    }

    public static boolean validarTelefone(String telefone) {
        return telefone.length() >= 10 && telefone.length() <= 11;
    }
}