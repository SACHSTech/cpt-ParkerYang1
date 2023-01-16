package cpt;
import java.util.*;
import java.io.*;
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;

public class Filter {
    public static void main(String[] args) throws IOException{
        getArray(2016);
    }

    public static ArrayList<Deaths> getArray(int certainYear) throws IOException{
        String line; 
        String country;
        double deaths;
        int year;
        ArrayList<Deaths> dataArray = new ArrayList<>();
        ArrayList<Deaths> dataArray2016 = new ArrayList<>();
        ArrayList<Deaths> dataArray2017 = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("src/cpt/DataSet.csv"));
        line = br.readLine();

        for(int i = 0; i < 6411; i++){
            line = br.readLine();

            String[] splitLine = line.split(",");
            country = splitLine[0];
            year = Integer.parseInt(splitLine[2]);
            deaths = Double.parseDouble(splitLine[3]);

            Deaths deathCounter = new Deaths(country, year, deaths);

            if(certainYear == 2016){
                if(year == 2016){
                    dataArray2016.add(deathCounter);
                    dataArray = dataArray2016;
                }
            } else if (certainYear == 2017){
                if(year == 2017){
                    dataArray2017.add(deathCounter);
                    dataArray = dataArray2017;
                }
            } 
        }
        br.close();
        System.out.println(dataArray);
        return(dataArray);
    }
}

