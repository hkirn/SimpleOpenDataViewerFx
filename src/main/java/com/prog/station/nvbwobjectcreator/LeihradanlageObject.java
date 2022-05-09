package com.prog.station.nvbwobjectcreator;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class LeihradanlageObject extends ObjectTemplate {
  private String anlageArt;
  private String notizen;
  private String foto;

  public LeihradanlageObject(String[] valueString) {
    String[] newValueString = Arrays.copyOf(valueString, 12);
    setSameVariables(newValueString);
    setSameVariablesWithOffset(newValueString, 0);
    setVariables(newValueString);
    //System.out.println(this + "angelegt");
  }

  private void setVariables(String[] valueString) {
    this.anlageArt = convertToNull(valueString[9]);
    this.notizen = convertToNull(valueString[10]);
    this.foto = convertToNull(valueString[11]);
    this.fotoToShow = this.foto;
  }

  public ObservableList<InfoObject> getInfo() {
    ObservableList<InfoObject> info = getInfoTemplate();
    info.add(new InfoObject("Art der Anlage", this.anlageArt));
    info.add(new InfoObject("Notizen", this.notizen));
    return info;
  }

  public ObservableList<LinkObject> getLink() {
    ObservableList<LinkObject> link = FXCollections.observableArrayList();
    link.add(new LinkObject("Objektposition OpenStreetMaps", getPosLink(getPos())));
    link.add(new LinkObject("Foto", this.foto));
    return link;
  }

  public String getDescription() {
    return notizen;
  }
}
