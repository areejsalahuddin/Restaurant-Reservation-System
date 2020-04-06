package Restaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {
    Tables tables;
    int tableNUMBER;
    @XmlElement(name = "number")
    private int tableNumber;
    @XmlElement(name = "number_of_seats")
    private int numberOfSeats;
    @XmlElement(name = "smoking")
    private boolean tableType;



    public int getTableNumber() {
        return tableNumber;
    }


    public int getNumberOfSeats() {
        return numberOfSeats;
    }


    public boolean getTableType() {
        return tableType;
    }


    public int ReserveTable(Tables tables, int numberOfSeats, boolean tableType) {
        tableNUMBER = 0;
        for (Table table : tables.getTables()) {
            if (numberOfSeats == table.getNumberOfSeats() && tableType == table.getTableType()) {
                tableNUMBER = table.getTableNumber();
                break;
            }
        }
        return tableNUMBER;
    }

}
