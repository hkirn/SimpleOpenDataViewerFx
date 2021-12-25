package com.prog.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class HaltesteigObject extends ObjectTemplate {
  private String steig_Name;
  private String bodenbelag;
  private String steigtyp;
  private String hochboardart;
  private double steiglaenge_m;
  private int steigbreite_cm;
  private int steigbreiteEngstelle_cm;
  private int steighoehe_cm;
  private double laengsneigung;
  private double querneigung;
  private boolean bodenindEinstiegsbereich;
  private boolean bodenindLeitstreifen;
  private boolean bodenindAuffindstreifen;
  private String beleuchtungAmSteig;
  private boolean sitzplaetze;
  private boolean unterstand;
  private boolean rollstuhlflaecheImUnterstand;
  private boolean unterstandWaendeBodennah;
  private boolean unterstandKontrastelemente;
  private boolean unterstandOffiziell;
  private int sitzplaetzeSumme;
  private boolean abfallbehaelter;
  private boolean uhr;
  private int tuer2FreieLaenge_cm;
  private int tuer2FreieBreite_cm;
  private boolean fahrzielanzeiger;
  private boolean fahrzielanzeigerAkustisch;
  private boolean fahrkartenautomat;
  private String fahrkartenautomatId;
  private double[] posFahrkartenautomat;

  public HaltesteigObject(String[] valueString) {
    String[] newValueString = Arrays.copyOf(valueString, 105);
    setSameVariables(newValueString);
    setSameVariablesWithOffset(newValueString, 1);
    setVariables(newValueString);
    System.out.println(this + "angelegt");
  }

  private void setVariables(String[] valueString) {
    this.steig_Name = convertToNull(valueString[3]);
    this.bodenbelag = valueString[11];
    this.steigtyp = valueString[12];
    this.hochboardart = valueString[13];
    this.steiglaenge_m = convertToDouble(valueString[14]);
    this.steigbreite_cm = convertToInt(valueString[15]);
    this.steigbreiteEngstelle_cm = convertToInt(valueString[16]);
    this.steighoehe_cm = convertToInt(valueString[17]);
    this.laengsneigung = convertToDouble(valueString[18]);
    this.querneigung = convertToDouble(valueString[19]);
    this.bodenindEinstiegsbereich = convertToBool(valueString[20]);
    this.bodenindLeitstreifen = convertToBool(valueString[21]);
    this.bodenindAuffindstreifen = convertToBool(valueString[22]);
    this.beleuchtungAmSteig = valueString[23];
    this.sitzplaetze = convertToBool(valueString[24]);
    this.unterstand = convertToBool(valueString[25]);
    this.rollstuhlflaecheImUnterstand = convertToBool(valueString[26]);
    this.unterstandWaendeBodennah = convertToBool(valueString[27]);
    this.unterstandKontrastelemente = convertToBool(valueString[28]);
    this.unterstandOffiziell = convertToBool(valueString[29]);
    this.sitzplaetzeSumme = convertToInt(valueString[30]);
    this.uhr = convertToBool(valueString[32]);
    this.tuer2FreieLaenge_cm = convertToInt(valueString[33]);
    this.tuer2FreieBreite_cm = convertToInt(valueString[34]);
    this.fahrzielanzeiger = convertToBool(valueString[35]);
    this.fahrzielanzeigerAkustisch = convertToBool(valueString[36]);
    this.fahrkartenautomat = convertToBool(valueString[37]);
    this.fahrkartenautomatId = valueString[38];
    this.posFahrkartenautomat =
        new double[] {convertToDouble(valueString[40]), convertToDouble(valueString[39])};
  }

  public String getSteig_Name() {
    return steig_Name;
  }

  public ObservableList<InfoObject> getInfo() {
    ObservableList<InfoObject> info = getInfoTemplate();
    info.add(new InfoObject("Steigname", steig_Name));
    info.add(new InfoObject("Bodenbelag", bodenbelag));
    info.add(new InfoObject("Steigtyp", steigtyp));
    info.add(new InfoObject("Hochboardart", hochboardart));
    info.add(new InfoObject("Steiglänge in m", "" + steiglaenge_m));
    info.add(new InfoObject("Steigbreite in cm", "" + steigbreite_cm));
    info.add(new InfoObject("Engste Stelle in cm", "" + steigbreiteEngstelle_cm));
    info.add(new InfoObject("Steighöhe in cm", "" + steighoehe_cm));
    info.add(new InfoObject("Längsneigung", "" + laengsneigung));
    info.add(new InfoObject("Querneigung", "" + querneigung));
    info.add(new InfoObject("Bodenindikatoren Einstieg", boolToString(bodenindEinstiegsbereich)));
    info.add(new InfoObject("Bodenindikatoren Leitstreifen", boolToString(bodenindLeitstreifen)));
    info.add(
        new InfoObject("Bodenindikatoren Auffindstreifen", boolToString(bodenindAuffindstreifen)));
    info.add(new InfoObject("Beleuchtung am Steig", beleuchtungAmSteig));
    info.add(new InfoObject("Sitzplätze", boolToString(sitzplaetze)));
    info.add(new InfoObject("Unterstand", boolToString(unterstand)));
    info.add(
        new InfoObject(
            "Rollstuhlfläche im Unterstand", boolToString(rollstuhlflaecheImUnterstand)));
    info.add(
        new InfoObject("Unterstand Kontrastelemente", boolToString(unterstandKontrastelemente)));
    info.add(new InfoObject("Unterstand offiziell", boolToString(unterstandOffiziell)));
    info.add(new InfoObject("Sitzplätze Summe", "" + sitzplaetzeSumme));
    info.add(new InfoObject("Abfallbehälter", boolToString(abfallbehaelter)));
    info.add(new InfoObject("Uhr", boolToString(uhr)));
    info.add(new InfoObject("Tür 2 freie Länge cm", "" + tuer2FreieLaenge_cm));
    info.add(new InfoObject("Tür 2 freie Breite cm", "" + tuer2FreieBreite_cm));
    info.add(new InfoObject("Fahrzielanzeiger", boolToString(fahrzielanzeiger)));
    info.add(new InfoObject("Fahrzielanzeiger akustisch", boolToString(fahrzielanzeigerAkustisch)));
    info.add(new InfoObject("Fahrkartenautomat", boolToString(fahrkartenautomat)));
    info.add(new InfoObject("Fahrkartenautomat ID", fahrkartenautomatId));
    info.add(
        new InfoObject(
            "Position Fahrkartenautomat",
            posFahrkartenautomat[0] + " : " + posFahrkartenautomat[1]));
    return info;
  }

  public ObservableList<LinkObject> getLink() {
    ObservableList<LinkObject> link = FXCollections.observableArrayList();

    link.add(new LinkObject("Haltesteigposition OpenStreetMaps", getPosLink(getPos())));
    link.add(
        new LinkObject(
            "Position Fahrkartenautomat OpenStreetMaps", getPosLink(posFahrkartenautomat)));
    return link;
  }
}
