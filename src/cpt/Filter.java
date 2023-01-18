package cpt;
import java.util.*;
import java.io.*;
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;

public class Filter{

    static ArrayList<Deaths> dataArray = new ArrayList<Deaths>();

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

    public ArrayList<Deaths> yearSpecificList(int specificYear){
        ArrayList<Deaths> sortedData = new ArrayList<Deaths>();

        for(int i = 0; i < dataArray.size(); i++){
            if(dataArray.get(i).getYear() == specificYear){
                sortedData.add(dataArray.get(i));
            }
        }
        return (sortedData);
    }

    /* 
    public static void main(String[] args) throws IOException{
        initializeList();
        yearSpecificList(2016);
    }
    */
}

