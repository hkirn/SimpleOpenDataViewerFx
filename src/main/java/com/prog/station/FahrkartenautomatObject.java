package com.prog.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class FahrkartenautomatObject extends ObjectTemplate{
    private String kartenautomatenId;
    private boolean entwerterVorhanden;
    private String fotoKartenautomat;
    private String fotoTicketvalidator;

    public FahrkartenautomatObject(String[] valueString) {
        String[] newValueString = Arrays.copyOf(valueString, 13);
        setSameVariables(newValueString);
        setSameVariablesWithOffset(newValueString, 0);
        setVariables(newValueString);
        System.out.println(this + "angelegt");
    }

    private void setVariables(String[] valueString){
        this.kartenautomatenId = convertToNull(valueString[9]);
        this.entwerterVorhanden = convertToBool(valueString[10]);
        this.fotoKartenautomat = convertToNull(valueString[11]);
        this.fotoTicketvalidator = convertToNull(valueString[12]);
    }

    public ObservableList<InfoObject> getInfo() {
        ObservableList<InfoObject> info = getInfoTemplate();
        info.add(new InfoObject("Fahrkartenautomat Id", this.kartenautomatenId));
        info.add(new InfoObject("Entwerter vorhanden", boolToString(this.entwerterVorhanden)));
        return info;
    }

    public ObservableList<LinkObject> getLink() {
        ObservableList<LinkObject> link = FXCollections.observableArrayList();
        link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
        link.add(new LinkObject("Foto Fahrkartenautomat", this.fotoKartenautomat));
        link.add(new LinkObject("Foto Ticketvalidator", this.fotoTicketvalidator));
        return link;
    }

    public String getKartenautomatenId() {
        return kartenautomatenId;
    }
}
