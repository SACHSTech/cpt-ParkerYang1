package cpt;
import java.util.*;
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
import javafx.scene.chart.ScatterChart;

/**
 * Data Interaction and Visualization CPT 
 * @author: P. Yang
 * 
 */

public class Interface extends Application{

    // Variables for bar chart
    private BarChart<Number, String> chart;
    private NumberAxis xAxis;
    private CategoryAxis yAxis;
    Button HBCbutton;
    Button SGbutton;
    XYChart.Series<Number, String> series1 = new XYChart.Series<>();
    XYChart.Series<Number, String> series2 = new XYChart.Series<>();

    // Variable for tab pane 
    TabPane tabPane;

    // Variable scatter chart 
    private ScatterChart<String, Number> chart2;
    private CategoryAxis xAxis2;
    private NumberAxis yAxis2;
    XYChart.Series<String, Number> series3 = new XYChart.Series<>();
    XYChart.Series<String, Number> series4 = new XYChart.Series<>();

    // Filter object
    Filter masterList = new Filter();

    /**
     * Makes a horizontal bar chart based off the data 
     * @return Returns the horizontal bar chart 
     * @author: P. Yang
     * 
     */
    public Parent horizontalBarChart() throws IOException{

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
            series1.getData().add(new XYChart.Data<Number, String>(list2016.get(i).getDeaths(), list2016.get(i).getCountry()));
        }
        
        // For loop to run through entire array to display country and death for 2017
        series2.setName("2017");
        for(int j = 0; j < list2017.size(); j++){
            series2.getData().add(new XYChart.Data<Number, String>(list2017.get(j).getDeaths(), list2017.get(j).getCountry()));
        }

        // Set dimensions for chart
        chart.setPrefWidth(1500);
        chart.setPrefHeight(2500);
        return chart;
        }

        /**
         * Makes a scatter graph based off the data 
         * @return Returns the scatter graph
         * @author: P. Yang
         * 
         */
        public Parent ScatterGraph() throws IOException{

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

            // Set up scatter graph
            final ObservableList<String> categories2 =
            FXCollections.<String>observableArrayList(Arrays.asList(temp));
            xAxis2 = new CategoryAxis();
            yAxis2 = new NumberAxis();
            chart2 = new ScatterChart<>(xAxis2, yAxis2);

            // Set labels 
            chart2.setTitle("Death Rates From Mental Health and Substance Use Disorders");
            xAxis2.setLabel("Countries");
            xAxis2.setCategories(categories2);
            yAxis2.setLabel("Deaths (Per 100,000)");

            // Set 2016 series name 
            series3.setName("2016");
            
            // For loop to run through entire array to display country and death for 2016
            for(int j = 0; j < list2016.size(); j++){
                series3.getData().add(new XYChart.Data<String, Number>(list2016.get(j).getCountry(), list2016.get(j).getDeaths()));
            }

            // Set 2017 series name 
            series4.setName("2017");

            // For loop to run through entire array to display country and death for 2017
            for(int k = 0; k < list2017.size(); k++){
                series4.getData().add(new XYChart.Data<String, Number>(list2017.get(k).getCountry(), list2017.get(k).getDeaths()));
            }

            // Set chart dimensions
            chart2.setPrefWidth(1000);
            chart2.setPrefHeight(1000);
            return chart2;
        }

        /**
         * Runs the stage
         * @author: P. Yang
         * 
         */
        @Override public void start(Stage primaryStage) throws IOException {
            //Border pane
            BorderPane root = new BorderPane();

            // Radio buttons for horizontal bar chart
            RadioButton HBCbox2016 = new RadioButton("2016");
            RadioButton HBCbox2017 = new RadioButton("2017");

            // Enter button for horizontal bar chart
            HBCbutton = new Button("Enter");

            // Handle controls for radio buttons (horizontal bar chart)
            HBCbutton.setOnAction(e -> handleOptionHBC(HBCbox2016, HBCbox2017, series1, series2));

            // Radio buttons for scatter graph
            RadioButton SGbox2016 = new RadioButton("2016");
            RadioButton SGbox2017 = new RadioButton("2017");

            // Enter button for scatter graph
            SGbutton = new Button("Enter");

            // Handle controls for radio buttons (scatter graph)
            SGbutton.setOnAction(e -> handleOptionSG(SGbox2016, SGbox2017, series3, series4));

            // Tabs set up
            tabPane = new TabPane();
            tabPane.setSide(Side.TOP);

            // Tab 1
            Tab tab1 = new Tab("Chart #1 (Horizontal Bar Chart)");
            tab1.setClosable(false);
            VBox layout1 = new VBox(10);
            layout1.setPadding(new Insets(10)); 
            layout1.getChildren().addAll(tabPane, HBCbox2016, HBCbox2017, HBCbutton, horizontalBarChart());
            tab1.setContent(layout1);
            tabPane.getTabs().add(tab1);

            // Tab 2
            Tab tab2 = new Tab("Chart #2 (Scatter Graph)");
            tab2.setClosable(false);
            VBox layout2 = new VBox(10);
            layout2.setPadding(new Insets(10)); 
            layout2.getChildren().addAll(tabPane, SGbox2016, SGbox2017, SGbutton, ScatterGraph());
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

        /**
         * Button handle option for horizontal bar chart
         * @param HBCbox2016 Button to display 2016 data 
         * @param HBCbox2017 Button to display 2017 data 
         * @param series1 Series data for 2016
         * @param series2 Series data for 2017
         * @author: P. Yang
         * 
         */
        public void handleOptionHBC(RadioButton HBCbox2016, RadioButton HBCbox2017, XYChart.Series<Number, String> series1, XYChart.Series<Number, String> series2){
            if(HBCbox2016.isSelected()){
                chart.getData().add(series1);
            } else {
                chart.getData().remove(series1);
            }

            if(HBCbox2017.isSelected()){
                chart.getData().add(series2);
            } else {
                chart.getData().remove(series2);
            }
        }
        
        /**
         * Button handle option for scatter graph
         * @param SGbox2016 Button to display 2016 data
         * @param SGbox2017 Button to display 2017 data
         * @param series3 Series data for 2016
         * @param series4 Series data for 2017
         * @author: P. Yang
         * 
         */
        public void handleOptionSG(RadioButton SGbox2016, RadioButton SGbox2017, XYChart.Series<String, Number> series3, XYChart.Series<String, Number> series4){
            if(SGbox2016.isSelected()){
                chart2.getData().add(series3);
            } else {
                chart2.getData().remove(series3);
            }

            if(SGbox2017.isSelected()){
                chart2.getData().add(series4);
            } else {
                chart2.getData().remove(series4);
            }
        }
        
        /**
         * Runs program 
         * @author: P. Yang
         * 
         */
        public static void main(String[] args) {
            launch(args);
        }
    }