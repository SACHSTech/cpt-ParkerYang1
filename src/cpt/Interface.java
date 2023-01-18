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
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class Interface extends Application{

    private LineChart<String, Number> chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    Filter masterList = new Filter();

    public Parent LineChart() throws IOException{

        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        chart = new LineChart<>(xAxis, yAxis);

        masterList.initializeList();
        ArrayList<Deaths> list2016 = new ArrayList<>();
        list2016 = masterList.yearSpecificList(2016);

        ArrayList<Deaths> list2017 = new ArrayList<>();
        list2017 = masterList.yearSpecificList(2017);

        // setup chart
        chart.setTitle("Death Rates From Mental Health and Substance Use Disorders");
        xAxis.setLabel("Countries");
        yAxis.setLabel("Deaths (per 100,000)");

        // add starting data
        XYChart.Series<String, Number> series2016 = new XYChart.Series<>();
        series2016.setName("2016");

        for(int i = 0; i < list2016.size(); i++){
        series2016.getData().add(new XYChart.Data<String, Number>(list2016.get(i).getCountry(), list2016.get(i).getDeaths()));
        chart.getData().add(series2016);
        }

        XYChart.Series<String, Number> series2017 = new XYChart.Series<>();
        series2016.setName("2017");

        for(int j = 0; j < list2017.size(); j++){
            series2017.getData().add(new XYChart.Data<String, Number>(list2017.get(j).getCountry(), list2017.get(j).getDeaths()));
            chart.getData().add(series2017);
            }
        return chart;
    }

        @Override public void start(Stage primaryStage) throws Exception {
            /* 
            CheckBox box2016 = new CheckBox("2016");
            CheckBox box2017 = new CheckBox("2017");

            VBox layout = new VBox();
            layout.setPadding(new Insets(20, 20, 20, 20));
            layout.getChildren().addAll(box2016, box2017);
            */

            primaryStage.setScene(new Scene(LineChart()));
            primaryStage.show();

        }
        public static void main(String[] args) {
            launch(args);
        }

}

