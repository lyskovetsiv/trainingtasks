package optionaliotasks.sortingrandomnumbers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RandomNumbersFileCreation {

    public File createFileWithRandomNumbers() {
        int numbersCounter = 0;
        int currentNumber;
        String directoryPath = "src/main/resources/iotasksfiles";
        String fileName = "numbers.txt";

        File directory = new File(directoryPath);
        if (!directory.exists()){
            directory.mkdir();
        }
        File file = new File(directoryPath + "/" + fileName);

        try (FileWriter fileWriter = new FileWriter(file)) {
            while (numbersCounter <= 20) {
                currentNumber = (int)(Math.random() * 1001);
                fileWriter.write((currentNumber) + " ");
                fileWriter.flush();
                numbersCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public void getSortedNumbersFile(File file) {
        Scanner scanner;
        String[] allNumbers;
        int[] allNumbersAsInteger;

        try (FileWriter fileWriter = new FileWriter("src/main/resources/iotasksfiles/sortedNumbers.txt")) {
            scanner = new Scanner(file);
            allNumbers = scanner.nextLine().split(" ");
            allNumbersAsInteger = new int[allNumbers.length];
            for(int i = 0; i < allNumbers.length; i++) {
                allNumbersAsInteger[i] = Integer.parseInt(allNumbers[i]);
            }
            Arrays.sort(allNumbersAsInteger);
            for (int number : allNumbersAsInteger) {
                fileWriter.write(number + " ");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
