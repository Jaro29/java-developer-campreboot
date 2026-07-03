package pl.coderslab.regex;

public class Main02 {

    public static void main(String[] args) {

    }

    static boolean verifyPassword(String password) {
        // 1. Sprawdzenie długości (od 10 do 15 znaków)
        if (password.length() < 10 || password.length() > 15) {
            return false;
        }

        // 2. Czy zawiera minimum jedną małą literę?
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // 3. Czy zawiera minimum jedną wielką literę?
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // 4. Czy NIE zawiera dwóch wielkich lub dwóch małych liter obok siebie?
        if (password.matches(".*[a-z]{2}.*") || password.matches(".*[A-Z]{2}.*")) {
            return false;
        }

        // Jeśli przeszło wszystkie testy, hasło jest poprawne!
        return true;
    }
}
