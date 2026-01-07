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

    public Country(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    
    @Override
    public String display() {
        return "countryCode=" + countryCode + ", countryName=" + countryName +
                ", totalArea=" + totalArea + ", countryTerrain =" + countryTerrain;
    }
    
}
