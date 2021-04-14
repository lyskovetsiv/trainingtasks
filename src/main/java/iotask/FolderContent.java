package iotask;

public class FolderContent {
    public static void main(String[] args) {
        ContentSeparator contentSeparator = new ContentSeparator();

        contentSeparator.showTreeOfAFolder("D:\\JustForPractice");
        contentSeparator.showTreeOfAFolder("src/main/resources/results.txt");
    }
}
