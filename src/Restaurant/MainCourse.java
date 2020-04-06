package Restaurant;

public class MainCourse extends Dish {

    public MainCourse(String dishName, double dishPrice, String dishType, double taxRate) {
        super(dishName, dishPrice, dishType, 0.15);
    }
}
