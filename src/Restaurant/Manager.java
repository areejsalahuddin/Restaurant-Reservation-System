package Restaurant;

public class Manager extends Employee {
    private double totalRevenue = 0;
    public Manager(String name, String role, String username, String password) {
        super(name, role, username, password);
    }

    public String viewEmployeeDashboard(Restaurant restaurant) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 1;
        for(SReservation reservation : restaurant.getReservations().getReservationList()){
            stringBuilder.append((n) + ". Customer Name:   " + reservation.getCustomerOrder().getCustomerName() +"  (Table no." +reservation.getCustomerOrder().getTableNumber() + ")\nDishes Ordered:\n");
            int i = 1;
            for(Dish dish :reservation.getCustomerOrder().getChosenDishes())
            {
                stringBuilder.append((i) +". "+ dish.getDishName() + "\n");
                i++;
            }
            stringBuilder.append("Amount Paid by Customer = " + reservation.getCustomerOrder().getTotalPriceAfterTaxes() + "\n");
            totalRevenue += reservation.getCustomerOrder().getTotalPriceAfterTaxes();
            n++;
        }
        stringBuilder.append("\nToday's Total Revenue = " + totalRevenue);
        return stringBuilder.toString();
    }
    }


