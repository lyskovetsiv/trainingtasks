package fundamentals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OptionalTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter arguments: ");
        String[] argumentsArray = scanner.nextLine().trim().split(" ");
        getShortestAndLongestArgumentsWithItsLengths(argumentsArray);
        sortArgumentsByLength(argumentsArray);
        getLessThanAverageLengthArguments(argumentsArray);
    }

    public static void getShortestAndLongestArgumentsWithItsLengths(String[] argumentsArray) {
        int minArgumentLength = argumentsArray[0].length();
        int maxArgumentLength = 0;
        String minArgumentValue = argumentsArray[0];
        String maxArgumentValue = null;

        for (String s : argumentsArray) {
            if (s.length() < minArgumentLength) {
                minArgumentLength = s.length();
                minArgumentValue = s;
            }
            if (s.length() > maxArgumentLength) {
                maxArgumentLength = s.length();
                maxArgumentValue = s;
            }
        }
        System.out.println("First shortest argument is " + minArgumentValue + ". Its length is " + minArgumentLength);
        System.out.println("First longest argument: " + maxArgumentValue + ". Its length is " + maxArgumentLength);
    }

    public static void sortArgumentsByLength (String[] argumentsArray) {
        String[] copiedArgumentsArray = argumentsArray.clone();
        Arrays.sort(copiedArgumentsArray, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(copiedArgumentsArray));
    }

    public static void getLessThanAverageLengthArguments (String[] argumentsArray) {
        int sumLengthOfAllArguments = 0;
        int numberOfArguments = 0;
        int averageLength;

        for (String s : argumentsArray) {
            sumLengthOfAllArguments += s.length();
            numberOfArguments++;
        }
        averageLength = sumLengthOfAllArguments / numberOfArguments;
        System.out.print("All arguments with less than average length: ");

        for (String s : argumentsArray) {
            if (s.length() <= averageLength) {
                System.out.print(s + " ");
            }
        }
    }
}
