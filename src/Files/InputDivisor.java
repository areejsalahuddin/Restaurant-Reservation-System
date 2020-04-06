package Files;

import Restaurant.*;


public class InputDivisor {

    public static void setInputDivisor(Restaurant restaurant) {
        restaurant.setCustomers(new Customers(restaurant.getUsers().getUsers()));
        restaurant.setManagers(new Managers(restaurant.getUsers().getUsers()));
        restaurant.setWaiters(new Waiters(restaurant.getUsers().getUsers()));
        restaurant.setCookers(new Cookers(restaurant.getUsers().getUsers()));
        restaurant.setMainCourses(new MainCourses(restaurant.getDishes().getDishes()));
        restaurant.setAppetizers(new Appetizers(restaurant.getDishes().getDishes()));
        restaurant.setDeserts(new Deserts(restaurant.getDishes().getDishes()));
    }
}
