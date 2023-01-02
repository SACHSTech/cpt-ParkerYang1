package cpt;
import java.util.*;
import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DeathsDataCreator {
    private ArrayList<Deaths> deathArray;

    public DeathsDataCreator(){
        deathArray = new ArrayList<Deaths>();
    }

    public void addNewData(Deaths deathCounter){
        deathArray.add(deathCounter);
    }

    public ArrayList<Deaths> getObject(){
        return deathArray;
    }

    public ObservableList<Double> getObservableList(){
        ArrayList<Double> temporary = new ArrayList<Double>();
        for(int i = 0; i < deathArray.size(); i++){
            temporary.add(deathArray.get(i).getDeaths());
        }
        return FXCollections.observableList(temporary);
    }
}
