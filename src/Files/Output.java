package Files;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import Restaurant.SReservations;

public class Output {
    public static SReservations Output() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(SReservations.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SReservations sReservations = (SReservations) unmarshaller.unmarshal(new File("SavedData.xml"));
        return sReservations;
    }

}