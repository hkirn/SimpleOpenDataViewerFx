package com.prog.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class StationsplanObject extends ObjectTemplate{
    private boolean planTaktil;
    private boolean akustischeAusgabe;
    private String bodenindikatoren;
    private String foto;
    private String fotoUmgebung;

    public StationsplanObject(String[] valueString) {
        String[] newValueString = Arrays.copyOf(valueString, 14);
        setSameVariables(newValueString);
        setSameVariablesWithOffset(newValueString, 0);
        setVariables(newValueString);
        System.out.println(this + "angelegt");
    }

    private void setVariables(String[] valueString){
        this.planTaktil = convertToBool(valueString[9]);
        this.akustischeAusgabe = convertToBool(valueString[10]);
        this.bodenindikatoren = convertToNull(valueString[11]);
        this.foto = convertToNull(valueString[12]);
        this.fotoUmgebung = convertToNull(valueString[13]);
    }

    public ObservableList<InfoObject> getInfo() {
        ObservableList<InfoObject> info = getInfoTemplate();
        info.add(new InfoObject("Taktil ertastbarer Plan", boolToString(this.planTaktil)));
        info.add(new InfoObject("akustische Ausgabe", boolToString(this.akustischeAusgabe)));
        info.add(new InfoObject("Art der Bodenindikatoren", this.bodenindikatoren));
        return info;
    }

    public ObservableList<LinkObject> getLink() {
        ObservableList<LinkObject> link = FXCollections.observableArrayList();
        link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
        link.add(new LinkObject("Foto Plan", this.foto));
        link.add(new LinkObject("Foto Umgebung", this.fotoUmgebung));
        return link;
    }

    public String getDescription() {
        return "keine weiteren Informationen verfügbar";
    }
}
