package Restaurant;


public class Waiter extends Employee{
    public Waiter(String name, String role, String username, String password) {
        super(name, role, username, password);
    }

    public String viewEmployeeDashboard(Restaurant restaurant) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 1;
        try {
            for(SReservation reservation : restaurant.getReservations().getReservationList()){
                stringBuilder.append((n) + ". Customer Name:   " + reservation.getCustomerOrder().getCustomerName() +"  (Table no." +reservation.getCustomerOrder().getTableNumber() + ")\n");
                n++;
            }
        }catch (NullPointerException e){
            stringBuilder.append("No Reservations for today");
        }
        return stringBuilder.toString();
    }
}
