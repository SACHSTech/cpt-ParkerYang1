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
import javafx.scene.chart.XYChart;
import java.util.Arrays;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Interface extends Application{

    private BarChart<Number, String> chart;
    private NumberAxis xAxis;
    private CategoryAxis yAxis;
    Button button;
    XYChart.Series<Number, String> series1 = new XYChart.Series<>();
    XYChart.Series<Number, String> series2 = new XYChart.Series<>();
    TabPane tabPane;

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
        series1.setName("2016");
        for(int i = 0; i < list2016.size(); i++){
            series1.getData().add(
                new XYChart.Data<Number, String>(list2016.get(i).getDeaths(), list2016.get(i).getCountry()));
        }
        
        // For loop to run through entire array to display country and death for 2017
        series2.setName("2017");
        for(int j = 0; j < list2017.size(); j++){
            series2.getData().add(
                new XYChart.Data<Number, String>(list2017.get(j).getDeaths(), list2017.get(j).getCountry()));
        }

        // Add series to chart
        chart.setPrefWidth(1500);
        chart.setPrefHeight(2500);
        return chart;
        }

        @Override public void start(Stage primaryStage) throws IOException {
            //Border pane
            BorderPane root = new BorderPane();

            // Radio buttons
            RadioButton box2016 = new RadioButton("2016");

            RadioButton box2017 = new RadioButton("2017");

            // Enter button
            button = new Button("Enter");

            // Handle controls for radio buttons
            button.setOnAction(e -> handleOptionBC(box2016, box2017, series1, series2));

            // Tabs
            tabPane = new TabPane();
            tabPane.setSide(Side.TOP);

            // Tab 1
            Tab tab1 = new Tab("Chart #1");
            tab1.setClosable(false);
            VBox layout1 = new VBox(10);
            layout1.setPadding(new Insets(10)); 
            layout1.getChildren().addAll(tabPane, box2016, box2017, button, createContent());
            tab1.setContent(layout1);
            tabPane.getTabs().add(tab1);

            // Tab 2
            Tab tab2 = new Tab("Chart #2");
            tab2.setClosable(false);
            VBox layout2 = new VBox(10);
            layout2.setPadding(new Insets(10)); 
            layout2.getChildren().addAll(tabPane);
            tab2.setContent(layout2);
            tabPane.getTabs().add(tab2);

            root.setCenter(tabPane);

            // Set screen
            Scene screen = new Scene(root); 
            primaryStage.setTitle("ICS4U Data Interaction and Visualization CPT (Parker Yang)");
            primaryStage.setScene(screen);
            primaryStage.setWidth(1500);
            primaryStage.setHeight(1500);
            primaryStage.show();
        }

        public void handleOptionBC(RadioButton box2016, RadioButton box2017, XYChart.Series<Number, String> series1, XYChart.Series<Number, String> series2){
            if(box2016.isSelected()){
                chart.getData().add(series1);
            } else {
                chart.getData().remove(series1);
            }

            if (box2017.isSelected()){
                chart.getData().add(series2);
            } else {
                chart.getData().remove(series2);
            }
        }
        public static void main(String[] args) {
            launch(args);
        }
    }

