import java.util.Scanner;

public class OperationWithArguments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentNumber;
        int sum = 0;
        int mul = 1;

        System.out.print("Enter arguments: ");
        String[] argumentsArray = scanner.nextLine().trim().split(" ");

        for (String s : argumentsArray) {
            currentNumber = Integer.parseInt(s);
            sum += currentNumber;
            mul *= currentNumber;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Mul: " + mul);
    }
}
