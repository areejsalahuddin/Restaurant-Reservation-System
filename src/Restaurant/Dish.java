package Restaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dish")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dish {
    
    @XmlElement(name = "name")
    private String dishName;
    @XmlElement(name = "price")
    private double dishPrice;
    @XmlElement(name = "type")
    private String dishType;

    private double dishTaxRate;

    public Dish(String dishName, double dishPrice, String dishType, double taxRate) {
        
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishType = dishType;
        this.dishTaxRate = taxRate;
    }

    public Dish() {  //empty constructor
    }


    public String getDishName() {
        return dishName;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public String getDishType() {
        return dishType;
    }



}
