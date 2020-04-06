package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class MainCourses {

    private List<MainCourse> mainCourses = new ArrayList<>();

    public MainCourses(List<Dish> dishes) {
        for (Dish dish : dishes) {
            if (dish.getDishType().equals("main_course"))
                mainCourses.add(new MainCourse(dish.getDishName(), dish.getDishPrice(), dish.getDishType(), 0.15));
        }
    }

    public List<MainCourse> getMainCourses() {
        return mainCourses;
    }

}
