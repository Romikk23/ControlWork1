import backup.Backup;
import menu.Menu;
import souvenirs.Manufacturer;
import souvenirs.Souvenir;
import souvenirs.SouvenirsUtils;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Souvenir souvenir1 = new Souvenir("Cup", new Manufacturer("Roshen", "Ukraine"), new GregorianCalendar(2020, 7 , 4), 120.50f);
//        Souvenir souvenir2 = new Souvenir("Candy", new Manufacturer("Roshen", "Ukraine"), new GregorianCalendar(2021, 5 , 25), 25.75f);
//        Souvenir souvenir3 = new Souvenir("Painting", new Manufacturer("Roshen", "Ukraine"), new GregorianCalendar(2019, 6 , 22), 50.00f);
//        Souvenir souvenir4 = new Souvenir("Cup", new Manufacturer("Milka", "France"), new GregorianCalendar(2020, 7 , 21), 55.00f);
//        Souvenir souvenir5 = new Souvenir("Case", new Manufacturer("Milka", "France"), new GregorianCalendar(2021, 9 , 15), 100.00f);
//        Souvenir souvenir6 = new Souvenir("Packet", new Manufacturer("Valve", "Poland"), new GregorianCalendar(2022, 1 , 19), 160.20f);
//        Souvenir souvenir7 = new Souvenir("Golden apple", new Manufacturer("Google", "USA"), new GregorianCalendar(2018, 7 , 5), 200.99f);
//        Souvenir souvenir8 = new Souvenir("Trinket", new Manufacturer("Microsoft", "USA"), new GregorianCalendar(2022, 10 , 4), 50.00f);
//        Souvenir souvenir9 = new Souvenir("Cup", new Manufacturer("Privat", "Ukraine"), new GregorianCalendar(2016, 4 , 22), 89.00f);
//        Souvenir souvenir10 = new Souvenir("Trinket", new Manufacturer("Prada", "Italy"), new GregorianCalendar(2016, 1 , 30), 180.00f);
//        Manufacturer manufacturer1 = new Manufacturer("Roshen", "Ukraine");
//        Manufacturer manufacturer2 = new Manufacturer("Milka", "France");
//        Manufacturer manufacturer3 = new Manufacturer("Valve", "Poland");
//        Manufacturer manufacturer4 = new Manufacturer("Google", "USA");
//        Manufacturer manufacturer5 = new Manufacturer("Microsoft", "USA");
//        Manufacturer manufacturer6 = new Manufacturer("Privat", "Ukraine");
//        Manufacturer manufacturer7 = new Manufacturer("Prada", "Italy");
//        SouvenirsUtils.addSouvenirToList(souvenir1);
//        SouvenirsUtils.addSouvenirToList(souvenir2);
//        SouvenirsUtils.addSouvenirToList(souvenir3);
//        SouvenirsUtils.addSouvenirToList(souvenir4);
//        SouvenirsUtils.addSouvenirToList(souvenir5);
//        SouvenirsUtils.addSouvenirToList(souvenir6);
//        SouvenirsUtils.addSouvenirToList(souvenir7);
//        SouvenirsUtils.addSouvenirToList(souvenir8);
//        SouvenirsUtils.addSouvenirToList(souvenir9);
//        SouvenirsUtils.addSouvenirToList(souvenir10);
//        SouvenirsUtils.addManufacturerToList(manufacturer1);
//        SouvenirsUtils.addManufacturerToList(manufacturer2);
//        SouvenirsUtils.addManufacturerToList(manufacturer3);
//        SouvenirsUtils.addManufacturerToList(manufacturer4);
//        SouvenirsUtils.addManufacturerToList(manufacturer5);
//        SouvenirsUtils.addManufacturerToList(manufacturer6);
//        SouvenirsUtils.addManufacturerToList(manufacturer7);
        Backup.readFromFile();
        while(true) {
            Menu.printMenu();
            int choise = getChoise(8);
            String str;
            switch (choise) {
                case 1:
                    Menu.menuAddEditPrint();
                    break;
                case 2:
                    System.out.print("Print manufacturer: ");
                    str = getString();
                    SouvenirsUtils.printSouvenirsFromOneManufacturer(str);
                    break;
                case 3:
                    System.out.print("Print country: ");
                    str = getString();
                    SouvenirsUtils.printSouvenirsFromOneCountry(str);
                    break;
                case 4:
                    System.out.print("Print price: ");
                    float price = getFloat();
                    SouvenirsUtils.printManufacturerWithLowerPrice(price);
                    break;
                case 5:
                    SouvenirsUtils.printAllManufacturerWithAllSouvenir();
                    break;
                case 6:
                    System.out.print("Print name souvenir: ");
                    str = getString();
                    System.out.print("Print year:");
                    int year = getInt();
                    SouvenirsUtils.printManufacturerWithSpecifiedYear(str, year);
                    break;
                case 7:
                    SouvenirsUtils.printSouvenirsByYear();
                    break;
                case 8:
                    System.out.print("Print manufacturer name: ");
                    str = getString();
                    SouvenirsUtils.deleteManufacturerWithSouvenir(str);
                    break;
                case 0:
                    Backup.writeInFile();
                    return;
            }
        }

    }

    public static int getChoise(int max){
        int choise = -1;
        while(choise < 0 || choise > max){
            Scanner scanner = new Scanner(System.in);
            choise = scanner.nextInt();
        }
        return choise;
    }

    public static String getString(){
        String str;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        return str;
    }

    public static float getFloat(){
        float f;
        Scanner scanner = new Scanner(System.in);
        f = scanner.nextFloat();
        return f;
    }

    public static Integer getInt(){
        int i;
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        return i;
    }

}
