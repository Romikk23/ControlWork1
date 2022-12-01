package souvenirs;

import java.util.Calendar;

public interface SouvenirInterface {
    String getName();
    Manufacturer getManufacturer();
    Calendar getDate();
    float getPrice();
    void setName(String name);
    void setManufacturer(ManufacturerInterface manufacturer);
    void setDate(Calendar date);
    void setPrice(float price);
    void print();
}
