package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class InformationsstelleObject extends ObjectTemplate {
    private String infostelleName;
    private boolean stufenfrei;
    private String fotoInfostelle;
    private String fotoInfostelleEingang;
    private String fotoInfostelleWeg;
    private String fotoInfostelleOeffungszeiten;

    public InformationsstelleObject(String[] valueString) {
        String[] newValueString = Arrays.copyOf(valueString, 15);
        setSameVariables(newValueString);
        setSameVariablesWithOffset(newValueString, 0);
        setVariables(newValueString);
        System.out.println(this + "angelegt");
    }

    private void setVariables(String[] valueString){
        this.infostelleName = convertToNull(valueString[9]);
        this.stufenfrei = convertToBool(valueString[10]);
        this.fotoInfostelle = convertToNull(valueString[11]);
        this.fotoInfostelleEingang = convertToNull(valueString[12]);
        this.fotoInfostelleWeg = convertToNull(valueString[13]);
        this.fotoInfostelleOeffungszeiten = convertToNull(valueString[14]);
    }

    public String getDescription() {
        return infostelleName;
    }

    public ObservableList<InfoObject> getInfo() {
        ObservableList<InfoObject> info = getInfoTemplate();
        info.add(new InfoObject("Bezeichnung Informationsstelle", this.infostelleName));
        info.add(new InfoObject("Zugang Stufenfrei", boolToString(this.stufenfrei)));
        return info;
    }

    public ObservableList<LinkObject> getLink() {
        ObservableList<LinkObject> link = FXCollections.observableArrayList();
        link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
        link.add(new LinkObject("Foto Informationsstelle", this.fotoInfostelle));
        link.add(new LinkObject("Foto Eingang Informationsstelle", this.fotoInfostelleEingang));
        link.add(new LinkObject("Foto Weg zu Informationsstelle", this.fotoInfostelleWeg));
        link.add(new LinkObject("Foto Öffnungszeiten", this.fotoInfostelleOeffungszeiten));
        return link;
    }
}
