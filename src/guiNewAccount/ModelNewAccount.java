package guiNewAccount;

import validator.PasswordValidator;

public class ModelNewAccount {
    
    private static PasswordValidator passwordValidator = new PasswordValidator();

    public static String validatePassword(String password) {
        boolean isValid = passwordValidator.validate(password);
        if (isValid) {
            return "";
        }
        return passwordValidator.getRequirementsStatus();
    }
    
    public static boolean hasUppercase() {
        return passwordValidator.hasUppercase();
    }

    public static boolean hasLowercase() {
        return passwordValidator.hasLowercase();
    }

    public static boolean hasDigit() {
        return passwordValidator.hasDigit();
    }

    public static boolean hasSpecialChar() {
        return passwordValidator.hasSpecialCharacter();
    }

    public static boolean hasMinLength() {
        return passwordValidator.hasMinLength();
    }

    public static boolean hasMaxLength() {
        return passwordValidator.hasMaxLength();
    }
}