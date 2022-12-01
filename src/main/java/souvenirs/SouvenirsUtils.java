package souvenirs;

import backup.Backup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class SouvenirsUtils {
    public static ArrayList<Souvenir> souvenirList = new ArrayList<>();
    public static ArrayList<Manufacturer> manufacturerList = new ArrayList<>();

    public static void addSouvenirToList(Souvenir souvenir){
        souvenirList.add(souvenir);
        for (Manufacturer manufacturer : manufacturerList){
            if(manufacturer.getName().equals(souvenir.getManufacturer().getName())){
                return;
            }
        }
    }

    public static void addManufacturerToList(Manufacturer manufacturer){
        manufacturerList.add(manufacturer);
    }

    public static void deleteSouvenirFromList(Souvenir souvenir){
        if(!souvenirList.remove(souvenir)){
            System.out.println("There isn't this souvenir");
        }
    }

    public static ArrayList<Souvenir> getSouvenirList(){
        return souvenirList;
    }

    public static ArrayList<Manufacturer> getManufacturerList(){
        return manufacturerList;
    }

    public static void printSouvenirsFromOneManufacturer(String nameManufacturer){
        boolean manufacturerExist = false;
        for (Manufacturer manufacturer : manufacturerList){
            if(manufacturer.getName().equals(nameManufacturer)){
                manufacturerExist = true;
                break;
            }
        }

        if(manufacturerExist){
            for (Souvenir souvenir : souvenirList){
                if(souvenir.getManufacturer().getName().equals(nameManufacturer)){
                    souvenir.print();
                }
            }
        } else {
            System.out.println("There isn't this manufacturer");
        }
    }

    public static void printSouvenirsFromOneCountry(String country){
        boolean countryExist = false;
        for (Souvenir souvenir : souvenirList){
            if(souvenir.getManufacturer().getCountry().equals(country)){
                souvenir.print();
                countryExist = true;
            }
        }
        if(!countryExist){
            System.out.println("There isn't this country");
        }
    }

    public static void printManufacturerWithLowerPrice(float price){
        boolean manufacturerExist = false;
        for (Manufacturer manufacturer : manufacturerList){
            for (Souvenir souvenir : souvenirList){
                if(souvenir.getPrice() <= price){
                    manufacturer.print();
                    manufacturerExist = true;
                    break;
                }
            }
        }
        if(!manufacturerExist){
            System.out.println("There isn't this manufacturer with lower price");
        }
    }

    public static void printAllManufacturerWithAllSouvenir(){
        if(souvenirList.isEmpty()){
            System.out.println("There isn't souvenirs");
            return;
        }

        for (Manufacturer manufacturer : manufacturerList){
            System.out.println("    Manufacture:");
            manufacturer.print();
            for (Souvenir souvenir : souvenirList){
                if(souvenir.getManufacturer().getName().equals(manufacturer.getName())){
                    System.out.println("    Souvenir:");
                    souvenir.print();
                }
            }
        }
    }

    public static void printManufacturerWithSpecifiedYear(String nameSouvenir, int year){
        boolean manufacturerExist = false;
        System.out.println("    Souvenir: " + nameSouvenir);
        for (Souvenir souvenir : souvenirList){
            if(souvenir.getName().equals(nameSouvenir) && souvenir.getDate().get(Calendar.YEAR) == year){
                System.out.println("Manufacturer: ");
                souvenir.getManufacturer().print();
                manufacturerExist = true;
            }
        }
        if(!manufacturerExist){
            System.out.println("There isn't this manufacturer with specified year");
        }
    }

    public static void printSouvenirsByYear() {
        if(souvenirList.isEmpty()){
            System.out.println("There isn't souvenirs");
            return;
        }

        int minYear, maxYear;
        minYear = maxYear = souvenirList.get(0).getDate().get(Calendar.YEAR);
        for (Souvenir souvenir : souvenirList) {
            int currYear = souvenir.getDate().get(Calendar.YEAR);
            if (currYear > maxYear) {
                maxYear = currYear;
            }
            if (currYear < minYear) {
                minYear = currYear;
            }
        }
        for (int i = minYear; i < maxYear; i++) {
            System.out.println("    Year: " + i);
            for (Souvenir souvenir : souvenirList) {
                if (souvenir.getDate().get(Calendar.YEAR) == i) {
                    souvenir.print();
                }
            }
        }
    }

    public static void deleteManufacturerWithSouvenir(String nameManufacturer) {
        boolean manufacturerExist = false;
        for (Manufacturer manufacturer : manufacturerList){
            if(manufacturer.getName().equals(nameManufacturer)) {
                manufacturerExist = true;
            }
        }
        if(!manufacturerExist){
            System.out.println("There isn't manufacturer");
            return;
        }
        Iterator<Souvenir> itrSouvenir = souvenirList.iterator();
        Iterator<Manufacturer> itrManufacturer = manufacturerList.iterator();
        while (itrSouvenir.hasNext()) {
            Souvenir souvenir = itrSouvenir.next();
            if(souvenir.getManufacturer().getName().equals(nameManufacturer)){
                itrSouvenir.remove();
            }
        }

        while (itrManufacturer.hasNext()) {
            Manufacturer manufacturer = itrManufacturer.next();
            if(manufacturer.getName().equals(nameManufacturer)){
                itrManufacturer.remove();
            }
        }
        Backup.writeInFile();
    }
    public static boolean manufacturerExist(String name){
        for (Manufacturer manufacturer : manufacturerList) {
            if (manufacturer.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
