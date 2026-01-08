package model;

/**
 *
 * @author IdeaPad
 */
public class Country extends EastAsiaCountries {
    
    private String countryTerrain;

    public Country(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public Country(String countryCode, String countryName, double totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    
    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.0f%-25s\n", this.countryCode,
                this.countryName, this.totalArea, this.countryTerrain);
    }
    
}
