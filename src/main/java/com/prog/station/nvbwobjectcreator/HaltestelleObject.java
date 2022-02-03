package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Arrays;

public class HaltestelleObject extends ObjectTemplate {
  private String district;
  private String town;
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
    setSameVariables(newValueString);
    setSameVariablesWithOffset(valueString, 0);
    setVariables(newValueString);
  }

  private void setVariables(String[] valueString) {
    this.Sitzplaetze = convertToBool(valueString[9]);
    this.Unterstand = convertToBool(valueString[10]);
    this.RollstuhlflaecheImUnterstand = convertToBool(valueString[11]);
    this.Fahrplananzeigetafel = convertToBool(valueString[12]);
    this.Fahrplananzeigetafel_akustisch = convertToBool(valueString[13]);
    this.Ansagen_vorhanden = convertToBool(valueString[14]);
    this.Defibrillator = convertToBool(valueString[15]);
    this.Defibrilator_Lagebeschreibung = convertToNull(valueString[16]);
    this.Gepaeckaufbewahrung = convertToBool(valueString[17]);
    this.Gepaecktransport = convertToBool(valueString[18]);
    this.InduktiveHoeranlage = convertToBool(valueString[19]);
    this.InduktiveHoeranlageStandort = convertToNull(valueString[20]);
    this.InfoNotrufsaeule = convertToNull(valueString[21]);
    this.Bahnhofsmission = convertToBool(valueString[22]);
    this.HaltestelleTotale_Foto = convertToNull(valueString[23]);
    this.SitzeOderUnterstand_Foto = convertToNull(valueString[24]);
    this.SitzeOderUnterstandUmgebung_Foto = convertToNull(valueString[25]);
    this.Fahrplananzeigetafel_Foto = convertToNull(valueString[26]);
    this.Defibrillator_Foto = convertToNull(valueString[27]);
    this.Gepaeckaufbewahrung_Foto = convertToNull(valueString[28]);
    this.InfoNotrufsaeule_Foto = convertToNull(valueString[29]);
    this.Bahnhofsmision_Foto = convertToNull(valueString[30]);
    this.BahnhofsmissionWeg_Foto = convertToNull(valueString[31]);
    this.BahnhofsmissionOeffunungszeiten_Foto = convertToNull(valueString[32]);
    this.WeitereBilder1_Foto = convertToNull(valueString[33]);
    this.WeitereBilder2_Foto = convertToNull(valueString[34]);
    this.WeitereBilder3_Foto = convertToNull(valueString[35]);
  }

  public String getDistrict() {
    return district;
  }

  public String getTown() {
    return town;
  }

  public String getHaltestelleTotale_Foto() {
    return HaltestelleTotale_Foto;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public ObservableList<InfoObject> getInfo() {
    ObservableList<InfoObject> info = getInfoTemplate();
    info.add(new InfoObject("Landkreis", this.district));
    info.add(new InfoObject("Stadt", this.town));
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
    ObservableList<LinkObject> link = FXCollections.observableArrayList();
    link.add(new LinkObject("Haltestelle Foto", HaltestelleTotale_Foto));
    link.add(new LinkObject("Sitze/Unterstand Foto", SitzeOderUnterstand_Foto));
    link.add(new LinkObject("Umgebung Sitze/Unterstand", SitzeOderUnterstandUmgebung_Foto));
    link.add(new LinkObject("Fahrplananzeigetafel", Fahrplananzeigetafel_Foto));
    link.add(new LinkObject("Defibrillator Foto", Defibrillator_Foto));
    link.add(new LinkObject("Gepäckaufbewahrung Foto", Gepaeckaufbewahrung_Foto));
    link.add(new LinkObject("Info-/Notrufsäule Foto", InfoNotrufsaeule_Foto));
    link.add(new LinkObject("Bahnhofsmission Foto", Bahnhofsmision_Foto));
    link.add(new LinkObject("Weg zu Bahnhofsmission Foto", BahnhofsmissionWeg_Foto));
    link.add(
        new LinkObject(
            "Bahnhofsmission Öffnungszeiten Foto:", BahnhofsmissionOeffunungszeiten_Foto));
    link.add(new LinkObject("Weiteres Foto 1", WeitereBilder1_Foto));
    link.add(new LinkObject("Weiteres Foto 2", WeitereBilder2_Foto));
    link.add(new LinkObject("Weiteres Foto 3", WeitereBilder3_Foto));
    link.add(new LinkObject("Haltestellenposition OpenStreetMaps", getPosLink(getPos())));
    return link;
  }
}
