package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class FahrradanlageObject extends ObjectTemplate {
  private String anlagentyp;
  private int stellplatzzahl;
  private boolean ueberdacht;
  private boolean beleuchtet;
  private boolean kostenpflichtig;
  private String notizKostenpflichtig;
  private boolean wegZurAnlageAnfahrbar;
  private String notizen;
  private String fotoAnlage;
  private String fotoWegzurAnlage;
  private String fotoHindernissZufahrt;
  private String fotoBesonderheiten;

  public FahrradanlageObject(String[] valueString) {
    String[] newValueString = Arrays.copyOf(valueString, 21);
    setSameVariables(newValueString);
    setSameVariablesWithOffset(newValueString, 0);
    setVariables(newValueString);
    //System.out.println(this + "angelegt");
  }

  public String getDescription() {
    return anlagentyp;
  }

  private void setVariables(String[] valueString) {
    this.anlagentyp = convertToNull(valueString[9]);
    this.stellplatzzahl = convertToInt(valueString[10]);
    this.ueberdacht = convertToBool(valueString[11]);
    this.beleuchtet = convertToBool(valueString[12]);
    this.kostenpflichtig = convertToBool(valueString[13]);
    this.notizKostenpflichtig = convertToNull(valueString[14]);
    this.wegZurAnlageAnfahrbar = convertToBool(valueString[15]);
    this.notizen = convertToNull(valueString[16]);
    this.fotoAnlage = convertToNull(valueString[17]);
    this.fotoWegzurAnlage = convertToNull(valueString[18]);
    this.fotoHindernissZufahrt = convertToNull(valueString[19]);
    this.fotoBesonderheiten = convertToNull(valueString[20]);
    this.fotoToShow = this.fotoAnlage;
  }

  public ObservableList<InfoObject> getInfo() {
    ObservableList<InfoObject> info = getInfoTemplate();
    info.add(new InfoObject("Anzahl Stellplätze", "" + stellplatzzahl));
    info.add(new InfoObject("Anlagentyp", this.anlagentyp));
    info.add(new InfoObject("Überdacht", boolToString(ueberdacht)));
    info.add(new InfoObject("Beleuchtet", boolToString(beleuchtet)));
    info.add(new InfoObject("Kostenpflichtig", boolToString(kostenpflichtig)));
    info.add(new InfoObject("Notiz kostenpflichtig", notizKostenpflichtig));
    info.add(new InfoObject("Weg zu Anlage anfahrbar", boolToString(wegZurAnlageAnfahrbar)));
    info.add(new InfoObject("Notizen", notizen));
    return info;
  }

  public ObservableList<LinkObject> getLink() {
    ObservableList<LinkObject> link = FXCollections.observableArrayList();
    link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
    link.add(new LinkObject("Foto Anlage", fotoAnlage));
    link.add(new LinkObject("Weg zur Anlage", fotoWegzurAnlage));
    link.add(new LinkObject("Foto Hinderniss Zufahrt", fotoHindernissZufahrt));
    link.add(new LinkObject("Foto Besonderheiten", fotoBesonderheiten));
    return link;
  }
}
