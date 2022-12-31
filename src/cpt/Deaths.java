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
    private double deaths; 

    /**
     * Constructor for deaths 
     * @param countryName Name of the country
     * @param yearOccured Recorded data for that year
     * @param numDeaths Number of deaths 
     * @author: P. Yang
     * 
     */
    public Deaths(String countryName, int yearOccured, double numDeaths){
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

    /**
     * Getter method for year for that set of data
     * @return Recorded year for that set of data 
     * @author: P. Yang
     * 
     */
    public int getYear(){
        return year;
    }

    /**
     * Getter method for number of deaths 
     * @return Number of deaths 
     * @author: P. Yang
     * 
     */
    public double getDeaths(){
        return deaths;
    }

    /**
     * Method to convert info to String
     * @return Info as String
     * @author: P. Yang
     * 
     */
    public String toString(){
        return (this.getCountry() + " had " + this.getDeaths() + "(per 100,000) deaths in " + this.getYear());
    }
}
