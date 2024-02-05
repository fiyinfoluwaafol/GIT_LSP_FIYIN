package org.howard.edu.lsp.assignment2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileReader {

    public static String readFileAsString(String relativePath) throws IOException, URISyntaxException {
        // Get the current class
        Class<?> clazz = FileReader.class;

        // Get the package name (replace '.' with '/')
        String packageName = clazz.getPackageName().replace('.', '/');

        // Construct the resource path
        String resourcePath = packageName + "/" + relativePath;

        // Get the resource URL
        URL resourceUrl = clazz.getClassLoader().getResource(resourcePath);

        if (resourceUrl != null) {
            // Convert URL to file path
            Path filePath = Paths.get(resourceUrl.toURI());

            // Read the file content using java.nio.file.Files
            return Files.lines(filePath)
                    .collect(Collectors.joining(System.lineSeparator()));
        } else {
            throw new IOException("File not found: " + relativePath);
        }
    }
    
    public static List<String> tokenizeString(String input) {
        List<String> tokens = new ArrayList<>();

        // Use StringTokenizer to tokenize the input string
        StringTokenizer tokenizer = new StringTokenizer(input);

        // Collect tokens into the list
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken().toLowerCase());
        }

        return tokens;
    }
    
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



}
