package org.howard.edu.lsp.midterm.question1;

public class SecurityOps {
    /**
     * Encrypts the input string by arranging characters at even indices first
     * followed by characters at odd indices, ignoring punctuation and whitespace.
     * This method is case-sensitive and retains the case of each character.
     *
     * @param text The input string to be encrypted
     * @return The encrypted string
     */
    public static String encrypt(String text) {
        // StringBuilder for efficient string modification
        StringBuilder evenIndexed = new StringBuilder();
        StringBuilder oddIndexed = new StringBuilder();

        // Remove all non-alphanumeric characters
        text = text.replaceAll("[\\W_]", ""); // Underscore is also considered non-word

        // Iterate over the characters of the string
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) {
                // Add characters at even indices
                evenIndexed.append(text.charAt(i));
            } else {
                // Add characters at odd indices
                oddIndexed.append(text.charAt(i));
            }
        }

        // Combine even and odd indexed characters to encrypt the string
        return evenIndexed.toString() + oddIndexed.toString();
    }

}


