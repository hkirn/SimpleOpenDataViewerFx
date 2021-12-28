package com.prog.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class VerkaufsstelleObject extends ObjectTemplate{
    private String verkaufsstelleName;
    private boolean stufenfrei;
    private String foto;
    private String fotoEingang;
    private String fotoOeffnungszeiten;
    private String fotoWeg;

    public VerkaufsstelleObject(String[] valueString) {
        String[] newValueString = Arrays.copyOf(valueString, 15);
        setSameVariables(newValueString);
        setSameVariablesWithOffset(newValueString, 0);
        setVariables(newValueString);
        System.out.println(this + "angelegt");
    }

    private void setVariables(String[] valueString){
        this.verkaufsstelleName = convertToNull(valueString[9]);
        this.stufenfrei = convertToBool(valueString[10]);
        this.foto = convertToNull(valueString[11]);
        this.fotoEingang = convertToNull(valueString[12]);
        this.fotoOeffnungszeiten = convertToNull(valueString[13]);
        this.fotoWeg = convertToNull(valueString[14]);
    }

    public ObservableList<InfoObject> getInfo() {
        ObservableList<InfoObject> info = getInfoTemplate();
        info.add(new InfoObject("Bezeichnung",this.verkaufsstelleName));
        info.add(new InfoObject("Stufenfrei", boolToString(this.stufenfrei)));
        return info;
    }

    public ObservableList<LinkObject> getLink() {
        ObservableList<LinkObject> link = FXCollections.observableArrayList();
        link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
        link.add(new LinkObject("Foto Verkaufsstelle", this.foto));
        link.add(new LinkObject("Foto Eingang", this.fotoEingang));
        link.add(new LinkObject("Foto Öffnungszeiten",this.fotoOeffnungszeiten));
        link.add(new LinkObject("Foto Weg zu Verkaufsstelle", this.fotoWeg));
        return link;
    }

    public String getDescription() {
        return this.verkaufsstelleName;
    }
}
