package org.howard.edu.lsp.assignment2;

import java.io.IOException;
import java.net.URISyntaxException;
//import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Example usage
        String relativePath = "words.txt";

        try {
            String fileContent = FileReader.readFileAsString(relativePath);
            List<String> tokenList = FileReader.tokenizeString(fileContent);
            //System.out.println("File Content:\n" + fileContent);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        
        
    }

}
