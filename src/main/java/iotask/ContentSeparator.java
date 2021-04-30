package iotask;

import java.io.*;


public class ContentSeparator {
    FileReader fileReader = new FileReader();
    File resultsFile = new File("src/main/resources/results.txt");
    BufferedWriter writer;

    {
        try {
            writer = new BufferedWriter(new FileWriter(resultsFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String createDirectoryStructure(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("folder is not a Directory");
        }
        int indent = 0;
        StringBuilder stringBuilder = new StringBuilder();
        createDirectoryStructureFile(folder, indent, stringBuilder);
        return stringBuilder.toString();
    }

    public void createDirectoryStructureFile(File folder, int indent, StringBuilder stringBuilder) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("folder is not a Directory");
        }
        stringBuilder.append(makeIndent(indent));
        stringBuilder.append("+--");
        stringBuilder.append(folder.getName());
        stringBuilder.append("/");
        stringBuilder.append("\n");
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                createDirectoryStructureFile(file, indent + 1,  stringBuilder);
            }
            else {
                createFileStructure(file, indent + 1, stringBuilder);
            }
        }
    }

    private void createFileStructure(File file, int indent, StringBuilder stringBuilder) {
        stringBuilder.append(makeIndent(indent));
        stringBuilder.append("---");
        stringBuilder.append(file.getName());
        stringBuilder.append("\n");
    }

    private String makeIndent(int indent) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("| ");
        }
        return stringBuilder.toString();
    }

    public void showTreeOfAFolder(String folderPath) {
        try {
            if (folderPath.endsWith(".txt")) {
                fileReader.getContentFromFile();
            } else {
                writer.write(createDirectoryStructure(folderPath));
                writer.close();
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
