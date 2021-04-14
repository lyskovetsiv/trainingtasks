package optionaliotasks.changepublictoprivate;

import java.io.*;

public class ClassChanger {
    public static final String PUBLIC_MODIFICATOR = "public ";
    public static final String PRIVATE_MODIFICATOR = "private ";

    public void createFileWithDifferentModificators() {
        File file = new File("src/main/java/optionaliotasks/changepublictoprivate/ClassChanger.java");
        String directoryPath = "src/main/resources/iotasksfiles";

        File directory = new File(directoryPath);
        if (!directory.exists()){
            directory.mkdir();
        }
        File modifiedFile = new File(directoryPath + "/ClassChanger_Modified");

        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(modifiedFile))) {
                String line;
                while ((line=bufferedReader.readLine())!=null) {
                    bufferedWriter.write(line.replace(PUBLIC_MODIFICATOR, PRIVATE_MODIFICATOR));
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void reverseEveryLineInFile() {
        File file = new File("src/main/java/optionaliotasks/changepublictoprivate/ClassChanger.java");
        File modifiedFile = new File("src/main/resources/iotasksfiles/ClassChanger_Reversed.txt");
        String reversedLine = "";


        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(modifiedFile))) {
                String line;
                while ((line=bufferedReader.readLine())!=null) {
                    int lineLength = line.length();

                    for (int i = lineLength - 1 ; i >= 0 ; i--) {
                        reversedLine = reversedLine + line.charAt(i);
                    }
                    bufferedWriter.write(reversedLine);
                    reversedLine = "";
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
