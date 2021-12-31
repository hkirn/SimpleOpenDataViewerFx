package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class ParkplatzObject extends ObjectTemplate {
  private String art;
  private String eigentuemer;
  private String nutzungsbedingungen;
  private int anzahlStellplaetzeGes;
  private int anzahlStellplaetzeBeh;
  private double[] posBehindertenparkplaetze;
  private String fotoParkplatz;
  private String fotoBehindertenParkplatz;
  private String fotoOeffungszeiten;
  private String fotoNutzungsbedingungen;
  private String fotoWegzuHaltestelle;

  public ParkplatzObject(String[] valueString) {
    String[] newValueString = Arrays.copyOf(valueString, 21);
    setSameVariables(newValueString);
    setSameVariablesWithOffset(newValueString, 0);
    setVariables(newValueString);
    System.out.println(this + "angelegt");
  }

  private void setVariables(String[] valueString) {
    this.art = convertToNull(valueString[9]);
    this.eigentuemer = convertToNull(valueString[10]);
    this.nutzungsbedingungen = convertToNull(valueString[11]);
    this.anzahlStellplaetzeGes = convertToInt(valueString[12]);
    this.anzahlStellplaetzeBeh = convertToInt(valueString[13]);
    this.posBehindertenparkplaetze =
        new double[] {convertToDouble(valueString[15]), convertToDouble(valueString[14])};
    this.fotoParkplatz = convertToNull(valueString[16]);
    this.fotoBehindertenParkplatz = convertToNull(valueString[17]);
    this.fotoOeffungszeiten = convertToNull(valueString[18]);
    this.fotoNutzungsbedingungen = convertToNull(valueString[19]);
    this.fotoWegzuHaltestelle = convertToNull(valueString[20]);
  }

  public ObservableList<InfoObject> getInfo() {
    ObservableList<InfoObject> info = getInfoTemplate();
    info.add(new InfoObject("Art", this.art));
    info.add(new InfoObject("Eigentümer", this.eigentuemer));
    info.add(new InfoObject("Nutzungsbedingungen", this.nutzungsbedingungen));
    info.add(new InfoObject("Anzahl Stellplätze", "" + this.anzahlStellplaetzeGes));
    info.add(new InfoObject("Anzahl Behindertenparkplätze", "" + this.anzahlStellplaetzeBeh));
    info.add(
        new InfoObject(
            "Position Behindertenparkplätze", convertToPosString(this.posBehindertenparkplaetze)));
    return info;
  }

  public ObservableList<LinkObject> getLink() {
    ObservableList<LinkObject> link = FXCollections.observableArrayList();
    link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
    link.add(new LinkObject("Position Behindertenparkplätze", getPosLink(this.posBehindertenparkplaetze)));
    link.add(new LinkObject("Foto Parkplatz", this.fotoParkplatz));
    link.add(new LinkObject("Foto Behindertenparkplatz", this.fotoBehindertenParkplatz));
    link.add(new LinkObject("Foto Öffnungszeiten", this.fotoOeffungszeiten));
    link.add(new LinkObject("Foto Nutzungsbedingungen", this.fotoNutzungsbedingungen));
    link.add(new LinkObject("Weg zur Haltestelle", this.fotoWegzuHaltestelle));
    return link;
  }

  public String getDescription() {
    return art;
  }
}
