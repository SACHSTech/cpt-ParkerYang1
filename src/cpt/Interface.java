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
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Interface extends Application{

    /* 
    private LineChart<String, Number> chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
    */

    private BarChart<Number, String> chart;
    private NumberAxis xAxis;
    private CategoryAxis yAxis;

    Filter masterList = new Filter();

    public Parent createContent() throws IOException{

        masterList.initializeList();

        // Call list method for 2016 in filter class
        ArrayList<Deaths> list2016 = new ArrayList<>();
        list2016 = masterList.yearSpecificList(2016);

        // Call list method for 2017 in filter class
        ArrayList<Deaths> list2017 = new ArrayList<>();
        list2017 = masterList.yearSpecificList(2017);

        // Call list method for countries in filter class
        ArrayList<String> countryList = new ArrayList<>();
        countryList = masterList.countryList();
    
        // Convert countryList into array
        String[] temp = new String[countryList.size()];
        temp = countryList.toArray(temp);

        final ObservableList<String> categories =
            FXCollections.<String>observableArrayList(Arrays.asList(temp));
        xAxis = new NumberAxis();
        yAxis = new CategoryAxis();
        chart = new BarChart<>(xAxis, yAxis);

        // Set up chart
        chart.setTitle("Death Rates From Mental Health and Substance Use Disorders");
        yAxis.setLabel("Countries");
        yAxis.setCategories(categories);
        xAxis.setLabel("Deaths (Per 100,000)");

        // For loop to run through entire array to display country and death for 2016
        XYChart.Series<Number, String> series1 = new XYChart.Series<>();
        series1.setName("2016");
        for(int i = 0; i < list2016.size(); i++){
            series1.getData().addAll(
                new XYChart.Data<Number, String>(list2016.get(i).getDeaths(), list2016.get(i).getCountry()));
        }
        
        // For loop to run through entire array to display country and death for 2017
        XYChart.Series<Number, String> series2 = new XYChart.Series<>();
        series2.setName("2017");
        for(int j = 0; j < list2017.size(); j++){
            series2.getData().addAll(
                new XYChart.Data<Number, String>(list2017.get(j).getDeaths(), list2017.get(j).getCountry()));
        }

        // Add series to chart
        chart.getData().add(series1);
        chart.getData().add(series2);
        return chart;

        }

        @Override public void start(Stage primaryStage) throws IOException {
            primaryStage.setScene(new Scene(createContent()));
            primaryStage.setWidth(1200);
            primaryStage.setHeight(1200);
            primaryStage.show();

        }
        public static void main(String[] args) {
            launch(args);
        }
    }

