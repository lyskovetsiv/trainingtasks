package fundamentals;

import java.util.Scanner;

public class MonthByNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] months = new String[] {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"};
        int monthNumber;

        System.out.print("Enter a month number: ");
        monthNumber = scanner.nextInt();
        System.out.println(months[monthNumber - 1]);
    }
}
