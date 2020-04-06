package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Deserts {

    private List<Desert> deserts = new ArrayList<>();

    public Deserts(List<Dish> dishes) {
        for (Dish dish : dishes) {
            if (dish.getDishType().equals("desert"))
                deserts.add(new Desert(dish.getDishName(), dish.getDishPrice(), dish.getDishType(), 0.2));
        }
    }

    public List<Desert> getDeserts() {
        return deserts;
    }

}
