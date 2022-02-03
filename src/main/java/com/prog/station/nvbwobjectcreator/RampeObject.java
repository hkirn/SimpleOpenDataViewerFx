package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class RampeObject extends ObjectTemplate {
  private int laengeCm;
  private int breiteCm;
  private double laengsneigungProzent;
  private double querneigungProzent;
  private String verbindungsfunktion;
  private String fotoRampe;
  private String fotoRichtung1;
  private String fotoRichtung2;

  public RampeObject(String[] valueString) {
    String[] newValueString = Arrays.copyOf(valueString, 17);
    setSameVariables(newValueString);
    setSameVariablesWithOffset(newValueString, 0);
    setVariables(newValueString);
    System.out.println(this + "angelegt");
  }

  private void setVariables(String[] valueString) {
    this.laengeCm = convertToInt(valueString[9]);
    this.breiteCm = convertToInt(valueString[10]);
    this.laengsneigungProzent = convertToDouble(valueString[11]);
    this.querneigungProzent = convertToDouble(valueString[12]);
    this.verbindungsfunktion = convertToNull(valueString[13]);
    this.fotoRampe = convertToNull(valueString[14]);
    this.fotoRichtung1 = convertToNull(valueString[15]);
    this.fotoRichtung2 = convertToNull(valueString[16]);
    this.fotoToShow = this.fotoRampe;
  }

  public ObservableList<InfoObject> getInfo() {
    ObservableList<InfoObject> info = getInfoTemplate();
    info.add(new InfoObject("Länge in cm", "" + this.laengeCm));
    info.add(new InfoObject("Breite in cm", "" + this.breiteCm));
    info.add(new InfoObject("Längsneigung %", "" + this.laengsneigungProzent));
    info.add(new InfoObject("Querneigung %", "" + this.querneigungProzent));
    info.add(new InfoObject("Verbindungsfunktion", "" + this.verbindungsfunktion));
    return info;
  }

  public ObservableList<LinkObject> getLink() {
    ObservableList<LinkObject> link = FXCollections.observableArrayList();
    link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
    link.add(new LinkObject("Foto Rampe", fotoRampe));
    link.add(new LinkObject("Foto Rampe in eine Richtung", fotoRichtung1));
    link.add(new LinkObject("Foto Rampe in andere Richtung", fotoRichtung2));
    return link;
  }

  public String getDescription() {
    return verbindungsfunktion;
  }
}
