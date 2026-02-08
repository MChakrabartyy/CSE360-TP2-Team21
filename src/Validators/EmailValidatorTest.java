package Validators;

/**
 * Test class for EmailValidator
 * 
 * @author Manisha
 */
public class EmailValidatorTest {
    
    private static int passed = 0;
    private static int failed = 0;
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("    EMAIL VALIDATOR TESTS");
        System.out.println("========================================\n");
        
        // Should FAIL
        test("Empty string", "", false);
        test("No @ symbol", "johnexample.com", false);
        test("Multiple @ symbols", "john@@example.com", false);
        test("Nothing before @", "@example.com", false);
        test("Nothing after @", "john@", false);
        test("No dot in domain", "john@examplecom", false);
        test("Domain starts with dot", "john@.example.com", false);
        test("Domain ends with dot", "john@example.", false);
        test("Contains space", "john doe@example.com", false);
        
        // Should PASS
        test("Valid simple", "john@example.com", true);
        test("Valid with dot in local", "john.doe@example.com", true);
        test("Valid subdomain", "john@mail.example.com", true);
        test("Valid multiple dots", "john@sub.mail.example.com", true);
        test("Valid with numbers", "john123@example.com", true);
        
        // Summary
        System.out.println("\n========================================");
        System.out.println("    SUMMARY");
        System.out.println("========================================");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Total:  " + (passed + failed));
        System.out.println("========================================");
    }
    
    private static void test(String testName, String input, boolean shouldPass) {
        EmailValidator validator = new EmailValidator();
        boolean result = validator.validate(input);
        
        boolean testPassed = (result == shouldPass);
        
        if (testPassed) {
            System.out.println("✓ PASS: " + testName);
            passed++;
        } else {
            System.out.println("✗ FAIL: " + testName);
            System.out.println("        Input: \"" + input + "\"");
            System.out.println("        Expected: " + shouldPass + ", Got: " + result);
            System.out.println("        Error: " + validator.getErrorMessage());
            failed++;
        }
    }
}