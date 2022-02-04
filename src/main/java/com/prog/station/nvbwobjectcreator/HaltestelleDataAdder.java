package com.prog.station.nvbwobjectcreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HaltestelleDataAdder {
  ArrayList<HaltestelleObject> haltestelleObjectArrayList;
  ArrayList<String[]> dataset = new ArrayList<>();

  public HaltestelleDataAdder(ArrayList<HaltestelleObject> haltestelleObjectArrayList) {
    this.haltestelleObjectArrayList = haltestelleObjectArrayList;
    createList();
  }

  public void addInformation() {
    for (HaltestelleObject haltestelleObject : haltestelleObjectArrayList) {
      String[] found = searchData(haltestelleObject.getID());
      haltestelleObject.setTown(found[2]);
      haltestelleObject.setDistrict(found[1]);
    }
  }

  private void createList() {

    boolean firstLine = true;

    try (InputStream inputStream = this.getClass().getResourceAsStream("/haltestellen-2.csv");
        InputStreamReader inputStreamReader =
            new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(inputStreamReader)) {

      String line;
      while ((line = br.readLine()) != null) {
        if (firstLine) {
          System.out.println("first Line - ignored");
          firstLine = false;
        } else {
          String[] values = line.split(";");
          String[] arr = {values[6], values[0], values[1]};
          dataset.add(arr);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String[] searchData(String id) {
    for (String[] found : dataset) {
      if (id.equals(found[0])) {
        return found;
      }
    }
    String[] arr = {id, "", ""};
    return arr;
  }
}
