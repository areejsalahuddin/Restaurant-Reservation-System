package Restaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement (name = "reservations")
@XmlAccessorType(XmlAccessType.FIELD)
public class SReservations {
    @XmlElement(name = "reservation")
    private SReservation sReservation = null;
    private List<SReservation> reservationList = new ArrayList<SReservation>();

    public List<SReservation> getReservationList (){
        return reservationList;
    }
    public void setsReservation(SReservation sReservation) {
        reservationList.add(sReservation);
    }

    public void addReservation(SReservation sReservation) {
        reservationList.add(sReservation);
    }
}