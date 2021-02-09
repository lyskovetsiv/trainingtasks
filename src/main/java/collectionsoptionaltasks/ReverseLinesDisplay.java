package collectionsoptionaltasks;

import java.io.*;
import java.util.ArrayList;

public class ReverseLinesDisplay {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/poem");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        ArrayList<String> contentFromFile = new ArrayList<>();

        while (line != null) {
            contentFromFile.add(line);
            line = bufferedReader.readLine();
        }
        for (int i = contentFromFile.size() - 1; i >= 0; i--) {
            System.out.println(contentFromFile.get(i));
        }
    }
}
