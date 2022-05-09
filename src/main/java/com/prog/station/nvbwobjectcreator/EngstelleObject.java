package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class EngstelleObject extends ObjectTemplate {
  private int durchgangsbreiteCm;
  private int bewegungsflaecheCm;
  private String fotoEngstelle;
  private String fotoWegEngstelle1;
  private String fotoWegEngstelle2;

  public EngstelleObject(String[] valueString) {
    String[] newValueString = Arrays.copyOf(valueString, 14);
    setSameVariables(newValueString);
    setSameVariablesWithOffset(newValueString, 0);
    setVariables(newValueString);
    //System.out.println(this + "angelegt");
  }

  private void setVariables(String[] valueString) {
    durchgangsbreiteCm = convertToInt(valueString[9]);
    bewegungsflaecheCm = convertToInt(valueString[10]);
    fotoEngstelle = convertToNull(valueString[11]);
    fotoWegEngstelle1 = convertToNull(valueString[12]);
    fotoWegEngstelle2 = convertToNull(valueString[13]);
    this.fotoToShow = this.fotoEngstelle;
  }

  public ObservableList<InfoObject> getInfo() {
    ObservableList<InfoObject> info = getInfoTemplate();
    info.add(new InfoObject("Durchgangsbreite cm", "" + durchgangsbreiteCm));
    info.add(new InfoObject("Bewegungsfläche cm", "" + bewegungsflaecheCm));
    return info;
  }

  public ObservableList<LinkObject> getLink() {
    ObservableList<LinkObject> link = FXCollections.observableArrayList();
    link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
    link.add(new LinkObject("Foto Engstelle", fotoEngstelle));
    link.add(new LinkObject("Foto Weg zur Engstelle 1", fotoWegEngstelle1));
    link.add(new LinkObject("Foto Weg zur Engstelle 2", fotoWegEngstelle2));
    return link;
  }

  public String getDescription() {
    return "keine Beschreibung verfügbar";
  }
}
