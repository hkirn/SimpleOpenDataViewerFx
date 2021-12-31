package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class GleisquerungObject extends ObjectTemplate {
    private int breiteCm;
    private String verbindungsfunktion;
    private String fotoQuerung;
    private String fotoWeg1;
    private String fotoWeg2;

    public GleisquerungObject(String[] valueString) {
        String[] newValueString = Arrays.copyOf(valueString, 14);
        setSameVariables(newValueString);
        setSameVariablesWithOffset(newValueString, 0);
        setVariables(newValueString);
        System.out.println(this + "angelegt");
    }

    private void setVariables(String[] valueString){
        this.breiteCm = convertToInt(valueString[9]);
        this.verbindungsfunktion = convertToNull(valueString[10]);
        this.fotoQuerung = convertToNull(valueString[11]);
        this.fotoWeg1 = convertToNull(valueString[12]);
        this.fotoWeg2 = convertToNull(valueString[13]);
    }

    public ObservableList<InfoObject> getInfo() {
        ObservableList<InfoObject> info = getInfoTemplate();
        info.add(new InfoObject("Funktion", verbindungsfunktion));
        info.add(new InfoObject("Breite in cm", ""+breiteCm));
        return info;
    }

    public ObservableList<LinkObject> getLink() {
        ObservableList<LinkObject> link = FXCollections.observableArrayList();
        link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
        link.add(new LinkObject("Foto Gleisquerung",fotoQuerung));
        link.add(new LinkObject("Foto Weg zu Gleisquerung 1", fotoWeg1));
        link.add(new LinkObject("Foto Weg zu Gleisquerung 2", fotoWeg2));
        return link;
    }

    public String getDescription() {
        return verbindungsfunktion;
    }
}
