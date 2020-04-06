package Restaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class SReservation {
    @XmlElement(name = "customerorder")
    private CustomerOrder customerOrder;
    public SReservation(){

    }
    public SReservation(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }


    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder= customerOrder;
    }
}
