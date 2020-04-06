package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Waiters {
    private List<Waiter> waiters = new ArrayList<>();

    public Waiters(List<User> users) {
        for (User user : users) {
            if (user.getRole().equals("Waiter"))
                waiters.add(new Waiter(user.getName(), user.getRole(), user.getUsername(), user.getPassword()));
        }
    }

    public List<Waiter> getWaiters() {
        return waiters;
    }

}
