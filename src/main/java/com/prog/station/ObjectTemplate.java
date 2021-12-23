package com.prog.station;

public class ObjectTemplate {
  protected String ID;
  protected String HST_ID;
  protected String HST_Name;
  protected String Datenquelle;
  protected String Datenstatus;
  protected double Longitude;
  protected double Latitude;
  protected String Koordinatenquelle;
  protected String OSM_ID;

  protected void setSameVariables(String[] valueString) {
    this.ID = convertToNull(valueString[0]);
    this.HST_ID = convertToNull(valueString[1]);
    this.HST_Name = convertToNull(valueString[2]);
  }

  protected void setSameVariablesNotHaltesteig(String[] valueString) {
    this.Datenquelle = convertToNull(valueString[3]);
    this.Datenstatus = convertToNull(valueString[4]);
    this.Longitude = Double.valueOf(valueString[5].replace(",", "."));
    this.Latitude = Double.valueOf(valueString[6].replace(",", "."));
    this.Koordinatenquelle = convertToNull(valueString[7]);
    this.OSM_ID = convertToNull(valueString[8]);
  }

  public String getID() {
    return this.ID;
  }

  public String getHST_ID() {
    return this.HST_ID;
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
}
