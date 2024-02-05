package org.howard.edu.lsp.assignment2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    	Map<String, Integer> wordCount = new HashMap<>();
        String relativePath = "words.txt";

        try {
        	// Prints out the input file as a string to the console
            String fileContent = FileReader.readFileAsString(relativePath);
            System.out.println("The input file is as follows: ");
            System.out.println(fileContent);
            
            List<String> tokenList = FileReader.tokenizeString(fileContent); // Tokenizes the input file string
            
            // Iterates through string tokens and keeps track of each valid (non-numeric or non-trivial) token's occurrence in a HashMap
            System.out.println("Here is the word count for the input file");
            for (String token : tokenList) {
            	if (FileReader.isNumeric(token) || token.length()<=3 ) {
            		continue;
            	}
            	if (wordCount.containsKey(token)) {
            		wordCount.put(token, wordCount.get(token) + 1);
            	} else {
            		wordCount.put(token, 1);
            	}
            }
            
            // Prints out word count for each word in HashMap
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            //System.out.println("File Content:\n" + fileContent);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        
        
    }

}
