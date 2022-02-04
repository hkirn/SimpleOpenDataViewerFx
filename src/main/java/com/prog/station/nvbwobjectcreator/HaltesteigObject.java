package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.Objects;

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
  private int sitzplaetzeSumme;
  private boolean abfallbehaelter;
  private boolean uhr;
  private boolean fahrzielanzeiger;
  private boolean fahrzielanzeigerAkustisch;
  private boolean fahrkartenautomat;
  private String fahrkartenautomatId;
  private double[] posFahrkartenautomat;
  private String fahrgastinfoart;
  private String fahrgastinfoKorrekteHoehe;
  private String fahrgastinfoBarrierefrei;
  private boolean ansagenVorhanden;
  private String infoNotrufSaeule;
  private boolean mobileRampe;
  private int mobileRampeLaengeCm;
  private int mobileRampeTragfaehigkeitKg;
  private boolean hublift;
  private int hubliftStellflaecheCm;
  private int hubliftTragfaehigkeitKg;
  private double[] posHaltepunkt1;
  private double[] posHaltepunkt2;
  private double[] posHaltepunkt3;
  private double[] posHaltepunkt4;
  private double[] posAbschnitt1;
  private double[] posAbschnitt2;
  private double[] posAbschnitt3;
  private double[] posAbschnitt4;
  private double[] posAbschnitt5;
  private double[] posAbschnitt6;
  private double[] posAbschnitt7;
  private double[] posAbschnitt8;
  private String fotoSteig;
  private String fotoSteig2;
  private String fotoSteigGegenueber;
  private String fotoHochboardartSonstiges;
  private String fotoSteigbreite;
  private String fotoSteigbreiteEngstelle;
  private String fotoBodenindikatorenEinstiegsbereich;
  private String fotoBodenindikatorenLeitstreifen;
  private String fotoBodenindikatorenAuffindestreifen;
  private String fotoUnterstand;
  private String fotoUhr;
  private String fotoHaltesteigmast;
  private String fotoFahrgastinfoNichtBarrierefrei;
  private String fotoInfoNotrufsaeule;
  private String fotoMobileRampeLage;
  private String fotoHubliftLage;
  private String fotoZuwegungVon;
  private String fotoZuwegungNach;
  private String fotoHaltepunkt1;
  private String fotoHaltepunkt2;
  private String fotoHaltepunkt3;
  private String fotoHaltepunkt4;
  private String fotoAbschnitt1;
  private String fotoAbschnitt2;
  private String fotoAbschnitt3;
  private String fotoAbschnitt4;
  private String fotoAbschnitt5;
  private String fotoAbschnitt6;
  private String fotoAbschnitt7;
  private String fotoAbschnitt8;

  public HaltesteigObject(String[] valueString) {
    String[] newValueString = Arrays.copyOf(valueString, 106);
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
    this.sitzplaetzeSumme = convertToInt(valueString[30]);
    this.abfallbehaelter = convertToBool(valueString[31]);
    this.uhr = convertToBool(valueString[32]);
    this.fahrzielanzeiger = convertToBool(valueString[35]);
    this.fahrzielanzeigerAkustisch = convertToBool(valueString[36]);
    this.fahrkartenautomat = convertToBool(valueString[37]);
    this.fahrkartenautomatId = valueString[38];
    this.posFahrkartenautomat =
        new double[] {convertToDouble(valueString[40]), convertToDouble(valueString[39])};
    this.fahrgastinfoart = valueString[41];
    this.fahrgastinfoKorrekteHoehe = valueString[42];
    this.fahrgastinfoBarrierefrei = valueString[43];
    this.ansagenVorhanden = convertToBool(valueString[44]);
    this.infoNotrufSaeule = valueString[45];
    this.mobileRampe = convertToBool(valueString[46]);
    this.mobileRampeLaengeCm = convertToInt(valueString[47]);
    this.mobileRampeTragfaehigkeitKg = convertToInt(valueString[48]);
    this.hublift = convertToBool(valueString[49]);
    this.hubliftStellflaecheCm = convertToInt(valueString[50]);
    this.hubliftTragfaehigkeitKg = convertToInt(valueString[51]);
    this.posHaltepunkt1 =
        new double[] {convertToDouble(valueString[53]), convertToDouble(valueString[52])};
    this.posHaltepunkt2 =
        new double[] {convertToDouble(valueString[55]), convertToDouble(valueString[54])};
    this.posHaltepunkt3 =
        new double[] {convertToDouble(valueString[57]), convertToDouble(valueString[56])};
    this.posHaltepunkt4 =
        new double[] {convertToDouble(valueString[59]), convertToDouble(valueString[58])};
    this.posAbschnitt1 =
        new double[] {convertToDouble(valueString[61]), convertToDouble(valueString[60])};
    this.posAbschnitt2 =
        new double[] {convertToDouble(valueString[63]), convertToDouble(valueString[62])};
    this.posAbschnitt3 =
        new double[] {convertToDouble(valueString[65]), convertToDouble(valueString[64])};
    this.posAbschnitt4 =
        new double[] {convertToDouble(valueString[67]), convertToDouble(valueString[66])};
    this.posAbschnitt5 =
        new double[] {convertToDouble(valueString[69]), convertToDouble(valueString[68])};
    this.posAbschnitt6 =
        new double[] {convertToDouble(valueString[71]), convertToDouble(valueString[70])};
    this.posAbschnitt7 =
        new double[] {convertToDouble(valueString[73]), convertToDouble(valueString[72])};
    this.posAbschnitt8 =
        new double[] {convertToDouble(valueString[75]), convertToDouble(valueString[74])};
    this.fotoSteig = convertToNull(valueString[76]);
    this.fotoSteig2 = convertToNull(valueString[77]);
    this.fotoSteigGegenueber = convertToNull(valueString[78]);
    this.fotoHochboardartSonstiges = convertToNull(valueString[79]);
    this.fotoSteigbreite = convertToNull(valueString[80]);
    this.fotoSteigbreiteEngstelle = convertToNull(valueString[81]);
    this.fotoBodenindikatorenEinstiegsbereich = convertToNull(valueString[82]);
    this.fotoBodenindikatorenLeitstreifen = convertToNull(valueString[83]);
    this.fotoBodenindikatorenAuffindestreifen = convertToNull(valueString[84]);
    this.fotoUnterstand = convertToNull(valueString[85]);
    this.fotoUhr = convertToNull(valueString[86]);
    this.fotoHaltesteigmast = convertToNull(valueString[87]);
    this.fotoFahrgastinfoNichtBarrierefrei = convertToNull(valueString[88]);
    this.fotoInfoNotrufsaeule = convertToNull(valueString[89]);
    this.fotoMobileRampeLage = convertToNull(valueString[90]);
    this.fotoHubliftLage = convertToNull(valueString[91]);
    this.fotoZuwegungVon = convertToNull(valueString[92]);
    this.fotoZuwegungNach = convertToNull(valueString[93]);
    this.fotoHaltepunkt1 = convertToNull(valueString[94]);
    this.fotoHaltepunkt2 = convertToNull(valueString[95]);
    this.fotoHaltepunkt3 = convertToNull(valueString[96]);
    this.fotoHaltepunkt4 = convertToNull(valueString[97]);
    this.fotoAbschnitt1 = convertToNull(valueString[98]);
    this.fotoAbschnitt2 = convertToNull(valueString[99]);
    this.fotoAbschnitt3 = convertToNull(valueString[100]);
    this.fotoAbschnitt4 = convertToNull(valueString[101]);
    this.fotoAbschnitt5 = convertToNull(valueString[102]);
    this.fotoAbschnitt6 = convertToNull(valueString[103]);
    this.fotoAbschnitt7 = convertToNull(valueString[104]);
    this.fotoAbschnitt8 = convertToNull(valueString[105]);
  }

  public String getDescription() {
    return Objects.requireNonNullElseGet(this.steig_Name, this::createHaltesteigName);
  }

  private String createHaltesteigName() {
    String[] idStringArray = super.getID().split(":");
    if (idStringArray[4] != null) {
      return "Haltesteig: " + idStringArray[4];
    } else return "Haltesteig: ?";
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
    info.add(new InfoObject("Unterstand Wände bodennahn", boolToString(unterstandWaendeBodennah)));
    info.add(new InfoObject("Sitzplätze Summe", "" + sitzplaetzeSumme));
    info.add(new InfoObject("Abfallbehälter", boolToString(abfallbehaelter)));
    info.add(new InfoObject("Uhr", boolToString(uhr)));
    info.add(new InfoObject("Fahrzielanzeiger", boolToString(fahrzielanzeiger)));
    info.add(new InfoObject("Fahrzielanzeiger akustisch", boolToString(fahrzielanzeigerAkustisch)));
    info.add(new InfoObject("Fahrkartenautomat", boolToString(fahrkartenautomat)));
    info.add(new InfoObject("Fahrkartenautomat ID", fahrkartenautomatId));
    info.add(
        new InfoObject("Position Fahrkartenautomat", convertToPosString(posFahrkartenautomat)));
    info.add(new InfoObject("Fahrgastinfoart", fahrgastinfoart));
    info.add(new InfoObject("Fahrgastinfo korrekte Höhe", fahrgastinfoKorrekteHoehe));
    info.add(new InfoObject("Fahrgastinfo barrierefrei", fahrgastinfoBarrierefrei));
    info.add(new InfoObject("Ansagen vorhanden", boolToString(ansagenVorhanden)));
    info.add(new InfoObject("Info/Notrufsäule", infoNotrufSaeule));
    info.add(new InfoObject("Mobile Rampe vorhanden", boolToString(mobileRampe)));
    info.add(new InfoObject("Mobile Rampe Länge in cm", "" + mobileRampeLaengeCm));
    info.add(new InfoObject("Mobile Rampe Tragfähigkeit kg", "" + mobileRampeTragfaehigkeitKg));
    info.add(new InfoObject("Hublift vorhanden", boolToString(hublift)));
    info.add(new InfoObject("Hublift Stellfläche in cm", "" + hubliftStellflaecheCm));
    info.add(new InfoObject("Hublift Tragfähigkeit kg", "" + hubliftTragfaehigkeitKg));
    info.add(new InfoObject("Position Haltepunkt 1", convertToPosString(posHaltepunkt1)));
    info.add(new InfoObject("Position Haltepunkt 2", convertToPosString(posHaltepunkt2)));
    info.add(new InfoObject("Position Haltepunkt 3", convertToPosString(posHaltepunkt3)));
    info.add(new InfoObject("Position Haltepunkt 4", convertToPosString(posHaltepunkt4)));
    info.add(new InfoObject("Position Abschnitt 1", convertToPosString(posAbschnitt1)));
    info.add(new InfoObject("Position Abschnitt 2", convertToPosString(posAbschnitt2)));
    info.add(new InfoObject("Position Abschnitt 3", convertToPosString(posAbschnitt3)));
    info.add(new InfoObject("Position Abschnitt 4", convertToPosString(posAbschnitt4)));
    info.add(new InfoObject("Position Abschnitt 5", convertToPosString(posAbschnitt5)));
    info.add(new InfoObject("Position Abschnitt 6", convertToPosString(posAbschnitt6)));
    info.add(new InfoObject("Position Abschnitt 7", convertToPosString(posAbschnitt7)));
    info.add(new InfoObject("Position Abschnitt 8", convertToPosString(posAbschnitt8)));
    return info;
  }

  public ObservableList<LinkObject> getLink() {
    ObservableList<LinkObject> link = FXCollections.observableArrayList();

    link.add(new LinkObject("Haltesteigposition OpenStreetMaps", getPosLink(getPos())));
    link.add(
        new LinkObject(
            "Position Fahrkartenautomat OpenStreetMaps", getPosLink(posFahrkartenautomat)));
    link.add(new LinkObject("Foto Bahnsteig Richtung 1", fotoSteig));
    link.add(new LinkObject("Foto Bahnsteig Richtung 2", fotoSteig2));
    link.add(new LinkObject("Foto von Steig Gegenüber", fotoSteigGegenueber));
    link.add(new LinkObject("Foto Hochboardart sonstiges", fotoHochboardartSonstiges));
    link.add(new LinkObject("Foto Steigbreite", fotoSteigbreite));
    link.add(new LinkObject("Foto Steigbreite Engstelle", fotoSteigbreiteEngstelle));
    link.add(
        new LinkObject(
            "Foto Bodenindikatoren Einstiegsbereich", fotoBodenindikatorenEinstiegsbereich));
    link.add(
        new LinkObject("Foto Bodenindikatoren Leitstreifen", fotoBodenindikatorenLeitstreifen));
    link.add(
        new LinkObject(
            "Foto Bodenindikatoren Auffindestreifen", fotoBodenindikatorenAuffindestreifen));
    link.add(new LinkObject("Foto Unterstand", fotoUnterstand));
    link.add(new LinkObject("Foto Uhr", fotoUhr));
    link.add(new LinkObject("Foto Haltesteigmast", fotoHaltesteigmast));
    link.add(
        new LinkObject("Foto Fahrgastinfo nicht barrierefrei", fotoFahrgastinfoNichtBarrierefrei));
    link.add(new LinkObject("Foto Info/Notrufsäule", fotoInfoNotrufsaeule));
    link.add(new LinkObject("Foto Mobile Rampe", fotoMobileRampeLage));
    link.add(new LinkObject("Foto Hublift", fotoHubliftLage));
    link.add(new LinkObject("Foto Zuwegung von", fotoZuwegungVon));
    link.add(new LinkObject("Foto Zuwegung nach", fotoZuwegungNach));
    link.add(new LinkObject("Foto Haltepunkt 1", fotoHaltepunkt1));
    link.add(new LinkObject("Position Haltepunkt 1", getPosLink(posHaltepunkt1)));
    link.add(new LinkObject("Foto Haltepunkt 2", fotoHaltepunkt2));
    link.add(new LinkObject("Position Haltepunkt 2", getPosLink(posHaltepunkt2)));
    link.add(new LinkObject("Foto Haltepunkt 3", fotoHaltepunkt3));
    link.add(new LinkObject("Position Haltepunkt 3", getPosLink(posHaltepunkt3)));
    link.add(new LinkObject("Foto Haltepunkt 4", fotoHaltepunkt4));
    link.add(new LinkObject("Position Haltepunkt 4", getPosLink(posHaltepunkt4)));
    link.add(new LinkObject("Foto Abschnitt 1", fotoAbschnitt1));
    link.add(new LinkObject("Position Abschnitt 1", getPosLink(posAbschnitt1)));
    link.add(new LinkObject("Foto Abschnitt 2", fotoAbschnitt2));
    link.add(new LinkObject("Position Abschnitt 2", getPosLink(posAbschnitt2)));
    link.add(new LinkObject("Foto Abschnitt 3", fotoAbschnitt3));
    link.add(new LinkObject("Position Abschnitt 3", getPosLink(posAbschnitt3)));
    link.add(new LinkObject("Foto Abschnitt 4", fotoAbschnitt4));
    link.add(new LinkObject("Position Abschnitt 4", getPosLink(posAbschnitt4)));
    link.add(new LinkObject("Foto Abschnitt 5", fotoAbschnitt5));
    link.add(new LinkObject("Position Abschnitt 5", getPosLink(posAbschnitt5)));
    link.add(new LinkObject("Foto Abschnitt 6", fotoAbschnitt6));
    link.add(new LinkObject("Position Abschnitt 6", getPosLink(posAbschnitt6)));
    link.add(new LinkObject("Foto Abschnitt 7", fotoAbschnitt7));
    link.add(new LinkObject("Position Abschnitt 7", getPosLink(posAbschnitt7)));
    link.add(new LinkObject("Foto Abschnitt 8", fotoAbschnitt8));
    link.add(new LinkObject("Position Abschnitt 8", getPosLink(posAbschnitt8)));
    return link;
  }
}
