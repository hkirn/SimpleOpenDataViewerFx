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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class StationManager {

  private final ArrayList<HaltestelleObject> haltestelleList = new ArrayList<>();
  private final ArrayList<HaltesteigObject> haltesteigList = new ArrayList<>();
  private final ArrayList<AufzugObject> aufzugObjectList = new ArrayList<>();
  private final ArrayList<EngstelleObject> engstelleObjectList = new ArrayList<>();
  private final ArrayList<FahrkartenautomatObject> fahrkartenautomatObjects = new ArrayList<>();
  private final ArrayList<FahrradanlageObject> fahrradanlageObjects = new ArrayList<>();
  private final ArrayList<GleisquerungObject> gleisquerungObjects = new ArrayList<>();
  private final ArrayList<InformationsstelleObject> informationsstelleObjects = new ArrayList<>();
  private final ArrayList<LeihradanlageObject> leihradanlageObjects = new ArrayList<>();
  private final ArrayList<ParkplatzObject> parkplatzObjects = new ArrayList<>();
  private final ArrayList<RampeObject> rampeObjects = new ArrayList<>();
  private final ArrayList<RolltreppeObject> rolltreppeObjects = new ArrayList<>();
  private final ArrayList<StationsplanObject> stationsplanObjects = new ArrayList<>();
  private final ArrayList<TaxiObject> taxiObjects = new ArrayList<>();
  private final ArrayList<ToiletteObject> toiletteObjects = new ArrayList<>();
  private final ArrayList<TreppeObject> treppeObjects = new ArrayList<>();
  private final ArrayList<TuerObject> tuerObjects = new ArrayList<>();
  private final ArrayList<VerkaufsstelleObject> verkaufsstelleObjects = new ArrayList<>();
  private final ArrayList<WegObject> wegObjects = new ArrayList<>();
  private final String urlNvbw = "https://www.nvbw.de/fileadmin/user_upload/service/open_data/haltestellen/SPNV/";

  public StationManager() {
    createHaltestellen(readCsv(urlNvbw + "BFRK_Haltestelle.csv"));
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

  public FahrkartenautomatObject searchFahrkartenautomatById(String id) {
    for (FahrkartenautomatObject foundObject : fahrkartenautomatObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public FahrradanlageObject searchFahrradanlageById(String id) {
    for (FahrradanlageObject foundObject : fahrradanlageObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public GleisquerungObject searchGleisquerungById(String id) {
    for (GleisquerungObject foundObject : gleisquerungObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public InformationsstelleObject searchInformationsstelleById(String id) {
    for (InformationsstelleObject foundObject : informationsstelleObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public LeihradanlageObject searchLeihradanlageById(String id) {
    for (LeihradanlageObject foundObject : leihradanlageObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public ParkplatzObject searchParkplatzById(String id) {
    for (ParkplatzObject foundObject : parkplatzObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public RampeObject searchRampeById(String id) {
    for (RampeObject foundObject : rampeObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public RolltreppeObject searchRolltreppeById(String id) {
    for (RolltreppeObject foundObject : rolltreppeObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public StationsplanObject searchStationsplanById(String id) {
    for (StationsplanObject foundObject : stationsplanObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public TaxiObject searchTaxiById(String id) {
    for (TaxiObject foundObject : taxiObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public ToiletteObject searchToiletteById(String id) {
    for (ToiletteObject foundObject : toiletteObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public TreppeObject searchTreppeById(String id) {
    for (TreppeObject foundObject : treppeObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public TuerObject searchTuerById(String id) {
    for (TuerObject foundObject : tuerObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public VerkaufsstelleObject searchVerkaufsstelleById(String id) {
    for (VerkaufsstelleObject foundObject : verkaufsstelleObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  public WegObject searchWegById(String id) {
    for (WegObject foundObject : wegObjects) {
      if (foundObject.getID().equals(id)) {
        return foundObject;
      }
    }
    throw new NoSuchElementException("Object: " + id + "not found");
  }

  private void createHaltestellen(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      HaltestelleObject haltestelleObject = new HaltestelleObject(valueString);
      this.haltestelleList.add(haltestelleObject);
    }
  }

  private void createHaltesteig(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      HaltesteigObject haltesteigObject = new HaltesteigObject(valueString);
      this.haltesteigList.add(haltesteigObject);
    }
  }

  private void createAufzug(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      AufzugObject aufzugObject = new AufzugObject(valueString);
      this.aufzugObjectList.add(aufzugObject);
    }
  }

  private void createEngstelle(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      EngstelleObject engstelleObject = new EngstelleObject(valueString);
      this.engstelleObjectList.add(engstelleObject);
    }
  }

  private void createFahrkartenautomat(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      FahrkartenautomatObject createdObject = new FahrkartenautomatObject(valueString);
      this.fahrkartenautomatObjects.add(createdObject);
    }
  }

  private void createFahrradanlage(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      FahrradanlageObject createdObject = new FahrradanlageObject(valueString);
      this.fahrradanlageObjects.add(createdObject);
    }
  }

  private void createGleisquerung(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      GleisquerungObject createdObject = new GleisquerungObject(valueString);
      this.gleisquerungObjects.add(createdObject);
    }
  }

  private void createInformationsstelle(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      InformationsstelleObject createdObject = new InformationsstelleObject(valueString);
      this.informationsstelleObjects.add(createdObject);
    }
  }

  private void createLeihradanlage(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      LeihradanlageObject createdObject = new LeihradanlageObject(valueString);
      this.leihradanlageObjects.add(createdObject);
    }
  }

  private void createParkplatz(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      ParkplatzObject createdObject = new ParkplatzObject(valueString);
      this.parkplatzObjects.add(createdObject);
    }
  }

  private void createRampe(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      RampeObject createdObject = new RampeObject(valueString);
      this.rampeObjects.add(createdObject);
    }
  }

  private void createRollteppe(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      RolltreppeObject createdObject = new RolltreppeObject(valueString);
      this.rolltreppeObjects.add(createdObject);
    }
  }

  private void createStationsplan(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      StationsplanObject createdObject = new StationsplanObject(valueString);
      this.stationsplanObjects.add(createdObject);
    }
  }

  private void createTaxi(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      TaxiObject createdObject = new TaxiObject(valueString);
      this.taxiObjects.add(createdObject);
    }
  }

  private void createToilette(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      ToiletteObject createdObject = new ToiletteObject(valueString);
      this.toiletteObjects.add(createdObject);
    }
  }

  private void createTreppe(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      TreppeObject createdObject = new TreppeObject(valueString);
      this.treppeObjects.add(createdObject);
    }
  }

  private void createTuer(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      TuerObject createdObject = new TuerObject(valueString);
      this.tuerObjects.add(createdObject);
    }
  }

  private void createVerkaufsstelle(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      VerkaufsstelleObject createdObject = new VerkaufsstelleObject(valueString);
      this.verkaufsstelleObjects.add(createdObject);
    }
  }

  private void createWeg(ArrayList<String[]> list) {
    for (String[] valueString : list) {
      WegObject createdObject = new WegObject(valueString);
      this.wegObjects.add(createdObject);
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
      case "Haltesteig" -> {
        if (haltesteigList.isEmpty()) {
          createHaltesteig(readCsv(urlNvbw + "BFRK_Haltesteig.csv"));
        }
        for (HaltesteigObject haltesteigObject : this.haltesteigList) {
          if (haltesteigObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(haltesteigObject.getID(), haltesteigObject.getSteig_Name()));
          }
        }
      }
      case "Aufzug" -> {
        if (aufzugObjectList.isEmpty()) {
          createAufzug(readCsv(urlNvbw + "BFRK_Aufzug.csv"));
        }
        for (AufzugObject aufzugObject : this.aufzugObjectList) {
          if (aufzugObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(aufzugObject.getID(), aufzugObject.getVerbindungsfunktion()));
          }
        }
      }
      case "Engstelle" -> {
        if (engstelleObjectList.isEmpty()) {
          createEngstelle(readCsv(urlNvbw + "BFRK_Engstelle.csv"));
        }
        for (EngstelleObject engstelleObject : this.engstelleObjectList) {
          if (engstelleObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(engstelleObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
      }
      case "Fahrkartenautomat" -> {
        if (fahrkartenautomatObjects.isEmpty()) {
          createFahrkartenautomat(readCsv(urlNvbw + "BFRK_Fahrkartenautomat.csv"));
        }
        for (FahrkartenautomatObject foundObject : this.fahrkartenautomatObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), foundObject.getKartenautomatenId()));
          }
        }
      }
      case "Fahrradanlage" -> {
        if (fahrradanlageObjects.isEmpty()) {
          createFahrradanlage(readCsv(urlNvbw + "BFRK_Fahrradanlage.csv"));
        }
        for (FahrradanlageObject foundObject : this.fahrradanlageObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), foundObject.getAnlagentyp()));
          }
        }
      }
      case "Gleisquerung" -> {
        if (gleisquerungObjects.isEmpty()) {
          createGleisquerung(readCsv(urlNvbw + "BFRK_Gleisquerung.csv"));
        }
        for (GleisquerungObject foundObject : this.gleisquerungObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), foundObject.getVerbindungsfunktion()));
          }
        }
      }
      case "Informationsstelle" -> {
        if (informationsstelleObjects.isEmpty()) {
          createInformationsstelle(readCsv(urlNvbw + "BFRK_Informationsstelle.csv"));
        }
        for (InformationsstelleObject foundObject : this.informationsstelleObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), foundObject.getInfostelleName()));
          }
        }
      }
      case "Leihradanlage" -> {
        if (leihradanlageObjects.isEmpty()) {
          createLeihradanlage(readCsv(urlNvbw + "BFRK_Leihradanlage.csv"));
        }
        for (LeihradanlageObject foundObject : this.leihradanlageObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), foundObject.getNotizen()));
          }
        }
      }
      case "Parkplatz" -> {
        if (parkplatzObjects.isEmpty()) {
          createParkplatz(readCsv(urlNvbw + "BFRK_Parkplatz.csv"));
        }
        for (ParkplatzObject foundObject : this.parkplatzObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
      }
      case "Rampe" -> {
        if (rampeObjects.isEmpty()) {
          createRampe(readCsv(urlNvbw + "BFRK_Rampe.csv"));
        }
        for (RampeObject foundObject : this.rampeObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
      }
      case "Rolltreppe" -> {
        if (rolltreppeObjects.isEmpty()) {
          createRollteppe(readCsv(urlNvbw + "BFRK_Rolltreppe.csv"));
        }
        for (RolltreppeObject foundObject : this.rolltreppeObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
      }
      case "Stationsplan" -> {
        if (stationsplanObjects.isEmpty()) {
          createStationsplan(readCsv(urlNvbw + "BFRK_Stationsplan.csv"));
        }
        for (StationsplanObject foundObject : this.stationsplanObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
      }
      case "Taxi" -> {
        if (taxiObjects.isEmpty()) {
          createTaxi(readCsv(urlNvbw + "BFRK_Taxi.csv"));
        }
        for (TaxiObject foundObject : this.taxiObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
      }
      case "Toilette" -> {
        if (toiletteObjects.isEmpty()) {
          createToilette(readCsv(urlNvbw + "BFRK_Toilette.csv"));
        }
        for (ToiletteObject foundObject : this.toiletteObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
      }
      case "Treppe" -> {
        if (treppeObjects.isEmpty()) {
          createTreppe(readCsv(urlNvbw + "BFRK_Treppe.csv"));
        }
        for (TreppeObject foundObject : this.treppeObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
      }
      case "Tuer" -> {
        if (tuerObjects.isEmpty()) {
          createTuer(readCsv(urlNvbw + "BFRK_Tuer.csv"));
        }
        for (TuerObject foundObject : this.tuerObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
      }
      case "Verkaufsstelle" -> {
        if (verkaufsstelleObjects.isEmpty()) {
          createVerkaufsstelle(readCsv(urlNvbw + "BFRK_Verkaufsstelle.csv"));
        }
        for (VerkaufsstelleObject foundObject : this.verkaufsstelleObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
      }
      case "Weg" -> {
        if (wegObjects.isEmpty()) {
          createWeg(readCsv(urlNvbw + "BFRK_Weg.csv"));
        }
        for (WegObject foundObject : this.wegObjects) {
          if (foundObject.getHST_ID().equals(dhid)) {
            info.add(createInfoObject(foundObject.getID(), "keine Beschreibung verfügbar"));
          }
        }
      }
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
    try {
      assert nvbwConnect != null;
      try (BufferedReader br =
          new BufferedReader(
              new InputStreamReader(nvbwConnect.getInputStream(), StandardCharsets.UTF_8))) {
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
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return listToReturn;
  }

  private InfoObject createInfoObject(String id, String text) {
    return new InfoObject(id, Objects.requireNonNullElse(text, "Objektbezeichnung fehlt in Datensatz"));
  }
}
