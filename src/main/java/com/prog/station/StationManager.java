package com.prog.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StationManager {

  private ArrayList<HaltestelleObject> haltestelleList = new ArrayList<>();

  public StationManager() {
    createHaltestellen(
        readCsv(
            "https://www.nvbw.de/fileadmin/user_upload/service/open_data/haltestellen/SPNV/BFRK_Haltestelle.csv"));
  }

  public HaltestelleObject searchById(String id) {
    for (HaltestelleObject haltestelleObject : haltestelleList) {
      if (haltestelleObject.getID().equals(id)) {
        System.out.println("Haltestelle found");
        printObject(haltestelleObject);
        return haltestelleObject;
      }
    }
    throw new NoSuchElementException("Haltestelle: " + id + " not found");
  }

  private void createHaltestellen(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      HaltestelleObject haltestelleObject = new HaltestelleObject(valueString);
      haltestelleList.add(haltestelleObject);
    }
  }

  public ObservableList<InfoObject> getHaltestelleList() {
    ObservableList<InfoObject> info = FXCollections.observableArrayList();
    for (HaltestelleObject haltestelleObject: this.haltestelleList){
      info.add(new InfoObject(haltestelleObject.getID(), haltestelleObject.getHST_Name()));
    }
    return info;
  }

  private ArrayList<String[]> readCsv(String url) {
    ArrayList<String[]> listToReturn = new ArrayList<>();
    Boolean firstLine = true;
    URLConnection nvbwConnect = null;
    try {
      URL nvbw = new URL(url);
      nvbwConnect = nvbw.openConnection();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try (BufferedReader br =
        new BufferedReader(new InputStreamReader(nvbwConnect.getInputStream()))) {
      String line;
      while ((line = br.readLine()) != null) {
        if (firstLine) {
          System.out.println("first Line - ignored");
          firstLine = false;
        } else {
          String[] values = line.split(";");
          listToReturn.add(values);
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return listToReturn;
  }

  private void printObject(HaltestelleObject haltestelleObject) {
    System.out.println("ID: " + haltestelleObject.getID());
    System.out.println("HST_Name: " + haltestelleObject.getHST_Name());
    System.out.println("Datenquelle: " + haltestelleObject.getDatenquelle());
    System.out.println("Datenstatus: " + haltestelleObject.getDatenstatus());
    System.out.println(
        "GPS-Pos: " + haltestelleObject.getPos()[0] + " " + haltestelleObject.getPos()[1]);
    System.out.println("Koordinatenquelle: " + haltestelleObject.getKoordinatenquelle());
    System.out.println("OSM_ID: " + haltestelleObject.getOSM_ID());
    System.out.println("Sitzplätze: " + haltestelleObject.isSitzplaetze());
    System.out.println("Unterstand: " + haltestelleObject.isUnterstand());
    System.out.println(
        "Rollstuhlflaeche Unterstand: " + haltestelleObject.isRollstuhlflaecheImUnterstand());
    System.out.println("Fahrplananzeigetafel: " + haltestelleObject.isFahrplananzeigetafel());
    System.out.println(
        "Fahrplananzeigetafel akustisch: " + haltestelleObject.isFahrplananzeigetafel_akustisch());
    System.out.println("Ansagen vorhanden: " + haltestelleObject.isAnsagen_vorhanden());
    System.out.println("Defibrillator vorhanden: " + haltestelleObject.isDefibrillator());
    System.out.println(
        "Defibrillator Lage: " + haltestelleObject.getDefibrilator_Lagebeschreibung());
    System.out.println("Gepäckaufbewahrung: " + haltestelleObject.isGepaeckaufbewahrung());
    System.out.println("Gepäcktransport: " + haltestelleObject.isGepaeckaufbewahrung());
    System.out.println("InduktiveHöranlage: " + haltestelleObject.isInduktiveHoeranlage());
    System.out.println(
        "InduktiveHöranlageStandort: " + haltestelleObject.getInduktiveHoeranlageStandort());
    System.out.println("Info Notrufsäule: " + haltestelleObject.getInfoNotrufsaeule());
    System.out.println("Bahnhofsmission: " + haltestelleObject.isBahnhofsmission());
    System.out.println("HaltestelleTotale_Foto: " + haltestelleObject.getHaltestelleTotale_Foto());
    System.out.println(
        "SitzeOderUnterstand_Foto: " + haltestelleObject.getSitzeOderUnterstand_Foto());
    System.out.println(
        "SitzeOderUnterstandUmgebung_Foto: "
            + haltestelleObject.getSitzeOderUnterstandUmgebung_Foto());
    System.out.println(
        "Fahrplananzeigetafel_Foto_ " + haltestelleObject.getFahrplananzeigetafel_Foto());
    System.out.println("Defibrillator_Foto: " + haltestelleObject.getDefibrillator_Foto());
    System.out.println(
        "Gepaeckaufbewahrung_Foto: " + haltestelleObject.getGepaeckaufbewahrung_Foto());
    System.out.println("InfoNotrufsaeule_Foto: " + haltestelleObject.getInfoNotrufsaeule_Foto());
    System.out.println("Bahnhofsmision_Foto: " + haltestelleObject.getBahnhofsmision_Foto());
    System.out.println("BahnhofsmissionWeg_Foto " + haltestelleObject.getBahnhofsmissionWeg_Foto());
    System.out.println(
        "BahnhofsmissionOeffunungszeiten_Foto: "
            + haltestelleObject.getBahnhofsmissionOeffunungszeiten_Foto());
    System.out.println("WeitereBilder1_Foto: " + haltestelleObject.getWeitereBilder1_Foto());
    System.out.println("WeitereBilder2_Foto: " + haltestelleObject.getWeitereBilder2_Foto());
    System.out.println("WeitereBilder3_Foto: " + haltestelleObject.getWeitereBilder3_Foto());
  }
}
