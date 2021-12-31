package com.example.simpleopendataviewerfx;

import com.prog.station.*;
import com.prog.station.nvbwobjectcreator.*;
import com.prog.station.InfoObject;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HaltestelleController implements Initializable {
  private HaltestelleObject haltestelleObject;

  public HaltestelleController() {
    this.manager = new StationManager();
    this.haltestelleObject = manager.searchById("de:08111:6115");
  }

  @FXML private Label lbl_hstName;
  @FXML private StackPane pane_pictureView;
  @FXML private VBox vboxRight;

  @FXML private Button btn_displayHaltesteig;
  @FXML private Button btn_displayAufzug;
  @FXML private Button btn_displayEngstelle;
  @FXML private Button btn_displayFahrkartenautomat;
  @FXML private Button btn_displayFahrradanlage;
  @FXML private Button btn_displayGleisquerung;
  @FXML private Button btn_displayInformationsstelle;
  @FXML private Button btn_displayLeihradanlage;
  @FXML private Button btn_displayParkplatz;
  @FXML private Button btn_displayRampe;
  @FXML private Button btn_displayRolltreppe;
  @FXML private Button btn_displayStationsplan;
  @FXML private Button btn_displayTaxi;
  @FXML private Button btn_displayToilette;
  @FXML private Button btn_displayTreppe;
  @FXML private Button btn_displayTuer;
  @FXML private Button btn_displayVerkaufsstelle;
  @FXML private Button btn_displayWeg;
  @FXML private Button btn_otherStation;
  @FXML private Button btn_back;
  @FXML private Label lbl_status;

  private final StationManager manager;

  private TableView<InfoObject> infoObjectTableView;
  private ListView<LinkObject> linkListView;
  private WebView webView;
  private VBox infoDisplay;
  private String activeObject;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    webView = new WebView();
    //webView.getEngine().load(haltestelleObject.getHaltestelleTotale_Foto());
    pane_pictureView.getChildren().add(webView);
    onActionBtnOtherStationPressed();
    lbl_status.setText("Nach der Wahl werden die Daten synchronisiert. Das kann Wartezeit verursachen.");
    btn_back.setDisable(true);
  }

  @FXML
  protected void onActionBtnDisplayHaltesteig() {
    System.out.println("displayHaltesteig pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Haltesteig";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayAufzug() {
    System.out.println("displayHaltesteig pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Aufzug";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayEngstelle() {
    System.out.println("displayEngstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Engstelle";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayFahrkartenautomat() {
    System.out.println("displayEngstelle pressed");
    setAllButtonStateDisable(true);
    activeObject = "Fahrkartenautomat";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayFahrradanlage() {
    System.out.println("displayEngstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Fahrradanlage";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayGleisquerung() {
    System.out.println("displayGleisquerung pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Gleisquerung";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayInformationsstelle() {
    System.out.println("displayInformationsstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Informationsstelle";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayLeihradanlage() {
    System.out.println("displayInformationsstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Leihradanlage";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayParkplatz() {
    System.out.println("displayParkplatz pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Parkplatz";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayRampe() {
    System.out.println("displayRampe pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Rampe";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayRolltreppe() {
    System.out.println("displayRolltreppe pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Rolltreppe";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayStationsplan() {
    System.out.println("displayStationsplan pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Stationsplan";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayTaxi() {
    System.out.println("displayTaxi pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Taxi";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayToilette() {
    System.out.println("displayToilette pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Toilette";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayTreppe() {
    System.out.println("displayTreppe pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Treppe";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayTuer() {
    System.out.println("displayTuer pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Tuer";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayVerkaufsstelle() {
    System.out.println("displayVerkaufsstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Verkaufsstelle";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnDisplayWeg() {
    System.out.println("displayInformationsstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Weg";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID",
            "Bezeichnung",
            null,
            null,
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true, null, null);
  }

  @FXML
  protected void onActionBtnOtherStationPressed() {
    System.out.println("btn_otherStation pressed...");
    setAllButtonStateDisable(true);
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Objekt-ID", "Name", "Landkreis", "Ort", manager.getHaltestelleList(), 900, vboxRight);
    Button btnOk = new Button("gewählten Bahnhof anzeigen");
    btnOk.setStyle("-fx-font-weight: bold;");
    btnOk.setPrefSize(180, 50);
    btnOk.setMinSize(180, 45);
    btnOk.setOnAction(new ButtonOkClickHandler());
    vboxRight.getChildren().add(btnOk);
  }

  @FXML
  protected void onActionBtnBackPressed() {
    System.out.println("btnBack pressed");
    refreshStation();
  }

  /*

  class ButtonBackClickHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(final ActionEvent event) {
      System.out.println("btnBack pressed");
      refreshStation();
    }
  }
  */

  /*
  class ButtonSelectObjectClickHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(final ActionEvent event) {
      loadObject();
    }
  }
   */

  class ButtonOkClickHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(final ActionEvent event) {
      System.out.println("btn_ok pressed");
      haltestelleObject =
          manager.searchById(
              infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
      refreshStation();
    }
  }

  private void loadObject() {
    System.out.println("btnSelect pressed");
    setAllButtonStateDisable(true);
    System.out.println(activeObject);
    switch (activeObject) {
      case "Haltesteig" -> refreshHaltesteig();
      case "Aufzug" -> refreshAufzug();
      case "Engstelle" -> refreshEngstelle();
      case "Fahrkartenautomat" -> refreshFahrkartenautomat();
      case "Fahrradanlage" -> refreshFahrradanlage();
      case "Gleisquerung" -> refreshGleisquerung();
      case "Informationsstelle" -> refreshInformationsstelle();
      case "Leihradanlage" -> refreshLeihradanlage();
      case "Parkplatz" -> refreshParkplatz();
      case "Rampe" -> refreshRampe();
      case "Rolltreppe" -> refreshRolltreppe();
      case "Stationsplan" -> refreshStationsplan();
      case "Taxi" -> refreshTaxi();
      case "Toilette" -> refreshToilette();
      case "Treppe" -> refreshTreppe();
      case "Tuer" -> refreshTuer();
      case "Verkaufsstelle" -> refreshVerkaufsstelle();
      case "Weg" -> refreshWeg();
    }
  }

  private void refreshStation() {
    this.vboxRight.getChildren().clear();
    lbl_hstName.setText(haltestelleObject.getHST_Name());
    if (haltestelleObject.getHaltestelleTotale_Foto() != null) {
      webView.getEngine().load(haltestelleObject.getHaltestelleTotale_Foto());
    } else {
      webView.getEngine().load(haltestelleObject.getPosLink(haltestelleObject.getPos()));
    }
    createMenuFooter(false, haltestelleObject.getInfo(), haltestelleObject.getLink());
  }

  private void refreshHaltesteig() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    HaltesteigObject haltesteigObject =
        manager.searchHaltesteigById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(haltesteigObject.getPosLink(haltesteigObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, haltesteigObject.getInfo(), haltesteigObject.getLink());
  }

  private void refreshAufzug() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    AufzugObject aufzugObject =
        manager.searchAufzugById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(aufzugObject.getPosLink(aufzugObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, aufzugObject.getInfo(), aufzugObject.getLink());
  }

  private void refreshEngstelle() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    EngstelleObject engstelleObject =
        manager.searchEngstelleById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(engstelleObject.getPosLink(engstelleObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, engstelleObject.getInfo(), engstelleObject.getLink());
  }

  private void refreshFahrkartenautomat() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    FahrkartenautomatObject fahrkartenautomatObject =
        manager.searchFahrkartenautomatById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(fahrkartenautomatObject.getPosLink(fahrkartenautomatObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, fahrkartenautomatObject.getInfo(), fahrkartenautomatObject.getLink());
  }

  private void refreshFahrradanlage() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    FahrradanlageObject fahrradanlageObject =
        manager.searchFahrradanlageById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(fahrradanlageObject.getPosLink(fahrradanlageObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, fahrradanlageObject.getInfo(), fahrradanlageObject.getLink());
  }

  private void refreshGleisquerung() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    GleisquerungObject gleisquerungObject =
        manager.searchGleisquerungById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(gleisquerungObject.getPosLink(gleisquerungObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, gleisquerungObject.getInfo(), gleisquerungObject.getLink());
  }

  private void refreshInformationsstelle() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    InformationsstelleObject informationsstelleObject =
        manager.searchInformationsstelleById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView
        .getEngine()
        .load(informationsstelleObject.getPosLink(informationsstelleObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, informationsstelleObject.getInfo(), informationsstelleObject.getLink());
  }

  private void refreshLeihradanlage() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    LeihradanlageObject leihradanlageObject =
        manager.searchLeihradanlageById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(leihradanlageObject.getPosLink(leihradanlageObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, leihradanlageObject.getInfo(), leihradanlageObject.getLink());
    webView.getEngine().load(leihradanlageObject.getPosLink(leihradanlageObject.getPos()));
  }

  private void refreshParkplatz() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    ParkplatzObject foundObject =
        manager.searchParkplatzById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
  }

  private void refreshRampe() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    RampeObject foundObject =
        manager.searchRampeById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
  }

  private void refreshRolltreppe() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    RolltreppeObject foundObject =
        manager.searchRolltreppeById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    System.out.println(webView.getEngine().getLocation());
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
  }

  private void refreshStationsplan() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    StationsplanObject foundObject =
        manager.searchStationsplanById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
  }

  private void refreshTaxi() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    TaxiObject foundObject =
        manager.searchTaxiById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
  }

  private void refreshToilette() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    ToiletteObject foundObject =
        manager.searchToiletteById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
  }

  private void refreshTreppe() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    TreppeObject foundObject =
        manager.searchTreppeById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
  }

  private void refreshTuer() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    TuerObject foundObject =
        manager.searchTuerById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
  }

  private void refreshVerkaufsstelle() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    VerkaufsstelleObject foundObject =
        manager.searchVerkaufsstelleById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
  }

  private void refreshWeg() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    WegObject foundObject =
        manager.searchWegById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
  }

  static class LinkCell extends ListCell<LinkObject> {
    private final HaltestelleController controller;

    public LinkCell(final HaltestelleController haltestelleController) {
      this.controller = haltestelleController;
    }

    @Override
    public void updateItem(LinkObject item, boolean empty) {
      super.updateItem(item, empty);
      if (empty || item == null) {
        textProperty().setValue(null);
        setGraphic(null);
      } else if (item.getLink() == null) {
        Button removeButton = new Button("Anzeigen");
        removeButton.setOnAction((event) -> controller.onActionShow(item, controller));
        removeButton.setDisable(true);
        textProperty().setValue("NICHT VORHANDEN " + item.getBezeichnung());
        setGraphic(removeButton);
      } else {
        Button removeButton = new Button("Anzeigen");
        removeButton.setOnAction((event) -> controller.onActionShow(item, controller));
        textProperty().setValue("" + item.getBezeichnung());
        setGraphic(removeButton);
      }
    }
  }

  private void onActionShow(LinkObject item, HaltestelleController controller) {
    controller.webView.getEngine().load(item.getLink());
  }

  private TableView<InfoObject> createInfoTableView(
      String description1stColumn,
      String description2ndColumn,
      String description3stColumn,
      String description4thColumn,
      ObservableList<InfoObject> listToShow,
      int hight,
      VBox positionToDisplay) {
    String name1stColumn = "infoType";
    String name2ndColumn = "info";
    String name3stColumn = "extra1";
    String name4thColumn = "extra2";
    TableView<InfoObject> infoObjectTableView;

    TableColumn<InfoObject, String> infoTypeColumn = new TableColumn<>(description1stColumn);
    infoTypeColumn.setCellValueFactory(new PropertyValueFactory<>(name1stColumn));

    TableColumn<InfoObject, String> infoColumn = new TableColumn<>(description2ndColumn);
    infoColumn.setCellValueFactory(new PropertyValueFactory<>(name2ndColumn));

    infoObjectTableView = new TableView<>();
    infoObjectTableView.setPrefSize(400, hight);
    infoObjectTableView.setItems(listToShow);
    if (description3stColumn == null) {
      infoObjectTableView.getColumns().addAll(infoTypeColumn, infoColumn);
    }
    if (description3stColumn != null) {
      TableColumn<InfoObject, String> extra1 = new TableColumn<>(description3stColumn);
      extra1.setCellValueFactory(new PropertyValueFactory<>(name3stColumn));

      TableColumn<InfoObject, String> extra2 = new TableColumn<>(description4thColumn);
      extra2.setCellValueFactory(new PropertyValueFactory<>(name4thColumn));
      infoObjectTableView.getColumns().addAll(infoTypeColumn, extra1, extra2, infoColumn);
      extra2.setSortType(TableColumn.SortType.ASCENDING);
      infoObjectTableView.getSortOrder().add(extra2);
      infoObjectTableView.sort();
    }
    if (description2ndColumn.equals("Bezeichnung")) {
      infoObjectTableView.setOnMouseClicked(
          new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
              System.out.println("gedrückt");
              loadObject();
            }
          });
    }
    Separator separator1 = new Separator();
    positionToDisplay.getChildren().add(separator1);
    positionToDisplay.getChildren().add(infoObjectTableView);
    Separator separator2 = new Separator();
    positionToDisplay.getChildren().add(separator2);
    return infoObjectTableView;
  }

  private void createLinkListView(ObservableList<LinkObject> linkObjects, VBox positionToDisplay) {
    linkListView = new ListView<>();
    linkListView.setCellFactory(list -> new LinkCell(HaltestelleController.this));
    linkListView.setItems(linkObjects);
    positionToDisplay.getChildren().add(linkListView);
  }

  private void createMenuFooter(
      boolean withButton,
      ObservableList<InfoObject> infoObjectsListToShow,
      ObservableList<LinkObject> linkObjectsListToShow) {
    // if (withButton) {
    // Not used
    // createButtons();
    // }
    infoDisplay = new VBox();
    vboxRight.getChildren().add(infoDisplay);
    createInfoTableView(
        "Art der Information", "Information", null, null, infoObjectsListToShow, 500, infoDisplay);
    createLinkListView(linkObjectsListToShow, infoDisplay);
    setAllButtonStateDisable(false);
    System.out.println(webView.getEngine().getOnError());
  }

  private ArrayList<Button> createButtonList(){
    ArrayList<Button> arrayListButton = new ArrayList<>();
    arrayListButton.add(btn_displayHaltesteig);
    arrayListButton.add(btn_displayAufzug);
    arrayListButton.add(btn_displayEngstelle);
    arrayListButton.add(btn_displayFahrkartenautomat);
    arrayListButton.add(btn_displayFahrradanlage);
    arrayListButton.add(btn_displayGleisquerung);
    arrayListButton.add(btn_displayInformationsstelle);
    arrayListButton.add(btn_displayLeihradanlage);
    arrayListButton.add(btn_displayParkplatz);
    arrayListButton.add(btn_displayRampe);
    arrayListButton.add(btn_displayRolltreppe);
    arrayListButton.add(btn_displayStationsplan);
    arrayListButton.add(btn_displayTaxi);
    arrayListButton.add(btn_displayToilette);
    arrayListButton.add(btn_displayTreppe);
    arrayListButton.add(btn_displayTuer);
    arrayListButton.add(btn_displayVerkaufsstelle);
    arrayListButton.add(btn_displayWeg);
    arrayListButton.add(btn_otherStation);
    return  arrayListButton;
  }

  private void setAllButtonStateDisable(boolean state){
    if(state==true){
      for (Button button: createButtonList()){
        button.setDisable(true);
    }}
    else {
      for (Button button: createButtonList()){
        button.setDisable(true);}
      checkObjectListAndActivateButtons();
      lbl_status.setText("");
    }
  }

  private void checkObjectListAndActivateButtons(){
    btn_displayHaltesteig.setDisable(false);
    if (manager.getObjekteList(haltestelleObject.getID(),"Aufzug").size()>0){
    btn_displayAufzug.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Engstelle").size()>0){
    btn_displayEngstelle.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Fahrkartenautomat").size()>0){
    btn_displayFahrkartenautomat.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Fahrradanlage").size()>0){
    btn_displayFahrradanlage.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Gleisquerung").size()>0){
    btn_displayGleisquerung.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Informationsstelle").size()>0){
    btn_displayInformationsstelle.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Leihradanlage").size()>0){
    btn_displayLeihradanlage.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Parkplatz").size()>0){
    btn_displayParkplatz.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Rampe").size()>0){
    btn_displayRampe.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Rolltreppe").size()>0){
    btn_displayRolltreppe.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Stationsplan").size()>0){
    btn_displayStationsplan.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Taxi").size()>0){
    btn_displayTaxi.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Toilette").size()>0){
    btn_displayToilette.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Treppe").size()>0){
    btn_displayTreppe.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Tuer").size()>0){
    btn_displayTuer.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Verkaufsstelle").size()>0){
    btn_displayVerkaufsstelle.setDisable(false);}
    if (manager.getObjekteList(haltestelleObject.getID(),"Weg").size()>0){
    btn_displayWeg.setDisable(false);}
    btn_otherStation.setDisable(false);
    btn_back.setDisable(false);
  }
  /*
  private void createButtons() {
    HBox buttonbox = new HBox();
    Button btnSelect = new Button("ausgewähltes Objekt anzeigen");
    btnSelect.setPrefSize(180, 45);
    btnSelect.setMinSize(180, 40);
    btnSelect.setOnAction(new ButtonSelectObjectClickHandler());
    Button btnBack = new Button("Zurück zu Bahnhof");
    btnBack.setPrefSize(180, 45);
    btnBack.setMinSize(180, 40);
    btnBack.setOnAction(new ButtonBackClickHandler());
    vboxRight.getChildren().add(buttonbox);
    buttonbox.getChildren().add(btnSelect);
    buttonbox.getChildren().add(btnBack);
  }
  */

}
