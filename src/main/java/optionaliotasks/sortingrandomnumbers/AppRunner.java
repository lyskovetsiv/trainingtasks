package optionaliotasks.sortingrandomnumbers;

public class AppRunner {
    public static void main(String[] args) {
        RandomNumbersFileCreation randomNumbersFileCreation = new RandomNumbersFileCreation();

        randomNumbersFileCreation.getSortedNumbersFile(randomNumbersFileCreation.createFileWithRandomNumbers());
    }
}
