package com.prog.station;

public class Testclass {
  public static void main(String[] args) {
    System.out.println("Hello World");
    StationManager manager = new StationManager();
    manager.searchById("de:08118:1400");
  }
}
