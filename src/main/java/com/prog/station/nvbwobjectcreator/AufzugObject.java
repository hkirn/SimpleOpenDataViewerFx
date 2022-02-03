package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class AufzugObject extends ObjectTemplate {
  private int tuerweiteInCm;
  private int kabinenbreiteInCm;
  private int kabinenlaengeInCm;
  private String verbindungsfunktion;
  private String fotoAufzug;
  private String fotoAufzugId;
  private String fotoStoerungskontakt;
  private String fotoEbene1;
  private String fotoEbene2;
  private String fotoEbene3;

  public AufzugObject(String[] valueString) {
    String[] newValueString = Arrays.copyOf(valueString, 19);
    setSameVariables(newValueString);
    setSameVariablesWithOffset(newValueString, 0);
    setVariables(newValueString);
    System.out.println(this + "angelegt");
  }

  private void setVariables(String[] valueString) {
    this.tuerweiteInCm = convertToInt(valueString[9]);
    this.kabinenbreiteInCm = convertToInt(valueString[10]);
    this.kabinenlaengeInCm = convertToInt(valueString[11]);
    this.verbindungsfunktion = convertToNull(valueString[12]);
    this.fotoAufzug = convertToNull(valueString[13]);
    this.fotoAufzugId = convertToNull(valueString[14]);
    this.fotoStoerungskontakt = convertToNull(valueString[15]);
    this.fotoEbene1 = convertToNull(valueString[16]);
    this.fotoEbene2 = convertToNull(valueString[17]);
    this.fotoEbene3 = convertToNull(valueString[18]);
    this.fotoToShow = this.fotoAufzug;
  }

  public ObservableList<InfoObject> getInfo() {
    ObservableList<InfoObject> info = getInfoTemplate();
    info.add(new InfoObject("Türweite in cm", "" + this.tuerweiteInCm));
    info.add(new InfoObject("Kabinenbreite in cm", "" + this.kabinenbreiteInCm));
    info.add(new InfoObject("Kabinenlaenge in cm", "" + this.kabinenlaengeInCm));
    info.add(new InfoObject("Verbindungsfunktion", this.verbindungsfunktion));
    return info;
  }

  public ObservableList<LinkObject> getLink() {
    ObservableList<LinkObject> link = FXCollections.observableArrayList();
    link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
    link.add(new LinkObject("Foto Aufzug", fotoAufzug));
    link.add(new LinkObject("Foto Aufzug-Id", fotoAufzugId));
    link.add(new LinkObject("Foto Störungskontaktdaten", fotoStoerungskontakt));
    link.add(new LinkObject("Foto Aufzug Ebene 1", fotoEbene1));
    link.add(new LinkObject("Foto Aufzug Ebene 2", fotoEbene2));
    link.add(new LinkObject("Foto Aufzug Ebene 3", fotoEbene3));
    return link;
  }

  public String getDescription() {
    return verbindungsfunktion;
  }
}
