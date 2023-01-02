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

public class Interface{
    public static void main(String arg[]){
            
    }
        public static void DeathCounter() throws IOException{
            String line; 
            String country;
            int count = 0;
            
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

            String[] newCountryName = new String[countryName.size()];

            for (int i = 0; i < countryName.size(); i++){
                newCountryName[i] = countryName.get(i);
            }
            br.close();
        }
}

/** 
        @Override public void start(Stage primaryStage) throws Exception {
            primaryStage.setScene(new Scene(BarCharts()));
            primaryStage.show();
        }
*/


