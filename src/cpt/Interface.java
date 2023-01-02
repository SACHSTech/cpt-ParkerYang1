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

public class Interface extends Application{

    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
    public static void main(String arg[])throws IOException{
        DeathCounter();
        launch(arg);
    }
        public static void DeathCounter() throws IOException{
            String line; 
            String country;
            double deaths;
            int year;
            ArrayList<Deaths> deathArray = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader("src/cpt/SortedDataSet.csv"));
            line = br.readLine();

            for(int i = 0; i < 457; i++){
                line = br.readLine();

                String[] splitLine = line.split(",");
                country = splitLine[0];
                year = Integer.parseInt(splitLine[1]);
                deaths = Double.parseDouble(splitLine[2]);

                Deaths deathCounter = new Deaths(country, year, deaths);
                deathArray.add(deathCounter);
            }
            br.close();
        }

        public Parent BarChart() throws IOException{
            String[] data = deathArray;
            xAxis = new CategoryAxis();
            xAxis.setCategories(FXCollections.<String>observableArrayList(data));
            yAxis = new NumberAxis("Units Sold", 0.0d, 3000.0d, 1000.0d);
            ObservableList<BarChart.Series> barChartData =
                FXCollections.observableArrayList(
                  new BarChart.Series("2016", FXCollections.observableArrayList(
                    new BarChart.Data(data[0], 567d),
                    new BarChart.Data(data[1], 1292d),
                    new BarChart.Data(data[2], 1292d))),
                  new BarChart.Series("2017", FXCollections.observableArrayList(
                    new BarChart.Data(data[0], 956),
                    new BarChart.Data(data[1], 1665),
                    new BarChart.Data(data[2], 2559)))
            );
        chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);
        return chart;
        }

        @Override public void start(Stage primaryStage) throws Exception {
            primaryStage.setScene(new Scene(BarChart()));
            primaryStage.show();
        }
}

