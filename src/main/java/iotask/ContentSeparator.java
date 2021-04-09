package iotask;

import java.io.File;

public class ContentSeparator {
    File folder;
    File[] listOfContent;
    int numberOfDirectories = 0;
    int numberOfFiles = 0;
    int averageNumberOfFilesInDirectory;
    int averageLengthOfFileName;

    public void showFilesInAFolder(String folderPath) {
        folder = new File(folderPath);
        listOfContent = folder.listFiles();
        int fileCounter = 1;
        String indentForDirectories = "---";

        assert listOfContent != null;

        for (File entity : listOfContent) {
            if (entity.isFile()) {
                System.out.println("(" + fileCounter + ")" + entity.getName());
                fileCounter++;
                numberOfFiles++;
            }
        }
            for (File entity1 : listOfContent) {
                if (entity1.isDirectory()) {
                    System.out.println();
                    System.out.println(indentForDirectories + entity1.getName());
                    folder = new File(folderPath + "\\" + entity1.getName());
                    numberOfDirectories++;
                    showFilesInAFolder(folder.getPath());
                }
            }
        }

    public void showTreeOfAFolder(String folderPath) {
        if (folderPath.equals("D:\\justForPractice\\results.txt")) {
            System.out.println(numberOfDirectories);
            System.out.println(numberOfFiles);
        }
        else {
            System.out.println(folderPath);
            showFilesInAFolder(folderPath);
        }
    }
}
