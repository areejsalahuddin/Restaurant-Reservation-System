package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Cookers {
    private List<Cooker> cookers = new ArrayList<>();

    public Cookers(List<User> users) {
        for (User user : users) {
            if (user.getRole().equals("Cooker"))
                cookers.add(new Cooker(user.getName(), user.getRole(), user.getUsername(), user.getPassword()));
        }
    }

    public List<Cooker> getCookers() {
        return cookers;
    }

}
