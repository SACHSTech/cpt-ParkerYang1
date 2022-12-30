package cpt;
import java.util.*;
import java.io.*;
import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 

public class Filter {
    public static void main(String [] args) throws IOException{
        // Buffer reader and writer 
        BufferedReader deaths = new BufferedReader(new FileReader("src/cpt/DataSet.csv"));
        PrintWriter sortedDeaths = new PrintWriter(new FileWriter("src/cpt/SortedDataSet.csv"));

        String line; 

        line = deaths.readLine();

        // While loop to go through the file 
        while(line != null){
            ArrayList<String> data = new ArrayList<>(Arrays.asList(line.split(",")));
            data.add(line);

            // Writes data for the year of 2016 in a new CSV file 
            if(data.get(2).equalsIgnoreCase("2016")){
                sortedDeaths.println(data.get(0) + "," + data.get(2) + "," + data.get(3));
            
            // Writes data for the year of 2017 in a new CSV file 
            } else if(data.get(2).equalsIgnoreCase("2017")){
                sortedDeaths.println(data.get(0) + "," + data.get(2) + "," + data.get(3));
            }
            line = deaths.readLine();
        }

        // Close
        sortedDeaths.close();
        deaths.close();

    }
}
