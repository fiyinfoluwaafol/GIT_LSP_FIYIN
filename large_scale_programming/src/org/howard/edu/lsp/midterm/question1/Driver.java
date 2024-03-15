package org.howard.edu.lsp.midterm.question1;

public class Driver {
    public static void main(String[] args) {
        // Test cases to ensure the encrypt method covers a variety of scenarios
        String[] testStrings = {
            "I love CSCI363",      // Original test case with mixed case and numbers
            "Hello, World!",       // Test case with punctuation
            "Sphinx of black quartz, judge my vow.",  // Test case with longer string
            "1234567890",          // Test case with digits only
            "The quick brown fox jumps over the lazy dog.",  // Test case with all alphabets
            "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz",  // Test case with alternating cases
            "  ",                   // Test case with spaces only
            "!@#$%^&*()_+",        // Test case with special characters only
            ""                      // Test case with empty string
        };

        // Loop through all test cases
        for (String originalText : testStrings) {
            String encryptedText = SecurityOps.encrypt(originalText);
            System.out.println("Original text: " + originalText);
            System.out.println("Encrypted text: " + encryptedText);
            System.out.println();  // Print a blank line for better readability between cases
        }
    }
}
