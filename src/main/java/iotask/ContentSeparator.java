package iotask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class ContentSeparator {
    File folder;
    File[] listOfContent;
    BufferedWriter writer;
    String resultsFilePath = "src/main/resources/contentSeparatorFile.txt";
    FileReader fileReader = new FileReader();


    {
        try {
            writer = new BufferedWriter(new FileWriter(resultsFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createDirectoryStructureFile(String folderPath) {
        folder = new File(folderPath);
        listOfContent = folder.listFiles();
        int fileCounter = 1;
        String indentForDirectories = "------";

        try {
            writer.newLine();

            for (File entity : listOfContent) {
                if (entity.isFile()) {
                    writer.write("   (" + fileCounter + ")" + entity.getName() + "\n");
                    fileCounter++;
                }
            }
            for (File entity1 : listOfContent) {
                if (entity1.isDirectory()) {
                    writer.newLine();
                    writer.write(indentForDirectories + entity1.getName());
                    folder = new File(folderPath + "\\" + entity1.getName());
                    createDirectoryStructureFile(folder.getPath());
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTreeOfAFolder(String folderPath) {
        try {
            if (folderPath.equals("src/main/resources/results.txt")) {
                fileReader.getContentFromFile();
            } else {
                writer.write(folderPath);
                createDirectoryStructureFile(folderPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
