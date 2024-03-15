package org.howard.edu.lsp.midterm.question1;

public class Driver {
    public static void main(String[] args) {
        String originalText = "I love CSCI363";
        String encryptedText = SecurityOps.encrypt(originalText);
        System.out.println("The encrypted text is: " + encryptedText);
    }
}
