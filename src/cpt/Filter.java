package cpt;
import java.util.*;
import java.io.*;
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;

public class Filter {

    public ArrayList<Deaths> getObject() throws IOException{

        String line; 
        String country;
        double deaths;
        int year;
        ArrayList<Deaths> originalDataArray = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("src/cpt/DataSet.csv"));
        line = br.readLine();

        for(int i = 0; i < 6411; i++){
            line = br.readLine();

            String[] splitLine = line.split(",");
            country = splitLine[0];
            year = Integer.parseInt(splitLine[2]);
            deaths = Double.parseDouble(splitLine[3]);

            Deaths deathCounter = new Deaths(country, year, deaths);
            originalDataArray.add(deathCounter);
        }
        br.close();
        return(originalDataArray);
    }

    public void testPrint() throws IOException{
        System.out.println(this.getObject());
    }


}

