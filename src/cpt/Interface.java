package cpt;
import java.util.*;
import java.io.*;
import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

public class Interface {

    public static void main(String args[]) throws IOException{
        String line; 
        String country;
        
        List<String> countryName = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader("src/cpt/SortedDataSet.csv"));
        line = br.readLine();

        for(int i = 0; i < 457; i++){
            line = br.readLine();

            String[] splitLine = line.split(",");
            country = splitLine[0];

            if(i % 2 == 0){
                countryName.add(country);
            }
        }

        System.out.println(countryName);
        br.close();
    } 
}
