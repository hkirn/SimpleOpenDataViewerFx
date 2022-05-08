package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class WegObject extends ObjectTemplate {
  private String wegart;
  private int laengeCm;
  private int breiteCm;
  private double laengsneigung;
  private double querneigung;
  private int hoehe;
  private boolean beleuchtet;
  private String ueberdacht;
  private String verbindungsfunktion;
  private String foto;
  private String fotoRichtung1;
  private String fotoRichtung2;

  public WegObject(String[] valueString) {
    String[] newValueString = Arrays.copyOf(valueString, 21);
    setSameVariables(newValueString);
    setSameVariablesWithOffset(newValueString, 0);
    setVariables(newValueString);
    System.out.println(this + "angelegt");
  }

  private void setVariables(String[] valueString) {
    this.wegart = convertToNull(valueString[9]);
    this.laengeCm = convertToInt(valueString[10]);
    this.breiteCm = convertToInt(valueString[11]);
    this.laengsneigung = convertToDouble(valueString[12]);
    this.querneigung = convertToDouble(valueString[13]);
    this.hoehe = convertToInt(valueString[14]);
    this.beleuchtet = convertToBool(valueString[15]);
    this.ueberdacht = convertToNull(valueString[16]);
    this.verbindungsfunktion = convertToNull(valueString[17]);
    this.foto = convertToNull(valueString[18]);
    this.fotoRichtung1 = convertToNull(valueString[19]);
    this.fotoRichtung2 = convertToNull(valueString[20]);
    this.fotoToShow = this.foto;
  }

  public ObservableList<InfoObject> getInfo() {
    ObservableList<InfoObject> info = getInfoTemplate();
    info.add(new InfoObject("Wegart", this.wegart));
    info.add(new InfoObject("Länge in cm", "" + this.laengeCm));
    info.add(new InfoObject("Länge in m", "" + (this.laengeCm / 100)));
    info.add(new InfoObject("Breite in cm", "" + this.breiteCm));
    info.add(new InfoObject("Längsneigung %", "" + this.laengsneigung));
    info.add(new InfoObject("Querneigung %", "" + this.querneigung));
    info.add(new InfoObject("Höhe in cm", "" + this.hoehe));
    info.add(new InfoObject("Beleuchtet", boolToString(this.beleuchtet)));
    info.add(new InfoObject("Überdacht", ""+(this.ueberdacht)));
    info.add(new InfoObject("Verbindungsfunktion", this.verbindungsfunktion));
    return info;
  }

  public ObservableList<LinkObject> getLink() {
    ObservableList<LinkObject> link = FXCollections.observableArrayList();
    link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
    link.add(new LinkObject("Foto Weg", this.foto));
    link.add(new LinkObject("Foto in Richtung 1", this.fotoRichtung1));
    link.add(new LinkObject("Foto in Richtung 2", this.fotoRichtung2));
    return link;
  }

  public String getDescription() {
    return wegart + " - " + verbindungsfunktion;
  }
}
