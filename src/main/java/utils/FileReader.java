package utils;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;

public class FileReader {

    public static ArrayList<String> getFileInput(String filePath){
        final ArrayList<String> searchTerms = new ArrayList<String>();
        if(filePath != null && !filePath.equalsIgnoreCase(" ")) {
            final File file = new File(filePath);
            if (file.exists()) {
                try (final BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
                    String currentLine;
                    while ((currentLine = br.readLine()) != null && !currentLine.equals("")) {
                        if(!searchTerms.contains(currentLine)){
                            searchTerms.add(currentLine);
                        }
                    }
                } catch (final Exception e) {
                    System.out.println("Error while reading the file " + file.getName());
                }
            }
        }
        return searchTerms;
    }
}
