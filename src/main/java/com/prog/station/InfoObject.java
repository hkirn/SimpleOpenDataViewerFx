package com.prog.station;

public class InfoObject {

  private String infoType;
  private String info;

  public InfoObject(String infoType, String info) {
    this.infoType = infoType;
    this.info = info;
  }

  public String getInfoType() {
    return infoType;
  }

  public String getInfo() {
    return info;
  }
}
