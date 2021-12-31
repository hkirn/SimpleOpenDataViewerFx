package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class RolltreppeObject extends ObjectTemplate {
  private String transportrichtung;
  private boolean wechselnd;
  private int laufzeit;
  private String verbindungsfunktion;
  private String fotoRolltreppe;
  private String fotoRolltreppeId;
  private String fotoRolltreppeRichtung1;
  private String fotoRolltreppeRichtung2;

  public RolltreppeObject(String[] valueString) {
    String[] newValueString = Arrays.copyOf(valueString, 17);
    setSameVariables(newValueString);
    setSameVariablesWithOffset(newValueString, 0);
    setVariables(newValueString);
    System.out.println(this + "angelegt");
  }

  private void setVariables(String[] valueString) {
    this.transportrichtung = convertToNull(valueString[9]);
    this.wechselnd = convertToBool(valueString[10]);
    this.laufzeit = convertToInt(valueString[11]);
    this.verbindungsfunktion = convertToNull(valueString[12]);
    this.fotoRolltreppe = convertToNull(valueString[13]);
    this.fotoRolltreppeId = convertToNull(valueString[14]);
    this.fotoRolltreppeRichtung1 = convertToNull(valueString[15]);
    this.fotoRolltreppeRichtung2 = convertToNull(valueString[16]);
  }

  public ObservableList<InfoObject> getInfo() {
    ObservableList<InfoObject> info = getInfoTemplate();
    info.add(new InfoObject("Transportrichtung", this.transportrichtung));
    info.add(new InfoObject("Laufrichtung kann wechseln", boolToString(this.wechselnd)));
    info.add(new InfoObject("Laufzeit in sec", ""+this.laufzeit));
    info.add(new InfoObject("Verbindungsfunktion", this.verbindungsfunktion));
    return info;
  }

  public ObservableList<LinkObject> getLink() {
    ObservableList<LinkObject> link = FXCollections.observableArrayList();
    link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
    link.add(new LinkObject("Foto Rolltreppe", this.fotoRolltreppe));
    link.add(new LinkObject("Foto ID Rolltreppe", this.fotoRolltreppeId));
    link.add(new LinkObject("Foto Rolltreppe Richtung 1", this.fotoRolltreppeRichtung1));
    link.add(new LinkObject("Foto Rolltreppe Richtung 2",this.fotoRolltreppeRichtung2));
    return link;
  }

  public String getDescription() {
    return verbindungsfunktion;
  }
}
