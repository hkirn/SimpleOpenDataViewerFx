package com.prog.station;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HaltesteigDataAdder {
  StationManager stationManager;
  ArrayList<HaltestelleObject> haltestelleObjectArrayList;

  public HaltesteigDataAdder(StationManager manager, ArrayList<HaltestelleObject> haltestelleObjectArrayList){
    this.haltestelleObjectArrayList = haltestelleObjectArrayList;
    this.stationManager = manager;
  }
  public void addInformation() {

    boolean firstLine = true;

    try (InputStream inputStream = this.getClass().getResourceAsStream("/haltestellen-2.csv");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(inputStreamReader); ) {

      String line;
      while ((line = br.readLine()) != null) {
        if (firstLine) {
          System.out.println("first Line - ignored");
          firstLine = false;
        } else {
          String[] values = line.split(";");
          searchAndAdd(values[6],values[0],values[1]);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void searchAndAdd(String id, String district, String town){

    try{
    HaltestelleObject haltestelleObject = stationManager.searchById(id);
    haltestelleObject.setDistrict(district);
    haltestelleObject.setTown(town);
    }

    catch (Exception e) {
      e.printStackTrace();
    }

  }
}
