package classestask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerSort {
    private ArrayList<Customer> customerList = new ArrayList<>();

    void addCustomerToTheList (Customer customer) {
        customerList.add(customer);
    }

    List<Customer> createListSortedByName() {
        List<Customer> list = new ArrayList<>(customerList);
        list.sort(Comparator.comparing(Customer::getName));
        return list;
    }

    List<Customer> createListWithCardNumberRange(int minCardNumberValue, int maxCardNumberValue) {
        List<Customer> list = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getCreditCardNumber() >= minCardNumberValue && customer.getCreditCardNumber() <= maxCardNumberValue) {
                list.add(customer);
            }
        }
        return list;
    }
}
