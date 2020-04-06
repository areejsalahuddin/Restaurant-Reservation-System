package Restaurant;

public abstract class Employee extends User {
    public Employee(String name, String role, String username, String password) {
        super(name, role, username, password);
    }


    public abstract String viewEmployeeDashboard(Restaurant restaurant);
}

