package com.example.simpleopendataviewerfx;

import com.prog.station.*;
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
  /**
   * Not needed at the moment, for futere use! @FXML private Button btn_otherStation1; @FXML private
   * Button btn_displayHaltesteig; @FXML private Button btn_displayAufzug; @FXML private Button
   * btn_displayEngstelle; @FXML private Button btn_displayFahrkartenautomat; @FXML private Button
   * btn_displayFahrradanlage; @FXML private Button btn_displayGleisquerung; @FXML private Button
   * btn_displayInformationsstelle; @FXML private Button btn_displayLeihradanlage; @FXML private
   * Button btn_displayParkplatz; @FXML private Button btn_displayRampe; @FXML private Button
   * btn_displayRolltreppe; @FXML private Button btn_displayStationsplan; @FXML private Button
   * btn_displayTaxi; @FXML private Button btn_displayToilette; @FXML private Button
   * btn_displayTreppe; @FXML private Button btn_display_Tuer; @FXML private Button
   * btn_display_Verkaufsstelle; @FXML private Button btn_displayWeg;
   */
  private final StationManager manager;

  private TableView<InfoObject> infoObjectTableView;
  private ListView<LinkObject> linkListView;
  private WebView webView;
  private VBox infoDisplay;
  private String activeObject;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    webView = new WebView();
    webView.getEngine().load(haltestelleObject.getHaltestelleTotale_Foto());
    pane_pictureView.getChildren().add(webView);
    refreshStation();
  }

  @FXML
  protected void onActionBtnDisplayHaltesteig() {
    System.out.println("displayHaltesteig pressed");
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
    System.out.println(webView.getEngine().getLocation());
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
  }

  private void refreshTaxi() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    TaxiObject foundObject =
        manager.searchTaxiById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    System.out.println(webView.getEngine().getLocation());
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
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
  }

  private void refreshTreppe() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    TreppeObject foundObject =
        manager.searchTreppeById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
  }

  private void refreshTuer() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    TuerObject foundObject =
        manager.searchTuerById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
  }

  private void refreshVerkaufsstelle() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    VerkaufsstelleObject foundObject =
        manager.searchVerkaufsstelleById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
  }

  private void refreshWeg() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    WegObject foundObject =
        manager.searchWegById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, foundObject.getInfo(), foundObject.getLink());
    webView.getEngine().load(foundObject.getPosLink(foundObject.getPos()));
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
