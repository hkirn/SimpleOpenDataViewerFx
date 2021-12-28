package com.prog.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class TuerObject extends ObjectTemplate{
    private String tuerart;
    private String oeffnungsart;
    private int tuerbreite;
    private String foto;

    public TuerObject(String[] valueString) {
        String[] newValueString = Arrays.copyOf(valueString, 13);
        setSameVariables(newValueString);
        setSameVariablesWithOffset(newValueString, 0);
        setVariables(newValueString);
        System.out.println(this + "angelegt");
    }

    private void setVariables(String[] valueString){
        this.tuerart = convertToNull(valueString[9]);
        this.oeffnungsart = convertToNull(valueString[10]);
        this.tuerbreite = convertToInt(valueString[11]);
        this.foto = convertToNull(valueString[12]);
    }

    public ObservableList<InfoObject> getInfo() {
        ObservableList<InfoObject> info = getInfoTemplate();
        info.add(new InfoObject("Türart", this.tuerart));
        info.add(new InfoObject("Öffnungsart", this.oeffnungsart));
        info.add(new InfoObject("Türbreite", ""+this.tuerbreite));
        return info;
    }

    public ObservableList<LinkObject> getLink() {
        ObservableList<LinkObject> link = FXCollections.observableArrayList();
        link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
        link.add(new LinkObject("Foto Tür", this.foto));
        return link;
    }

    public String getDescription() {
        return this.tuerart;
    }
}
