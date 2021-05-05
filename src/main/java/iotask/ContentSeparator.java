package iotask;

import java.io.*;


public class ContentSeparator {
    FileReader fileReader = new FileReader();
    private static final File RESULTS_FILE = new File("src/main/resources/results.txt");
    BufferedWriter writer;

    public ContentSeparator() throws IOException {
        writer = new BufferedWriter(new FileWriter(RESULTS_FILE));
    }

    public void createDirectoryStructureFile(File folder, int indent) throws IOException {
        writer.write(makeIndent(indent));
        writer.write("+--");
        writer.write(folder.getName());
        writer.write("/");
        writer.write("\n");
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                createDirectoryStructureFile(file, indent + 1);
            }
            else {
                createFileStructure(file, indent + 1);
            }
        }
    }

    private void createFileStructure(File file, int indent) throws IOException {
        writer.write(makeIndent(indent));
        writer.write("---");
        writer.write(file.getName());
        writer.write("\n");
    }

    private String makeIndent(int indent) {
        String indentAsString = "";
        for (int i = 0; i < indent; i++) {
            indentAsString += "| ";
        }
        return indentAsString;
    }

    public void showTreeOfAFolder(String folderPath) throws IOException {
        File file = new File(folderPath);
        int indent = 0;
            if (file.isDirectory()) {
                createDirectoryStructureFile(file, indent);
                writer.close();
            }
            else {
                fileReader.getContentFromFile(file);
            }
    }
}
