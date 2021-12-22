package com.prog.station;

public class LinkObject {

  private String bezeichnung;
  private String link;

  public LinkObject(String bezeichnung, String link) {
    this.bezeichnung = bezeichnung;
    this.link = link;
  }


  public String getBezeichnung() {
    return bezeichnung;
  }

  public String getLink() {
    return link;
  }
}
