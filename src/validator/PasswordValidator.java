package validator;

public class PasswordValidator {

    private boolean hasUppercase;
    private boolean hasLowercase;
    private boolean hasDigit;
    private boolean hasSpecialChar;
    private boolean hasMinLength;
    private boolean hasMaxLength;

    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 100;

    public boolean validate(String password) {
        resetStates();

        if (password == null) {
            return false;
        }

        int length = password.length();

        if (length >= MIN_LENGTH) {
            hasMinLength = true;
        }

        if (length > MAX_LENGTH) {
            hasMaxLength = false;
            return false;
        }

        for (int i = 0; i < length; i++) {
            char c = password.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                hasUppercase = true;
            } else if (c >= 'a' && c <= 'z') {
                hasLowercase = true;
            } else if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else if ("!@#$%^&*".indexOf(c) >= 0) {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar && hasMinLength && hasMaxLength;
    }

    private void resetStates() {
        hasUppercase = false;
        hasLowercase = false;
        hasDigit = false;
        hasSpecialChar = false;
        hasMinLength = false;
        hasMaxLength = true;
    }

    public boolean hasUppercase() {
        return hasUppercase;
    }

    public boolean hasLowercase() {
        return hasLowercase;
    }

    public boolean hasDigit() {
        return hasDigit;
    }

    public boolean hasSpecialCharacter() {
        return hasSpecialChar;
    }

    public boolean hasMinLength() {
        return hasMinLength;
    }

    public boolean hasMaxLength() {
        return hasMaxLength;
    }

    public String getRequirementsStatus() {
        return "Uppercase: " + (hasUppercase ? "Y" : "N") + "\n"
             + "Lowercase: " + (hasLowercase ? "Y" : "N") + "\n"
             + "Digit: " + (hasDigit ? "Y" : "N") + "\n"
             + "Special Character: " + (hasSpecialChar ? "Y" : "N") + "\n"
             + "Minimum Length (8): " + (hasMinLength ? "Y" : "N") + "\n"
             + "Maximum Length (100): " + (hasMaxLength ? "Y" : "N");
    }
}