package collectionsoptionaltasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SortLines {
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
        Collections.sort(contentFromFile);
        System.out.println(contentFromFile);
    }
}
