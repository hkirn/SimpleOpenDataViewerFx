package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class ToiletteObject extends ObjectTemplate {
    private boolean rollstuhltauglich;
    private boolean rollstuhltauglichAlle;
    private boolean schluesselEurokey;
    private boolean schluesselLokal;
    private String oeffnungszeiten;
    private String notizSchluesselLokal;
    private String foto;
    private String fotoOeffungszeiten;
    private String fotoNutzungsbedingungen;
    private String fotoUmgebung1;
    private String fotoUmgebung2;


    public ToiletteObject(String[] valueString) {
        String[] newValueString = Arrays.copyOf(valueString, 20);
        setSameVariables(newValueString);
        setSameVariablesWithOffset(newValueString, 0);
        setVariables(newValueString);
        System.out.println(this + "angelegt");
    }

    private void setVariables(String[] valueString){
        this.rollstuhltauglich = convertToBool(valueString[9]);
        this.rollstuhltauglichAlle = convertToBool(valueString[10]);
        this.schluesselEurokey = convertToBool(valueString[11]);
        this.schluesselLokal = convertToBool(valueString[12]);
        this.oeffnungszeiten = convertToNull(valueString[13]);
        this.notizSchluesselLokal = convertToNull(valueString[14]);
        this.foto = convertToNull(valueString[15]);
        this.fotoOeffungszeiten = convertToNull(valueString[16]);
        this.fotoNutzungsbedingungen = convertToNull(valueString[17]);
        this.fotoUmgebung1 = convertToNull(valueString[18]);
        this.fotoUmgebung2 = convertToNull(valueString[19]);
    }

    public ObservableList<InfoObject> getInfo() {
        ObservableList<InfoObject> info = getInfoTemplate();
        info.add(new InfoObject("Rollstuhltauglich", boolToString(this.rollstuhltauglich)));
        info.add(new InfoObject("Rollstuhltauglich für alle", boolToString(this.rollstuhltauglichAlle)));
        info.add(new InfoObject("Eurokey", boolToString(this.schluesselEurokey)));
        info.add(new InfoObject("Lokaler Schlüssel", boolToString(this.schluesselLokal)));
        info.add(new InfoObject("Öffnungszeiten", this.oeffnungszeiten));
        info.add(new InfoObject("Notiz Schlüssel lokal",this.notizSchluesselLokal));
        return info;
    }

    public ObservableList<LinkObject> getLink() {
        ObservableList<LinkObject> link = FXCollections.observableArrayList();
        link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
        link.add(new LinkObject("Foto Toilette", this.foto));
        link.add(new LinkObject("Foto Öffnungszeiten", this.fotoOeffungszeiten));
        link.add(new LinkObject("Foto Nutzungsbedingungen", this.fotoNutzungsbedingungen));
        link.add(new LinkObject("Foto Umgebung 1", this.fotoUmgebung1));
        link.add(new LinkObject("Foto Umgebung 2", this.fotoUmgebung2));
        return link;
    }

    public String getDescription() {
        return oeffnungszeiten;
    }
}
