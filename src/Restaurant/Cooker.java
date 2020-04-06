package Restaurant;
import Restaurant.SReservation;

public class Cooker extends Employee {

    public Cooker(String name, String role, String username, String password) {
        super(name, role, username, password);
    }

    public String viewEmployeeDashboard(Restaurant restaurant) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 1;
        for(SReservation reservation : restaurant.getReservations().getReservationList()){
            System.out.println(reservation);
            System.out.println(reservation.getCustomerOrder());
            System.out.println(reservation.getCustomerOrder().getTable());
            System.out.println(reservation.getCustomerOrder().getTableNumber());
            stringBuilder.append((n) + ". Table no." +reservation.getCustomerOrder().getTableNumber() + "\nDishes Ordered:\n");
            for(Dish dish : reservation.getCustomerOrder().getChosenDishes())
            {
                stringBuilder.append(dish.getDishName() + "\n");
            }
            n++;
        }

        return stringBuilder.toString();
}

}
