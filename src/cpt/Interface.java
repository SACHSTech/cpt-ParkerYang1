package cpt;
import java.util.*;
import java.io.*;
import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.IOException;

public class Interface {

    public static void main(String args[]) throws IOException{
        String line; 
        String country;
        String year;
        String deaths; 

        BufferedReader br = new BufferedReader(new FileReader("src/cpt/SortedDataSet.csv"));

        for (int i = 0; i < 458; i++){
            line = br.readLine();

            String[] splitLine = line.split(",");
            country = splitLine[0];
            year = splitLine[1];
            deaths = splitLine[2];

            double dblDeaths = Double.parseDouble(deaths);
            int intYears = Integer.parseInt(year);

            Deaths dead = new Deaths(country, intYears, dblDeaths);
            System.out.println(dead);
        }
        br.close();
    } 
}
