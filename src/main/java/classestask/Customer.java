package classestask;

public class Customer {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int creditCardNumber;
    private int bankAccountNumber;

    public Customer(int id, String surname, String name, String patronymic, String address, int creditCardNumber, int bankAccountNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer(int id, String surname, String name, String address, int creditCardNumber, int bankAccountNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer(int id, String surname, String name, String address, int creditCardNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
    }

    public Customer(String surname, String name, String address, int creditCardNumber, int bankAccountNumber) {
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer(String surname, String name, String address, int creditCardNumber) {
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
    }

    public Customer(String surname, String name, int creditCardNumber) {
        this.surname = surname;
        this.name = name;
        this.creditCardNumber = creditCardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", bankAccountNumber=" + bankAccountNumber +
                '}';
    }
}
