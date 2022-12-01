package souvenirs;

public class Manufacturer implements ManufacturerInterface{
    private String name;
    private String country;

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void print(){
        System.out.println("Name: "+name);
        System.out.println("Country: " + country);
        System.out.println("\n");
    }
}
