package controller;
import utilities.Validation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Country;

/**
 *
 * @author IdeaPad
 */
public class ManageEastAsiaCountries {
    private final Validation validation = new Validation();
    
    public void inputCountry(ArrayList<Country> lc) {
        System.out.println("Enter code of country: ");
        String idCountry = validation.inputString();
        if (validation.checkCodeCountry(lc, idCountry)) {
            System.out.println("Code of country is exist!.");
            return;
        }
        
        System.out.println("Enter name of country:");
        String countryName = validation.inputString();
        System.out.println("Enter total Area: ");
        double totalArea = validation.inputDouble();
        System.out.println("Enter terrain of country: ");
        String countryTerrain = validation.inputString();
        lc.add(new Country(idCountry, countryName, totalArea, countryTerrain));
        System.out.println("Added successfully this country!!");
        
    }
    
    public void displayLastCountry(ArrayList<Country> lc) {
        if (lc.isEmpty()) {
            System.out.println("Not any country just input!");
            return;
        }
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Country", "Total Area", "Terrain");
        
        for (Country country : lc) {
            country.display();
        }
        
    }
    
    public void displaySortedCountry(ArrayList<Country> lc) {
        if (lc.isEmpty()) {
          System.out.println("There are no countries to compare it to.");
          return;
        }
        
        Collections.sort(lc, Comparator.comparing(Country::getCountryName));
        
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Country", "Total Area", "Terrain");
        
        for (Country country : lc) {
            country.display();
        }
    }
    
    public Country searchCountryName(ArrayList<Country> lc, String countryName) {
       Country result = null;
       
       for (Country country : lc) {
           if (country.getCountryName().equalsIgnoreCase(countryName)) {
               result = country;
               break;
           }
       }
       
       return result;
    }
    
    
    public void displaySearchCountry(ArrayList<Country> lc) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = validation.inputString();
        
        Country foundCountry = searchCountryName(lc, countryName);
        
        if (foundCountry == null) {
            System.out.println("No find any country!");
            return;
        }
        
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Country", "Total Area", "Terrain");
        foundCountry.display();
        
    }
    
}
