package com.prog.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class ToiletteObject extends ObjectTemplate{

    public ToiletteObject(String[] valueString) {
        String[] newValueString = Arrays.copyOf(valueString, 18);
        setSameVariables(newValueString);
        setSameVariablesWithOffset(newValueString, 0);
        setVariables(newValueString);
        System.out.println(this + "angelegt");
    }

    private void setVariables(String[] newValueString){
    }

    public ObservableList<InfoObject> getInfo() {
        ObservableList<InfoObject> info = getInfoTemplate();
        return info;
    }

    public ObservableList<LinkObject> getLink() {
        ObservableList<LinkObject> link = FXCollections.observableArrayList();

        link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
        return link;
    }

    public String getDescription() {
        return "keine weiteren Informationen verfügbar";
    }
}
