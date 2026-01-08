package model;

/**
 *
 * @author IdeaPad
 */
public class EastAsiaCountries {
    protected String countryCode;
    protected String countryName;
    protected double totalArea;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryCode, String countryName, double totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    @Override
    public String toString() {
        return "EastAsiaCountries{" + "countryCode=" + countryCode + ", countryName=" + countryName + ", totalArea=" + totalArea + '}';
    }
    
    public void  display() {

    }
}
