package com.prog.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObjectTemplate {
  protected String ID;
  protected String HST_DHID;
  protected String HST_Name;
  protected String Datenquelle;
  protected String Datenstatus;
  protected double Longitude;
  protected double Latitude;
  protected String Koordinatenquelle;
  protected String OSM_ID;

  protected void setSameVariables(String[] valueString) {
    this.ID = convertToNull(valueString[0]);
    this.HST_DHID = convertToNull(valueString[1]);
    this.HST_Name = convertToNull(valueString[2]);
  }

  protected void setSameVariablesWithOffset(String[] valueString, int offset) {
    this.Datenquelle = convertToNull(valueString[3+offset]);
    this.Datenstatus = convertToNull(valueString[4+offset]);
    if ((convertToNull(valueString[5+offset])==null)||(convertToNull(valueString[6+offset])==null)){
      this.Longitude = 0;
      this.Latitude = 0;
    }
    else{
      this.Longitude = convertToDouble(valueString[5+offset]);
      this.Latitude = convertToDouble(valueString[6+offset]);
    }
    this.Koordinatenquelle = convertToNull(valueString[7+offset]);
    this.OSM_ID = convertToNull(valueString[8+offset]);
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

  public String getDatenquelle() {
    return this.Datenquelle;
  }

  public String getDatenstatus() {
    return this.Datenstatus;
  }

  public double[] getPos() {
    double[] arr = {this.Latitude, this.Longitude};
    return arr;
  }

  public String getPosLink(double[] pos) {
    if (pos[0]==0){
      return null;
    }
    else {
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
        + pos[1];}
  }

  public String getKoordinatenquelle() {
    return Koordinatenquelle;
  }

  public String getOSM_ID() {
    return OSM_ID;
  }

  protected boolean convertToBool(String stringToCovert) {
    if (stringToCovert.equals("ja")) {
      return true;
    } else return false;
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

  protected double convertToDouble(String toConvert){
    if (convertToNull(toConvert)==null){
      return 0;
    }
    else return Double.valueOf(toConvert.replace(",", "."));
  }

  protected int convertToInt(String toConvert){
    return (int)convertToDouble(toConvert);
  }

  protected String convertToPosString(double[] pos){
    if (pos[0]==0){
      return null;
    }
    else return pos[0]+" : "+pos[1];
  }
}
