package Restaurant;


import Restaurant.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "customerorder")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerOrder {
    @XmlElement(name = "customer_name")
    private String customerName;
    @XmlElement(name = "table_number")
    private int tableNumber;
    @XmlElement(name = "smoking")
    private boolean tableType;
    @XmlElement(name = "number_of_seats")
    private int numberOfSeats;
    @XmlElement(name = "total_price")
    private double totalPrice;
    @XmlElement(name = "ordered_dishes")
    private List<Dish> chosenDishes = new ArrayList<>();
    private int totalPriceBeforeTax;
    private Table table;
    public Table getTable(){
        return table;
    }
    public void setTable(Table table){
        this.table = table;
    }
    public void addDish(Dish dish) {
        chosenDishes.add(dish);
    }

    public void setTotalPriceAfterTax(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public double getTotalPriceAfterTaxes() {
        totalPrice = 0;
        for (Dish dish : chosenDishes) {
            if (dish instanceof MainCourse) {
                totalPrice += 1.15 * dish.getDishPrice();
            } else if (dish instanceof Appetizer) {
                totalPrice += 1.1 * dish.getDishPrice();
            } else if (dish instanceof Desert) {
                totalPrice += 1.2 * dish.getDishPrice();
            }
        }
        return totalPrice;
    }
    public int getTotalPriceBeforeTaxes()
    {      totalPriceBeforeTax = 0;
        for (Dish dish : chosenDishes) {
            if (dish instanceof MainCourse) {
                totalPriceBeforeTax += dish.getDishPrice();
            } else if (dish instanceof Appetizer) {
                totalPriceBeforeTax += dish.getDishPrice();
            } else if (dish instanceof Desert) {
                totalPriceBeforeTax += dish.getDishPrice();
            }
        }
        return totalPriceBeforeTax;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }


    public void setTableType(boolean tableType) {
        this.tableType = tableType;
    }


    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<Dish> getChosenDishes() {
        return chosenDishes;
    }

    public void setOrderedDishes(List<Dish> chosenDishes) {
        this.chosenDishes = chosenDishes;
    }
}
