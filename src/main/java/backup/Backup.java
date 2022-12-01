package backup;

import souvenirs.Manufacturer;
import souvenirs.Souvenir;
import souvenirs.SouvenirsUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Backup {
    public static void writeInFile(){
        writeInFileSouvenir("souvenir.txt");
        writeInFileManufacturer("manufacturer.txt");
    }
    public static void readFromFile(){
        readFromFileSouvenir("souvenir.txt");
        readFromFileManufacturer("manufacturer.txt");
    }

    private static void writeInFileSouvenir(String dir){
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/" + dir);

            ArrayList<Souvenir> souvenirs = SouvenirsUtils.getSouvenirList();
            for(Souvenir souvenir : souvenirs){
                myWriter.write(" ");
                myWriter.write("\n"+souvenir.getName());
                myWriter.write("\n"+souvenir.getManufacturer().getName());
                myWriter.write("\n"+souvenir.getManufacturer().getCountry());
                myWriter.write("\n"+formater.format(souvenir.getDate().getTime()));
                myWriter.write("\n"+souvenir.getPrice()+"\n");
            }
            myWriter.write(";");
            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private static void readFromFileSouvenir(String dir){
        try {
            File myObj = new File("src/main/resources/" + dir);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String separator = myReader.nextLine();
                if(separator.equals(" ")){
                    String nameSouvenir = myReader.nextLine();
                    String nameManufacturer = myReader.nextLine();
                    String country = myReader.nextLine();
                    String dateStr = myReader.nextLine();
                    float price = Float.parseFloat(myReader.nextLine());
                    Calendar date = convertDate(dateStr);
                    SouvenirsUtils.addSouvenirToList(new Souvenir(nameSouvenir, new Manufacturer(nameManufacturer, country), date, price));
                } else if(separator.equals(";")){
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void writeInFileManufacturer(String dir){
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/"  + dir );

            ArrayList<Manufacturer> manufacturers = SouvenirsUtils.getManufacturerList();
            for(Manufacturer manufacturer : manufacturers){
                myWriter.write(" ");
                myWriter.write("\n" + manufacturer.getName());
                myWriter.write("\n" + manufacturer.getCountry() + "\n");
            }
            myWriter.write(";");
            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private static void readFromFileManufacturer(String dir){
        try {
            File myObj = new File("src/main/resources/"  + dir);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String separator = myReader.nextLine();
                if(separator.equals(" ")){
                    String name = myReader.nextLine();
                    String country = myReader.nextLine();
                    SouvenirsUtils.addManufacturerToList(new Manufacturer(name, country));
                } else if(separator.equals(";")){
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static Calendar convertDate(String dateStr){
        int day,mounth,year;
        day = Integer.parseInt(dateStr.substring(0, dateStr.indexOf("-")));
        mounth = Integer.parseInt(dateStr.substring(dateStr.indexOf("-")+1, dateStr.lastIndexOf("-"))) + 1;
        year = Integer.parseInt(dateStr.substring(dateStr.lastIndexOf("-")+1, dateStr.length()));
        Calendar date = new GregorianCalendar(year, mounth, day);
        return date;

    }
}
