package cpt;

/**
 * Data Interaction and Visualization CPT 
 * @author: P. Yang
 * 
 */

public class Deaths {

    // Instance variables 
    private String country;
    private int year;
    private int deaths; 

    /**
     * Constructor for deaths 
     * @param countryName Name of the country
     * @param yearOccured Recorded data for that year
     * @param numDeaths Number of deaths 
     * @author: P. Yang
     * 
     */
    public Deaths(String countryName, int yearOccured, int numDeaths){
        country = countryName;
        year = yearOccured;
        deaths = numDeaths; 
    }

    /**
     * Getter method for name of country
     * @return Name of country
     * @author: P. Yang
     * 
     */
    public String getCountry(){
        return country; 
    }
}
