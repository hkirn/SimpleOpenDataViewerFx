package com.example.simpleopendataviewerfx;

import com.prog.station.nvbwobjectcreator.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

public class ObjectLoader {
    private HaltestelleController controller;
    private StationManager manager;
    private VBox vboxRight;
    private Label lbl_hstName;
    private WebView webView;

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
        if (haltestelleObject.getHaltestelleTotale_Foto() != null) {
            webView.getEngine().load(haltestelleObject.getHaltestelleTotale_Foto());
        } else {
            webView.getEngine().load(haltestelleObject.getPosLink(haltestelleObject.getPos()));
        }
        controller.createMenuFooter(haltestelleObject.getInfo(), haltestelleObject.getLink());
    }

    private void refreshHaltesteig(VBox infoDisplay, String id) {
        System.out.println(id);
        HaltesteigObject haltesteigObject =
                manager.searchHaltesteigById(id);
        webView.getEngine().load(haltesteigObject.getPosLink(haltesteigObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(haltesteigObject.getInfo(), haltesteigObject.getLink());
    }

    private void refreshAufzug(VBox infoDisplay, String id) {
        System.out.println(id);
        AufzugObject aufzugObject =
                manager.searchAufzugById(
                        id);
        webView.getEngine().load(aufzugObject.getPosLink(aufzugObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(aufzugObject.getInfo(), aufzugObject.getLink());
    }

    private void refreshEngstelle(VBox infoDisplay, String id) {
        System.out.println(id);
        EngstelleObject engstelleObject =
                manager.searchEngstelleById(
                        id);
        webView.getEngine().load(engstelleObject.getPosLink(engstelleObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(engstelleObject.getInfo(), engstelleObject.getLink());
    }

    private void refreshFahrkartenautomat(VBox infoDisplay, String id) {
        System.out.println(id);
        FahrkartenautomatObject fahrkartenautomatObject =
                manager.searchFahrkartenautomatById(
                        id);
        webView.getEngine().load(fahrkartenautomatObject.getPosLink(fahrkartenautomatObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(fahrkartenautomatObject.getInfo(), fahrkartenautomatObject.getLink());
    }

    private void refreshFahrradanlage(VBox infoDisplay, String id) {
        System.out.println(id);
        FahrradanlageObject fahrradanlageObject =
                manager.searchFahrradanlageById(
                        id);
        webView.getEngine().load(fahrradanlageObject.getPosLink(fahrradanlageObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(fahrradanlageObject.getInfo(), fahrradanlageObject.getLink());
    }

    private void refreshGleisquerung(VBox infoDisplay, String id) {
        System.out.println(id);
        GleisquerungObject gleisquerungObject =
                manager.searchGleisquerungById(
                        id);
        webView.getEngine().load(gleisquerungObject.getPosLink(gleisquerungObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(gleisquerungObject.getInfo(), gleisquerungObject.getLink());
    }

    private void refreshInformationsstelle(VBox infoDisplay, String id) {
        System.out.println(id);
        InformationsstelleObject informationsstelleObject =
                manager.searchInformationsstelleById(
                        id);
        webView
                .getEngine()
                .load(informationsstelleObject.getPosLink(informationsstelleObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(informationsstelleObject.getInfo(), informationsstelleObject.getLink());
    }

    private void refreshLeihradanlage(VBox infoDisplay, String id) {
        System.out.println(id);
        LeihradanlageObject leihradanlageObject =
                manager.searchLeihradanlageById(
                        id);
        webView.getEngine().load(leihradanlageObject.getPosLink(leihradanlageObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(leihradanlageObject.getInfo(), leihradanlageObject.getLink());
        webView.getEngine().load(leihradanlageObject.getPosLink(leihradanlageObject.getPos()));
    }

    private void refreshParkplatz(VBox infoDisplay, String id) {
        System.out.println(id);
        ParkplatzObject foundObject =
                manager.searchParkplatzById(
                        id);
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    }

    private void refreshRampe(VBox infoDisplay, String id) {
        System.out.println(id);
        RampeObject foundObject =
                manager.searchRampeById(
                        id);
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    }

    private void refreshRolltreppe(VBox infoDisplay, String id) {
        System.out.println(id);
        RolltreppeObject foundObject =
                manager.searchRolltreppeById(
                        id);
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
        System.out.println(webView.getEngine().getLocation());
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshStationsplan(VBox infoDisplay, String id) {
        System.out.println(id);
        StationsplanObject foundObject =
                manager.searchStationsplanById(
                        id);
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshTaxi(VBox infoDisplay, String id) {
        System.out.println(id);
        TaxiObject foundObject =
                manager.searchTaxiById(
                        id);
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshToilette(VBox infoDisplay, String id) {
        System.out.println(id);
        ToiletteObject foundObject =
                manager.searchToiletteById(
                        id);
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshTreppe(VBox infoDisplay, String id) {
        System.out.println(id);
        TreppeObject foundObject =
                manager.searchTreppeById(
                        id);
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshTuer(VBox infoDisplay, String id) {
        System.out.println(id);
        TuerObject foundObject =
                manager.searchTuerById(
                        id);
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshVerkaufsstelle(VBox infoDisplay, String id) {
        System.out.println(id);
        VerkaufsstelleObject foundObject =
                manager.searchVerkaufsstelleById(
                        id);
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }

    private void refreshWeg(VBox infoDisplay, String id) {
        System.out.println(id);
        WegObject foundObject =
                manager.searchWegById(
                        id);
        webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
        infoDisplay.getChildren().clear();
        controller.createMenuFooter(foundObject.getInfo(), foundObject.getLink());
    }
}
