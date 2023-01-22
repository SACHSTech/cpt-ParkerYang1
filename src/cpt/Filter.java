package cpt;
import java.util.*;
import java.io.*;
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;

/**
 * Data Interaction and Visualization CPT 
 * @author: P. Yang
 * 
 */

public class Filter{

    // New array list 
    ArrayList<Deaths> dataArray = new ArrayList<Deaths>();

    /**
     * A method that reads the CSV file and makes each piece of data a new object. Adds to an array list after 
     * @author: P. Yang
     * 
    */
    public void initializeList() throws IOException{
        String line; 
        String country;
        double deaths;
        int year;

        BufferedReader br = new BufferedReader(new FileReader("src/cpt/DataSet.csv"));
        line = br.readLine();

        for(int i = 0; i < 6411; i++){
            line = br.readLine();

            String[] splitLine = line.split(",");
            country = splitLine[0];
            year = Integer.parseInt(splitLine[2]);
            deaths = Double.parseDouble(splitLine[3]);

            Deaths deathCounter = new Deaths(country, year, deaths);
            dataArray.add(deathCounter);
        }
        br.close();
    }

    /**
     * A method that only extracts data specific to the varible int specificYear
     * @param specificYear Enter specific year you want data from 
     * @return Return an array list that only includes specificYear data 
     * @author: P. Yang
     * 
     */
    public ArrayList<Deaths> yearSpecificList(int specificYear){
        ArrayList<Deaths> sortedData = new ArrayList<Deaths>();

        for(int i = 0; i < dataArray.size(); i++){
            if(dataArray.get(i).getYear() == specificYear){
                sortedData.add(dataArray.get(i));
            }
        }
        return (sortedData);
    }

    /**
     * A method that extracts the name of the country and puts it into a new array list 
     * @return Return an array list that only includes the countries names 
     * @author: P. Yang
     * 
     */
    public ArrayList<String> countryList(){
        ArrayList<String> countryData = new ArrayList<String>();
        ArrayList<String> sortedCountryData = new ArrayList<String>();

        for(int i = 1; i < dataArray.size(); i++){
            if(dataArray.get(i).getCountry() != " "){
                countryData.add(dataArray.get(i).getCountry());
            }
        }

        for(String element : countryData){
            if(!sortedCountryData.contains(element)){
                sortedCountryData.add(element);
            }
        }
        return (sortedCountryData);
    }
}

