package Restaurant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Customer extends User {

    public Customer(String name, String role, String username, String password) {
        super(name, role, username, password);
    }
    public void saveReservation(String customerName, int tableNumber, boolean tableType, int numberOfSeats, List<Dish> orderedDishes, double totalPaidAmount) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(SReservations.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        File file =  new File("savedData.xml");
        SReservations sReservations = new SReservations();
        SReservation sReservation =  new SReservation();
        CustomerOrder customerOrder = new CustomerOrder();
        try{
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            SReservations reservations1 =(SReservations) unmarshaller.unmarshal(file);
            for(SReservation reservation: reservations1.getReservationList()){
                if(reservation.getCustomerOrder().getTableNumber() == tableNumber)
                    continue;
                reservations1.addReservation(reservation);
            }
        }catch (Exception e){}
        customerOrder.setCustomerName(customerName);
        customerOrder.setTableNumber(tableNumber);
        customerOrder.setTotalPriceAfterTax(totalPaidAmount);
        customerOrder.setOrderedDishes(orderedDishes);
        customerOrder.setNumberOfSeats(numberOfSeats);
        customerOrder.setTableType(tableType);
        sReservation.setCustomerOrder(customerOrder);
        sReservations.addReservation(sReservation);
        marshaller.marshal(sReservations, new File("SavedData.xml"));
    }
}
