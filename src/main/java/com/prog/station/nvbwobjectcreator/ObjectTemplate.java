package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static com.prog.station.nvbwobjectcreator.StationManager.pseudoIdCounter;

public class ObjectTemplate {
  private String ID;
  private String HST_DHID;
  private String HST_Name;
  private String Datenquelle;
  private String Datenstatus;
  private double Longitude;
  private double Latitude;
  private String Koordinatenquelle;
  private String OSM_ID;
  protected String fotoToShow;

  protected void setSameVariables(String[] valueString) {
    this.ID = convertToNull(valueString[0]);
    this.HST_DHID = convertToNull(valueString[1]);
    this.HST_Name = convertToNull(valueString[2]);
  }

  protected void overwriteIfHaltestelle(String[] valueString) {
    this.ID = convertToNull(valueString[0]);
  }

  protected void setSameVariablesWithOffset(String[] valueString, int offset) {
    this.Datenquelle = convertToNull(valueString[3 + offset]);
    this.Datenstatus = convertToNull(valueString[4 + offset]);
    if ((convertToNull(valueString[5 + offset]) == null)
        || (convertToNull(valueString[6 + offset]) == null)) {
      this.Longitude = 0;
      this.Latitude = 0;
    } else {
      this.Longitude = convertToDouble(valueString[5 + offset]);
      this.Latitude = convertToDouble(valueString[6 + offset]);
    }
    this.Koordinatenquelle = convertToNull(valueString[7 + offset]);
    this.OSM_ID = convertToNull(valueString[8 + offset]);
  }

  protected ObservableList<InfoObject> getInfoTemplate() {
    ObservableList<InfoObject> info = FXCollections.observableArrayList();
    info.add(new InfoObject("ID", this.ID));
    info.add(new InfoObject("Name", HST_Name));
    info.add(new InfoObject("Datenquelle", Datenquelle));
    info.add(new InfoObject("Datenstatus", Datenstatus));
    info.add(new InfoObject("GPS-Position", convertToPosString(getPos())));
    info.add(new InfoObject("Koordinatenquelle", Koordinatenquelle));
    info.add(new InfoObject("OSM-ID", OSM_ID));
    return info;
  }

  public String getID() {
    return this.ID;
  }

  public String getHST_ID() {
    return this.HST_DHID;
  }

  public String getHST_Name() {
    return this.HST_Name;
  }

  public double[] getPos() {
    return new double[] {this.Latitude, this.Longitude};
  }

  public String getFotoToShow() {
    if (fotoToShow != null) {
      return fotoToShow;
    } else return getPosLink(getPos());
  }

  protected String getPosLink(double[] pos) {
    if (pos[0] == 0) {
      return null;
    } else {
      double posOffset = 0.001;
      return "https://www.openstreetmap.org/export/embed.html?bbox="
          + (pos[1] - posOffset)
          + ","
          + (pos[0] - posOffset)
          + ","
          + (pos[1] + posOffset)
          + ","
          + (pos[0] + posOffset)
          + "&layer=mapnik&marker="
          + pos[0]
          + ","
          + pos[1];
    }
  }

  protected boolean convertToBool(String stringToCovert) {
    return (stringToCovert.equals("ja")) || stringToCovert.equals("true");
  }

  protected String convertToNull(String stringToConvert) {
    if ((stringToConvert == null) || (stringToConvert.trim().equals(""))) {
      return null;
    } else {
      return stringToConvert;
    }
  }

  protected String boolToString(Boolean boolToConvert) {
    if (boolToConvert) {
      return "Ja";
    } else {
      return "Nein";
    }
  }

  protected double convertToDouble(String toConvert) {
    if (convertToNull(toConvert) == null) {
      return 0;
    } else return Double.parseDouble(toConvert.replace(",", "."));
  }

  protected int convertToInt(String toConvert) {
    return (int) convertToDouble(toConvert);
  }

  protected String convertToPosString(double[] pos) {
    if (pos[0] == 0) {
      return null;
    } else return pos[0] + " : " + pos[1];
  }

  protected String[] getIdAsArray(String id) {
    String[] idStringArray = id.split(":");
    return idStringArray;
  }

  protected boolean isIdArrayStringValid(String[] idArrayToCheck) {
    if (idArrayToCheck.length < 5) {
      //System.out.println("zu kurz...");
      return false;
    }
    int tempId = 9999;
    try {
      tempId = Integer.parseInt(idArrayToCheck[4]);
    } catch (NumberFormatException e) {
      return true;
    }
    return tempId < 1000;
  }

  protected void fixIdIfWrong() {
    if (isIdArrayStringValid(getIdAsArray(this.ID)) == false) {
      String fixedId = this.ID + ":0:" + pseudoIdCounter;
      pseudoIdCounter++;
      this.ID = fixedId;
    }
  }
}
