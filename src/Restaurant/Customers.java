package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Customers {
    private List<Customer> customers = new ArrayList<>();

    public Customers(List<User> users) {
        for (User user : users) {
            if (user.getRole().equals("Client")) {
                customers.add(new Customer(user.getName(), user.getRole(), user.getUsername(), user.getPassword()));
            }
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

}
