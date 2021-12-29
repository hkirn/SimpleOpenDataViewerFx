package com.prog.station;

public class InfoObject {

  private String infoType;
  private String info;
  private String extra1;
  private String extra2;

  public InfoObject(String infoType, String info) {
    this.infoType = infoType;
    this.info = info;
  }

  public InfoObject(String infoType, String info, String extra1, String extra2) {
    this.infoType = infoType;
    this.info = info;
    this.extra1 = extra1;
    this.extra2 = extra2;
  }
  public String getInfoType() {
    return infoType;
  }

  public String getInfo() {
    return info;
  }

  public String getExtra1() {
    return extra1;
  }

  public String getExtra2() {
    return extra2;
  }
}
