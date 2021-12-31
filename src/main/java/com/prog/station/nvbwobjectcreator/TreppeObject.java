package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class TreppeObject extends ObjectTemplate {
    private int anzahlStufen;
    private int hoeheStufen;
    private boolean handlaufLinks;
    private boolean handlaufRechts;
    private boolean handlaufMittig;
    private boolean fahrradrinne;
    private String verbindungsfunktion;
    private String foto;

    public TreppeObject(String[] valueString) {
        String[] newValueString = Arrays.copyOf(valueString, 17);
        setSameVariables(newValueString);
        setSameVariablesWithOffset(newValueString, 0);
        setVariables(newValueString);
        System.out.println(this + "angelegt");
    }

    private void setVariables(String[] valueString){
        this.anzahlStufen = convertToInt(valueString[9]);
        this.hoeheStufen = convertToInt(valueString[10]);
        this.handlaufLinks = convertToBool(valueString[11]);
        this.handlaufRechts = convertToBool(valueString[12]);
        this.handlaufMittig = convertToBool(valueString[13]);
        this.fahrradrinne = convertToBool(valueString[14]);
        this.verbindungsfunktion = convertToNull(valueString[15]);
        this.foto = convertToNull(valueString[16]);
    }

    public ObservableList<InfoObject> getInfo() {
        ObservableList<InfoObject> info = getInfoTemplate();
        info.add(new InfoObject("Anzahl Stufen", ""+this.anzahlStufen));
        info.add(new InfoObject("Höhe Stufen", ""+this.hoeheStufen));
        info.add(new InfoObject("Handlauf links", boolToString(this.handlaufLinks)));
        info.add(new InfoObject("Handlauf rechts", boolToString(this.handlaufRechts)));
        info.add(new InfoObject("Handlauf mittig", boolToString(this.handlaufMittig)));
        info.add(new InfoObject("Fahrradrinne", boolToString(this.fahrradrinne)));
        info.add(new InfoObject("Verbindungsfunktion", this.verbindungsfunktion));
        return info;
    }

    public ObservableList<LinkObject> getLink() {
        ObservableList<LinkObject> link = FXCollections.observableArrayList();
        link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
        link.add(new LinkObject("Foto Treppe", this.foto));
        return link;
    }

    public String getDescription() {
        return this.verbindungsfunktion;
    }
}
