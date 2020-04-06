package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Managers {
    private List<Manager> managers = new ArrayList<>();

    public Managers(List<User> users) {
        for (User user : users) {
            if (user.getRole().equals("Manager"))
                managers.add(new Manager(user.getName(), user.getRole(), user.getUsername(), user.getPassword()));
        }
    }

    public List<Manager> getManagers() {
        return managers;
    }

}
