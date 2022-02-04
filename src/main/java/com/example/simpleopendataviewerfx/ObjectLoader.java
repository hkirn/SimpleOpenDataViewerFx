package com.example.simpleopendataviewerfx;

import com.prog.station.nvbwobjectcreator.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

public class ObjectLoader {
    private final HaltestelleController controller;
    private final StationManager manager;
    private final VBox vboxRight;
    private final Label lbl_hstName;
    private final WebView webView;

    public ObjectLoader(HaltestelleController controller, StationManager manager,
                        VBox vboxRight, Label lbl_hstName, WebView webView){
        this.controller = controller;
        this.manager = manager;
        this.vboxRight = vboxRight;
        this.lbl_hstName = lbl_hstName;
        this.webView = webView;
    }

    protected void loadObject(VBox infoDisplay, String id) {
        System.out.println("btnSelect pressed");
        controller.setAllButtonStateDisable(true);
        System.out.println(controller.activeObject);
        switch (controller.activeObject) {
            case "Haltesteig" -> refreshHaltesteig(infoDisplay, id);
            case "Aufzug" -> refreshAufzug(infoDisplay, id);
            case "Engstelle" -> refreshEngstelle(infoDisplay, id);
            case "Fahrkartenautomat" -> refreshFahrkartenautomat(infoDisplay, id);
            case "Fahrradanlage" -> refreshFahrradanlage(infoDisplay, id);
            case "Gleisquerung" -> refreshGleisquerung(infoDisplay, id);
            case "Informationsstelle" -> refreshInformationsstelle(infoDisplay, id);
            case "Leihradanlage" -> refreshLeihradanlage(infoDisplay, id);
            case "Parkplatz" -> refreshParkplatz(infoDisplay, id);
            case "Rampe" -> refreshRampe(infoDisplay, id);
            case "Rolltreppe" -> refreshRolltreppe(infoDisplay, id);
            case "Stationsplan" -> refreshStationsplan(infoDisplay, id);
            case "Taxi" -> refreshTaxi(infoDisplay, id);
            case "Toilette" -> refreshToilette(infoDisplay, id);
            case "Treppe" -> refreshTreppe(infoDisplay, id);
            case "Tuer" -> refreshTuer(infoDisplay, id);
            case "Verkaufsstelle" -> refreshVerkaufsstelle(infoDisplay, id);
            case "Weg" -> refreshWeg(infoDisplay, id);
        }
    }

    protected void refreshStation(HaltestelleObject haltestelleObject) {
        vboxRight.getChildren().clear();
        lbl_hstName.setText(haltestelleObject.getHST_Name());
        webView.getEngine().load(haltestelleObject.getFotoToShow());
        controller.createMenuFooter(haltestelleObject.getInfo(), haltestelleObject.getLink());
    }

    private void refreshHaltesteig(VBox infoDisplay, String id) {
        System.out.println(id);
        HaltesteigObject foundObject =
                manager.searchHaltesteigById(id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshAufzug(VBox infoDisplay, String id) {
        System.out.println(id);
        AufzugObject foundObject =
                manager.searchAufzugById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshEngstelle(VBox infoDisplay, String id) {
        System.out.println(id);
        EngstelleObject foundObject =
                manager.searchEngstelleById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshFahrkartenautomat(VBox infoDisplay, String id) {
        System.out.println(id);
        FahrkartenautomatObject foundObject =
                manager.searchFahrkartenautomatById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshFahrradanlage(VBox infoDisplay, String id) {
        System.out.println(id);
        FahrradanlageObject foundObject =
                manager.searchFahrradanlageById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshGleisquerung(VBox infoDisplay, String id) {
        System.out.println(id);
        GleisquerungObject foundObject =
                manager.searchGleisquerungById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshInformationsstelle(VBox infoDisplay, String id) {
        System.out.println(id);
        InformationsstelleObject foundObject =
                manager.searchInformationsstelleById(
                        id);
        webView
                .getEngine()
                .load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshLeihradanlage(VBox infoDisplay, String id) {
        System.out.println(id);
        LeihradanlageObject foundObject =
                manager.searchLeihradanlageById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshParkplatz(VBox infoDisplay, String id) {
        System.out.println(id);
        ParkplatzObject foundObject =
                manager.searchParkplatzById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshRampe(VBox infoDisplay, String id) {
        System.out.println(id);
        RampeObject foundObject =
                manager.searchRampeById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshRolltreppe(VBox infoDisplay, String id) {
        System.out.println(id);
        RolltreppeObject foundObject =
                manager.searchRolltreppeById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshStationsplan(VBox infoDisplay, String id) {
        System.out.println(id);
        StationsplanObject foundObject =
                manager.searchStationsplanById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshTaxi(VBox infoDisplay, String id) {
        System.out.println(id);
        TaxiObject foundObject =
                manager.searchTaxiById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshToilette(VBox infoDisplay, String id) {
        System.out.println(id);
        ToiletteObject foundObject =
                manager.searchToiletteById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshTreppe(VBox infoDisplay, String id) {
        System.out.println(id);
        TreppeObject foundObject =
                manager.searchTreppeById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshTuer(VBox infoDisplay, String id) {
        System.out.println(id);
        TuerObject foundObject =
                manager.searchTuerById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshVerkaufsstelle(VBox infoDisplay, String id) {
        System.out.println(id);
        VerkaufsstelleObject foundObject =
                manager.searchVerkaufsstelleById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshWeg(VBox infoDisplay, String id) {
        System.out.println(id);
        WegObject foundObject =
                manager.searchWegById(
                        id);
        webView.getEngine().load(foundObject.getFotoToShow());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }
}
