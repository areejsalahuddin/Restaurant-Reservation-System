package Restaurant;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Restaurant {
    private Customers customers;
    private Managers managers;
    private Waiters waiters;
    private Cookers cookers;
    private Appetizers appetizers;
    private MainCourses mainCourses;
    private Deserts deserts;
    private SReservations reservations = new SReservations();
    private CustomerOrder customerOrder = new CustomerOrder();

    @XmlElement(name = "users")
    private Users users = null;

    @XmlElement(name = "tables")
    private Tables tables = null;

    @XmlElement(name = "dishes")
    private Dishes dishes = null;


    public SReservations getReservations() {
        return reservations;
    }

    public void setReservations(SReservations reservations) {
        this.reservations = reservations;
    }
    public void setCustomerOrder(CustomerOrder customerOrder){
        this.customerOrder = customerOrder;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public void setManagers(Managers managers) {
        this.managers = managers;
    }

    public void setWaiters(Waiters waiters) {
        this.waiters = waiters;
    }

    public void setCookers(Cookers cookers) {
        this.cookers = cookers;
    }

    public MainCourses getMainCourses() {
        return mainCourses;
    }

    public void setMainCourses(MainCourses mainCourses) {
        this.mainCourses = mainCourses;
    }

    public Appetizers getAppetizers() {
        return appetizers;
    }

    public Deserts getDeserts() {
        return deserts;
    }

    public void setAppetizers(Appetizers appetizers) {
        this.appetizers = appetizers;
    }

    public void setDeserts(Deserts deserts) {
        this.deserts = deserts;
    }

    public Users getUsers() {
        return users;
    }


    public Tables getTables() {
        return tables;
    }


    public Dishes getDishes() {
        return dishes;
    }

    public Customers getCustomers() {
        return customers;
    }

    public Managers getManagers() {
        return managers;
    }

    public Waiters getWaiters() {
        return waiters;
    }

    public Cookers getCookers() {
        return cookers;
    }

}
