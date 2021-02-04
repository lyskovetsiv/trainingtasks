package classestask;

public class Main {
    public static void main(String[] args) {
        CustomerSort customerSort = new CustomerSort();

        customerSort.addCustomerToTheList(new Customer("Smith", "John", 17443));
        customerSort.addCustomerToTheList(new Customer("Brown", "Bob", "9758 NW. 8th Road", 98355));
        customerSort.addCustomerToTheList(new Customer(78999,"O'Kelly", "James", "321 Temple Dr Charleston", 78665));
        customerSort.addCustomerToTheList(new Customer(75623, "Miller","Evelyn", "595 Glen Creek St. Wheeling", 83563));
        customerSort.addCustomerToTheList(new Customer("Martin", "William", "443 Marvon Court Morgantown", 35935, 23433));
        customerSort.addCustomerToTheList(new Customer(13322,"Mironov", "Andrei", "Vladimirovich",
                "24, Berezhkovskaya nab.", 87735, 21313));
        customerSort.addCustomerToTheList(new Customer("Roberts", "Samantha", 46799));
        customerSort.addCustomerToTheList(new Customer("Davis", "Roy", 66666));

        System.out.println("Sorted by name: ");
        for (Customer customer : customerSort.createListSortedByName()) {
            System.out.println(customer);
        }
        System.out.println();
        System.out.println("Sorted by card number range: ");
        for (Customer customer : customerSort.createListWithCardNumberRange(27565, 67988)) {
            System.out.println(customer);
        }
    }
}
