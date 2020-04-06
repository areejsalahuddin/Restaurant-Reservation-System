package Restaurant;

public class Desert extends Dish {
    public Desert( String dishName, double dishPrice, String dishType, double taxRate) {
        super( dishName, dishPrice, dishType, 0.2);
    }
}
