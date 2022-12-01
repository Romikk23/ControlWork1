package souvenirs;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Souvenir implements SouvenirInterface{
    private String name;
    private ManufacturerInterface manufacturer;
    private Calendar date;
    private float price;

    public Souvenir(String name, ManufacturerInterface manufacturer, Calendar date, float price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.date = date;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Manufacturer getManufacturer() {
        return (Manufacturer) manufacturer;
    }

    public Calendar getDate() {
        return date;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(ManufacturerInterface manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void print(){
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Name: "+name);
        System.out.println("Manufacturer name: "+manufacturer.getName());
        System.out.println("Manufacturer country: "+manufacturer.getCountry());
        System.out.println("Date: "+formater.format(date.getTime()));
        System.out.println("Price: "+price);
        System.out.println("\n");
    }
}
