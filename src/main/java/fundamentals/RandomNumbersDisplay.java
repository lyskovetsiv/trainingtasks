package fundamentals;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbersDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberOfRandomArguments;

        System.out.print("Enter number of random arguments: ");
        numberOfRandomArguments = scanner.nextInt();
        System.out.print("\nArguments in line: ");

        for (int i = 0; i < numberOfRandomArguments; i++) {
            System.out.print(random.nextInt(100) + " ");
        }

        System.out.println("\nArguments in column: ");

        for (int i = 0; i < numberOfRandomArguments; i++) {
            System.out.println(random.nextInt(100) + " ");
        }
    }
}
