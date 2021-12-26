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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StationManager {

  private ArrayList<HaltestelleObject> haltestelleList = new ArrayList<>();
  private ArrayList<HaltesteigObject> haltesteigList = new ArrayList<>();
  private ArrayList<AufzugObject> aufzugObjectList = new ArrayList<>();
  private ArrayList<EngstelleObject> engstelleObjectList = new ArrayList<>();

  public StationManager() {
    createHaltestellen(
        readCsv(
            "https://www.nvbw.de/fileadmin/user_upload/service/open_data/haltestellen/SPNV/BFRK_Haltestelle.csv"));
    createHaltesteig(
        readCsv(
            "https://www.nvbw.de/fileadmin/user_upload/service/open_data/haltestellen/SPNV/BFRK_Haltesteig.csv"));

    createAufzug(
        readCsv(
            "https://www.nvbw.de/fileadmin/user_upload/service/open_data/haltestellen/SPNV/BFRK_Aufzug.csv"));

    createEngstelle(
        readCsv(
            "https://www.nvbw.de/fileadmin/user_upload/service/open_data/haltestellen/SPNV/BFRK_Engstelle.csv"));
  }

  public HaltestelleObject searchById(String id) {
    for (HaltestelleObject haltestelleObject : haltestelleList) {
      if (haltestelleObject.getID().equals(id)) {
        System.out.println("Haltestelle found");
        return haltestelleObject;
      }
    }
    throw new NoSuchElementException("Haltestelle: " + id + " not found");
  }

  public HaltesteigObject searchHaltesteigById(String id) {
    for (HaltesteigObject haltesteigObject : haltesteigList) {
      if (haltesteigObject.getID().equals(id)) {
        return haltesteigObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public AufzugObject searchAufzugById(String id) {
    for (AufzugObject aufzugObject : aufzugObjectList) {
      if (aufzugObject.getID().equals(id)) {
        return aufzugObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public EngstelleObject searchEngstelleById(String id) {
    for (EngstelleObject engstelleObject : engstelleObjectList) {
      if (engstelleObject.getID().equals(id)) {
        return engstelleObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  private void createHaltestellen(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      HaltestelleObject haltestelleObject = new HaltestelleObject(valueString);
      haltestelleList.add(haltestelleObject);
    }
  }

  private void createHaltesteig(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      HaltesteigObject haltesteigObject = new HaltesteigObject(valueString);
      haltesteigList.add(haltesteigObject);
    }
  }

  private void createAufzug(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      AufzugObject aufzugObject = new AufzugObject(valueString);
      aufzugObjectList.add(aufzugObject);
    }
  }

  private void createEngstelle(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      EngstelleObject engstelleObject = new EngstelleObject(valueString);
      engstelleObjectList.add(engstelleObject);
    }
  }

  public ObservableList<InfoObject> getHaltestelleList() {
    ObservableList<InfoObject> info = FXCollections.observableArrayList();
    for (HaltestelleObject haltestelleObject : this.haltestelleList) {
      info.add(new InfoObject(haltestelleObject.getID(), haltestelleObject.getHST_Name()));
    }
    return info;
  }

  public ObservableList<InfoObject> getObjekteList(String dhid, String type) {
    ObservableList<InfoObject> info = FXCollections.observableArrayList();
    switch (type) {
      case "Haltesteig":
        for (HaltesteigObject haltesteigObject : this.haltesteigList) {
          if (haltesteigObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(haltesteigObject.getID(), haltesteigObject.getSteig_Name()));
          }
        }
        break;
      case "Aufzug":
        for (AufzugObject aufzugObject : this.aufzugObjectList) {
          if (aufzugObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(aufzugObject.getID(), aufzugObject.getVerbindungsfunktion()));
          }
        }
        break;

      case "Engstelle":
        for (EngstelleObject engstelleObject : this.engstelleObjectList) {
          if (engstelleObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(engstelleObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
        break;
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
        new BufferedReader(
            new InputStreamReader(nvbwConnect.getInputStream(), Charset.forName("UTF-8")))) {
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

  private InfoObject createInfoObject(String id, String text) {
    if (text != null) {
      return new InfoObject(id, text);
    } else {
      return new InfoObject(id, "Objektbezeichnung fehlt in Datensatz");
    }
  }
}
