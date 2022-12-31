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

public class Interface extends Application {
    public static void main(String arg[]){
        launch(arg);
    }
 
        private BarChart chart;
        private CategoryAxis xAxis;
        private NumberAxis yAxis;

        public Parent BarCharts() throws IOException{
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
            newCountryName = countryName.toArray(newCountryName);

            br.close();

            int size = newCountryName.length;
            for(int i = 0; i < size; i++){
                count++;
            }

            xAxis = new CategoryAxis();
            xAxis.setCategories(FXCollections.<String>observableArrayList(newCountryName));
            yAxis = new NumberAxis("Deaths", 0.0d, 5000.0d, 100.0d);
            ObservableList<BarChart.Series> barChartData =
            FXCollections.observableArrayList(
                new BarChart.Series("2016", FXCollections.observableArrayList(
                    new BarChart.Data(newCountryName[0], 567d)))
            );
            chart = new BarChart(xAxis, yAxis, barChartData, 1.0d);
            return chart;
        }

        @Override public void start(Stage primaryStage) throws Exception {
            primaryStage.setScene(new Scene(BarCharts()));
            primaryStage.show();
        }
        
}

