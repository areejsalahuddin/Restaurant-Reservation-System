package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Appetizers {

    private List<Appetizer> appetizers = new ArrayList<>();

    public Appetizers(List<Dish> dishes) {
        for (Dish dish : dishes) {
            if (dish.getDishType().equals("appetizer"))
                appetizers.add(new Appetizer(dish.getDishName(),dish.getDishPrice(),dish.getDishType(),0.1));
        }
    }

    public List<Appetizer> getAppetizers() {
        return appetizers;
    }

}
