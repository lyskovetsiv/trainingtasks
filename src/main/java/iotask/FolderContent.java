package iotask;

import java.io.IOException;

public class FolderContent {
    public static void main(String[] args) throws IOException {
        ContentSeparator contentSeparator = new ContentSeparator();
        contentSeparator.showTreeOfAFolder("src/main/resources/filedirectory");
        contentSeparator.showTreeOfAFolder("src/main/resources/results.txt");
    }
}