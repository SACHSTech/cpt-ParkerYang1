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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class Interface extends Application{

    private static final String[] data2016 = { "Alpha", "Beta", "RC1", "RC2", "1.0", "1.1" };
    private LineChart<String, Number> chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    public Parent LineChart() {

        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        chart = new LineChart<>(xAxis, yAxis);

        // setup chart
        chart.setTitle("Death Rates From Mental Health and Substance Use Disorders");
        xAxis.setLabel("Countries");
        yAxis.setLabel("Deaths (per 100,000)");

        // add starting data
        XYChart.Series<String, Number> series2016 = new XYChart.Series<>();
        series2016.setName("2016");

        for(int i = 0; i < 6; i++){
        series2016.getData().add(new XYChart.Data<String, Number>(data2016[i], i));
        chart.getData().add(series2016);
        }

        XYChart.Series<String, Number> series2017 = new XYChart.Series<>();
        series2017.setName("2017");
        series2017.getData().add(new XYChart.Data<String, Number>(data2016[0], 10d));
        series2017.getData().add(new XYChart.Data<String, Number>(data2016[1], 20d));
        series2017.getData().add(new XYChart.Data<String, Number>(data2016[2], 30d));
        series2017.getData().add(new XYChart.Data<String, Number>(data2016[3], 40d));
        series2017.getData().add(new XYChart.Data<String, Number>(data2016[4], 50d));
        series2017.getData().add(new XYChart.Data<String, Number>(data2016[5], 60d));
        chart.getData().add(series2017);
        return chart;
    }

        @Override public void start(Stage primaryStage) throws Exception {
            primaryStage.setScene(new Scene(LineChart()));
            primaryStage.show();
        }
        public static void main(String[] args) {
            launch(args);
        }

}

