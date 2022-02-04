package com.prog.station;

public class LinkObject {

  private final String bezeichnung;
  private final String link;

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
