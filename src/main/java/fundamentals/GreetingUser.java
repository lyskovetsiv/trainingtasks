package fundamentals;

import java.util.Scanner;

public class GreetingUser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        System.out.println("Hello " + scanner.nextLine() + "!");
    }
}
