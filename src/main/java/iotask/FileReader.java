package iotask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileReader {
    BufferedReader reader;
    String resultsFilePath = "src/main/resources/results.txt";

    {
        try {
            Files.copy(Paths.get("src/main/resources/contentSeparatorFile.txt"), new File("src/main/resources/results.txt").toPath(), StandardCopyOption.REPLACE_EXISTING);
            reader = new BufferedReader(new java.io.FileReader(resultsFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getContentFromFile() {
        int fileCounter = 0;
        int directoryCounter = 0;
        String line;
        int lineLength = 0;

        try {
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("------")) {
                    directoryCounter++;
                }
                else if (line.startsWith("   (")) {
                    fileCounter++;
                    lineLength = lineLength + line.length();
                }
            }
            System.out.println("Number of directories: " + directoryCounter);
            System.out.println("Number of files: " + fileCounter);
            if (fileCounter != 0) {
                System.out.println("Average number of files in a directory: " + Math.round(fileCounter / (double) directoryCounter));
                System.out.println("Average length of a file name: " + lineLength / fileCounter);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
