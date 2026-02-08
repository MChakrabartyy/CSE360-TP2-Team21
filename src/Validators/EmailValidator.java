package Validators;

/**
 * EmailValidator - Validates email format
 * 
 * Rules:
 * - Cannot be empty
 * - Must contain exactly one @ symbol
 * - Must have text before @
 * - Must have domain after @ with at least one dot
 * - No spaces allowed
 * 
 * @author Manisha
 */
public class EmailValidator {
    
    private String email;
    private String errorMessage;
    private boolean isValid;
    
    public EmailValidator() {
        this.email = "";
        this.errorMessage = "";
        this.isValid = false;
    }
    
    public boolean validate(String email) {
        this.email = email;
        this.errorMessage = "";
        this.isValid = false;
        
        // Check null or empty
        if (email == null || email.isEmpty()) {
            this.errorMessage = "Email cannot be empty";
            return false;
        }
        
        // Check for spaces
        if (email.contains(" ")) {
            this.errorMessage = "Email cannot contain spaces";
            return false;
        }
        
        // Check for @ symbol
        int atIndex = email.indexOf('@');
        if (atIndex == -1) {
            this.errorMessage = "Email must contain @ symbol";
            return false;
        }
        
        // Check for multiple @ symbols
        if (email.indexOf('@') != email.lastIndexOf('@')) {
            this.errorMessage = "Email can only have one @ symbol";
            return false;
        }
        
        // Check for text before @
        if (atIndex == 0) {
            this.errorMessage = "Email must have text before @ symbol";
            return false;
        }
        
        // Get domain part
        String domain = email.substring(atIndex + 1);
        
        // Check for domain after @
        if (domain.isEmpty()) {
            this.errorMessage = "Email must have domain after @ symbol";
            return false;
        }
        
        // Check domain has a dot
        if (!domain.contains(".")) {
            this.errorMessage = "Email domain must contain a dot";
            return false;
        }
        
        // Check domain doesn't start with dot
        if (domain.startsWith(".")) {
            this.errorMessage = "Email domain cannot start with a dot";
            return false;
        }
        
        // Check domain doesn't end with dot
        if (domain.endsWith(".")) {
            this.errorMessage = "Email domain cannot end with a dot";
            return false;
        }
        
        this.isValid = true;
        return true;
    }
    
    public boolean isValid() {
        return this.isValid;
    }
    
    public String getErrorMessage() {
        return this.errorMessage;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public static String checkEmail(String email) {
        EmailValidator validator = new EmailValidator();
        validator.validate(email);
        return validator.getErrorMessage();
    }
}