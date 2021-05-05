package iotask;

import java.io.*;

public class FileReader {
    BufferedReader reader;

    public void getContentFromFile(File file) {
        try {
            reader = new BufferedReader(new java.io.FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int fileCounter = 0;
        int directoryCounter = -1;
        String line;
        int lineLength = 0;

        try {
            while ((line = reader.readLine()) != null) {
                if (line.endsWith("/")) {
                    directoryCounter++;
                }
                else {
                    fileCounter++;
                    lineLength = lineLength + line.length() - (line.indexOf("---") + 3);
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
