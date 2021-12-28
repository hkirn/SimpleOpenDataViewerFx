package com.prog.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class TaxiObject extends ObjectTemplate{
    private String foto;
    private String fotoWegZurHaltestelle;

    public TaxiObject(String[] valueString) {
        String[] newValueString = Arrays.copyOf(valueString, 11);
        setSameVariables(newValueString);
        setSameVariablesWithOffset(newValueString, 0);
        setVariables(newValueString);
        System.out.println(this + "angelegt");
    }

    private void setVariables(String[] valueString){
        this.foto = convertToNull(valueString[9]);
        this.fotoWegZurHaltestelle = convertToNull(valueString[10]);
    }

    public ObservableList<InfoObject> getInfo() {
        ObservableList<InfoObject> info = getInfoTemplate();
        return info;
    }

    public ObservableList<LinkObject> getLink() {
        ObservableList<LinkObject> link = FXCollections.observableArrayList();
        link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
        link.add(new LinkObject("Foto Taxistand", this.foto));
        link.add(new LinkObject("Foto Weg zur Haltestelle", this.fotoWegZurHaltestelle));
        return link;
    }

    public String getDescription() {
        return "keine weiteren Informationen verfügbar";
    }
}
