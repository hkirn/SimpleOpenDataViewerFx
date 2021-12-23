package com.prog.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class HaltestelleObject {
  private String ID;
  private String HST_Name;
  private String Datenquelle;
  private String Datenstatus;
  private double Longitude;
  private double Latitude;
  private String Koordinatenquelle;
  private String OSM_ID;
  private boolean Sitzplaetze;
  private boolean Unterstand;
  private boolean RollstuhlflaecheImUnterstand;
  private boolean Fahrplananzeigetafel;
  private boolean Fahrplananzeigetafel_akustisch;
  private boolean Ansagen_vorhanden;
  private boolean Defibrillator;
  private String Defibrilator_Lagebeschreibung;
  private boolean Gepaeckaufbewahrung;
  private boolean Gepaecktransport;
  private boolean InduktiveHoeranlage;
  private String InduktiveHoeranlageStandort;
  private String InfoNotrufsaeule;
  private boolean Bahnhofsmission;
  private String HaltestelleTotale_Foto;
  private String SitzeOderUnterstand_Foto;
  private String SitzeOderUnterstandUmgebung_Foto;
  private String Fahrplananzeigetafel_Foto;
  private String Defibrillator_Foto;
  private String Gepaeckaufbewahrung_Foto;
  private String InfoNotrufsaeule_Foto;
  private String Bahnhofsmision_Foto;
  private String BahnhofsmissionWeg_Foto;
  private String BahnhofsmissionOeffunungszeiten_Foto;
  private String WeitereBilder1_Foto;
  private String WeitereBilder2_Foto;
  private String WeitereBilder3_Foto;

  public HaltestelleObject(String[] valueString) {
    System.out.println(this + "angelegt");
    String[] newValueString = Arrays.copyOf(valueString, 36);
    setVariables(newValueString);
  }

  private void setVariables(String[] valueString) {
    this.ID = convertToNull(valueString[0]);
    this.HST_Name = convertToNull(valueString[2]);
    this.Datenquelle = convertToNull(valueString[3]);
    this.Datenstatus = convertToNull(valueString[4]);
    this.Longitude = Double.valueOf(valueString[5].replace(",", "."));
    Latitude = Double.valueOf(valueString[6].replace(",", "."));
    Koordinatenquelle = convertToNull(valueString[7]);
    OSM_ID = convertToNull(valueString[8]);
    Sitzplaetze = convertToBool(valueString[9]);
    Unterstand = convertToBool(valueString[10]);
    RollstuhlflaecheImUnterstand = convertToBool(valueString[11]);
    Fahrplananzeigetafel = convertToBool(valueString[12]);
    Fahrplananzeigetafel_akustisch = convertToBool(valueString[13]);
    Ansagen_vorhanden = convertToBool(valueString[14]);
    Defibrillator = convertToBool(valueString[15]);
    Defibrilator_Lagebeschreibung = convertToNull(valueString[16]);
    Gepaeckaufbewahrung = convertToBool(valueString[17]);
    Gepaecktransport = convertToBool(valueString[18]);
    InduktiveHoeranlage = convertToBool(valueString[19]);
    InduktiveHoeranlageStandort = convertToNull(valueString[20]);
    InfoNotrufsaeule = convertToNull(valueString[21]);
    Bahnhofsmission = convertToBool(valueString[22]);
    HaltestelleTotale_Foto = convertToNull(valueString[23]);
    SitzeOderUnterstand_Foto = convertToNull(valueString[24]);
    SitzeOderUnterstandUmgebung_Foto = convertToNull(valueString[25]);
    Fahrplananzeigetafel_Foto = convertToNull(valueString[26]);
    Defibrillator_Foto = convertToNull(valueString[27]);
    Gepaeckaufbewahrung_Foto = convertToNull(valueString[28]);
    InfoNotrufsaeule_Foto = convertToNull(valueString[29]);
    Bahnhofsmision_Foto = convertToNull(valueString[30]);
    BahnhofsmissionWeg_Foto = convertToNull(valueString[31]);
    BahnhofsmissionOeffunungszeiten_Foto = convertToNull(valueString[32]);
    WeitereBilder1_Foto = convertToNull(valueString[33]);
    WeitereBilder2_Foto = convertToNull(valueString[34]);
    WeitereBilder3_Foto = convertToNull(valueString[35]);
  }

  private boolean convertToBool(String stringToCovert) {
    if (stringToCovert.equals("ja")) {
      return true;
    } else return false;
  }

  private String convertToNull(String stringToConvert) {
    if ((stringToConvert == null) || (stringToConvert.trim().equals(""))) {
      return null;
    } else {
      return stringToConvert;
    }
  }

  public String getID() {
    return ID;
  }

  public String getHST_Name() {
    return HST_Name;
  }

  public String getDatenquelle() {
    return Datenquelle;
  }

  public String getDatenstatus() {
    return Datenstatus;
  }

  public double[] getPos() {
    double[] arr = {Latitude, Longitude};
    return arr;
  }

  public String getKoordinatenquelle() {
    return Koordinatenquelle;
  }

  public String getOSM_ID() {
    return OSM_ID;
  }

  public boolean isSitzplaetze() {
    return Sitzplaetze;
  }

  public boolean isUnterstand() {
    return Unterstand;
  }

  public boolean isRollstuhlflaecheImUnterstand() {
    return RollstuhlflaecheImUnterstand;
  }

  public boolean isFahrplananzeigetafel() {
    return Fahrplananzeigetafel;
  }

  public boolean isFahrplananzeigetafel_akustisch() {
    return Fahrplananzeigetafel_akustisch;
  }

  public boolean isAnsagen_vorhanden() {
    return Ansagen_vorhanden;
  }

  public boolean isDefibrillator() {
    return Defibrillator;
  }

  public String getDefibrilator_Lagebeschreibung() {
    return Defibrilator_Lagebeschreibung;
  }

  public boolean isGepaeckaufbewahrung() {
    return Gepaeckaufbewahrung;
  }

  public boolean isGepaecktransport() {
    return Gepaecktransport;
  }

  public boolean isInduktiveHoeranlage() {
    return InduktiveHoeranlage;
  }

  public String getInduktiveHoeranlageStandort() {
    return InduktiveHoeranlageStandort;
  }

  public String getInfoNotrufsaeule() {
    return InfoNotrufsaeule;
  }

  public boolean isBahnhofsmission() {
    return Bahnhofsmission;
  }

  public String getHaltestelleTotale_Foto() {
    return HaltestelleTotale_Foto;
  }

  public String getSitzeOderUnterstand_Foto() {
    return SitzeOderUnterstand_Foto;
  }

  public String getSitzeOderUnterstandUmgebung_Foto() {
    return SitzeOderUnterstandUmgebung_Foto;
  }

  public String getFahrplananzeigetafel_Foto() {
    return Fahrplananzeigetafel_Foto;
  }

  public String getDefibrillator_Foto() {
    return Defibrillator_Foto;
  }

  public String getGepaeckaufbewahrung_Foto() {
    return Gepaeckaufbewahrung_Foto;
  }

  public String getInfoNotrufsaeule_Foto() {
    return InfoNotrufsaeule_Foto;
  }

  public String getBahnhofsmision_Foto() {
    return Bahnhofsmision_Foto;
  }

  public String getBahnhofsmissionWeg_Foto() {
    return BahnhofsmissionWeg_Foto;
  }

  public String getBahnhofsmissionOeffunungszeiten_Foto() {
    return BahnhofsmissionOeffunungszeiten_Foto;
  }

  public String getWeitereBilder1_Foto() {
    return WeitereBilder1_Foto;
  }

  public String getWeitereBilder2_Foto() {
    return WeitereBilder2_Foto;
  }

  public String getWeitereBilder3_Foto() {
    return WeitereBilder3_Foto;
  }

  public ObservableList<InfoObject> getInfo() {
    ObservableList<InfoObject> info = FXCollections.observableArrayList();
    info.add(new InfoObject("ID", this.ID));
    info.add(new InfoObject("Name", HST_Name));
    info.add(new InfoObject("Datenquelle", Datenquelle));
    info.add(new InfoObject("Datenstatus", Datenstatus));
    info.add(new InfoObject("GPS-Position", Latitude + " : " + Longitude));
    info.add(new InfoObject("Koordinatenquelle", Koordinatenquelle));
    info.add(new InfoObject("OSM-ID", OSM_ID));
    info.add(new InfoObject("Sitzplätze", boolToString(Sitzplaetze)));
    info.add(new InfoObject("Unterstand", boolToString(Unterstand)));
    info.add(
        new InfoObject("Rollstuhlfäche Unterstand", boolToString(RollstuhlflaecheImUnterstand)));
    info.add(new InfoObject("Fahrplananzeigetafel", boolToString(Fahrplananzeigetafel)));
    info.add(
        new InfoObject(
            "Fahrplananzeigetafel akkustisch", boolToString(Fahrplananzeigetafel_akustisch)));
    info.add(new InfoObject("Ansagen vorhanden", boolToString(Ansagen_vorhanden)));
    info.add(new InfoObject("Defibrillator vorhanden", boolToString(Defibrillator)));
    info.add(new InfoObject("Defibrillator Lagebeschreibung", Defibrilator_Lagebeschreibung));
    info.add(new InfoObject("Gepäckaufbewahrung:", boolToString(Gepaeckaufbewahrung)));
    info.add(new InfoObject("Gepäcktransport", boolToString(Gepaecktransport)));
    info.add(new InfoObject("induktive Höranlage", boolToString(InduktiveHoeranlage)));
    info.add(new InfoObject("Standort induktive Höranlage", InduktiveHoeranlageStandort));
    info.add(new InfoObject("Info Notrufsäule", InfoNotrufsaeule));
    info.add(new InfoObject("Bahnhofsmission", boolToString(Bahnhofsmission)));
    return info;
  }

  public ObservableList<LinkObject> getLink() {
    ObservableList<LinkObject> info = FXCollections.observableArrayList();
    info.add(new LinkObject("Haltestelle Foto", HaltestelleTotale_Foto));
    info.add(new LinkObject("Sitze/Unterstand Foto", SitzeOderUnterstand_Foto));
    info.add(new LinkObject("Umgebung Sitze/Unterstand", SitzeOderUnterstandUmgebung_Foto));
    info.add(new LinkObject("Fahrplananzeigetafel", Fahrplananzeigetafel_Foto));
    info.add(new LinkObject("Defibrillator Foto", Defibrillator_Foto));
    info.add(new LinkObject("Gepäckaufbewahrung Foto", Gepaeckaufbewahrung_Foto));
    info.add(new LinkObject("Info-/Notrufsäule Foto", InfoNotrufsaeule_Foto));
    info.add(new LinkObject("Bahnhofsmission Foto", Bahnhofsmision_Foto));
    info.add(new LinkObject("Weg zu Bahnhofsmission Foto", BahnhofsmissionWeg_Foto));
    info.add(
        new LinkObject(
            "Bahnhofsmission Öffnungszeiten Foto:", BahnhofsmissionOeffunungszeiten_Foto));
    info.add(new LinkObject("Weiteres Foto 1", WeitereBilder1_Foto));
    info.add(new LinkObject("Weiteres Foto 2", WeitereBilder2_Foto));
    info.add(new LinkObject("Weiteres Foto 3", WeitereBilder3_Foto));
    info.add(new LinkObject("Haltestellenposition OpenStreetMaps", getPosLink()));
    return info;
  }

  public String getPosLink() {
    double posOffset = 0.001;
    return "https://www.openstreetmap.org/export/embed.html?bbox="
        + (this.getPos()[1] - posOffset)
        + ","
        + (this.getPos()[0] - posOffset)
        + ","
        + (this.getPos()[1] + posOffset)
        + ","
        + (this.getPos()[0] + posOffset)
        + "&layer=mapnik&marker="
        + this.getPos()[0]
        + ","
        + this.getPos()[1];

    // return "https://www.openstreetmap.org/?mlat="
    //        + this.getPos()[0]
    //        + "&mlon="
    //        + this.getPos()[1]
    //        + "&zoom=15#map=15/"
    //        + this.getPos()[0]
    //        + "/"
    //        + this.getPos()[1];
  }

  private String boolToString(Boolean boolToConvert) {
    if (boolToConvert == true) {
      return "Ja";
    } else {
      return "Nein";
    }
  }
}
