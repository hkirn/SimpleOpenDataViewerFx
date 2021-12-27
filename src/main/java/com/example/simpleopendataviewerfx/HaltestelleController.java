package com.example.simpleopendataviewerfx;

import com.prog.station.AufzugObject;
import com.prog.station.EngstelleObject;
import com.prog.station.FahrkartenautomatObject;
import com.prog.station.FahrradanlageObject;
import com.prog.station.GleisquerungObject;
import com.prog.station.HaltesteigObject;
import com.prog.station.HaltestelleObject;
import com.prog.station.InfoObject;
import com.prog.station.InformationsstelleObject;
import com.prog.station.LeihradanlageObject;
import com.prog.station.LinkObject;
import com.prog.station.StationManager;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;

public class HaltestelleController implements Initializable {
  private HaltestelleObject haltestelleObject;
  private HaltesteigObject haltesteigObject;
  private AufzugObject aufzugObject;
  private EngstelleObject engstelleObject;
  private FahrkartenautomatObject fahrkartenautomatObject;
  private FahrradanlageObject fahrradanlageObject;
  private GleisquerungObject gleisquerungObject;
  private InformationsstelleObject informationsstelleObject;
  private LeihradanlageObject leihradanlageObject;

  public HaltestelleController() {
    this.manager = new StationManager();
    this.haltestelleObject = manager.searchById("de:08111:6115");
  }

  @FXML private Label lbl_hstName;
  @FXML private StackPane pane_pictureView;
  @FXML private VBox vboxRight;
  @FXML private Button btn_otherStation1;
  @FXML private Button btn_displayHaltesteig;
  @FXML private Button btn_displayAufzug;
  @FXML private Button btn_displayEngstelle;
  @FXML private Button btn_displayFahrkartenautomat;
  @FXML private Button btn_displayFahrradanlage;
  @FXML private Button btn_displayGleisquerung;
  @FXML private Button btn_displayInformationsstelle;
  @FXML private Button btn_displayLeihradanlage;

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
            "Steig-ID",
            "infoType",
            "Bezeichnung",
            "info",
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
            "Object-ID",
            "infoType",
            "Bezeichnung",
            "info",
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
            "Object-ID",
            "infoType",
            "Bezeichnung",
            "info",
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            300,
            vboxRight);
    createMenuFooter(true,null, null);
  }

  @FXML
  protected void onActionBtnDisplayFahrkartenautomat() {
    System.out.println("displayEngstelle pressed");
    activeObject = "Fahrkartenautomat";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
            createInfoTableView(
                    "Object-ID",
                    "infoType",
                    "Bezeichnung",
                    "info",
                    manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
                    300,
                    vboxRight);
    createMenuFooter(true,null, null);
  }

  @FXML
  protected void onActionBtnDisplayFahrradanlage() {
    System.out.println("displayEngstelle pressed");
    this.activeObject = "Fahrradanlage";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
            createInfoTableView(
                    "Object-ID",
                    "infoType",
                    "Bezeichnung",
                    "info",
                    manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
                    300,
                    vboxRight);
    createMenuFooter(true,null, null);
  }

  @FXML
  protected void onActionBtnDisplayGleisquerung() {
    System.out.println("displayGleisquerung pressed");
    this.activeObject = "Gleisquerung";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
            createInfoTableView(
                    "Object-ID",
                    "infoType",
                    "Bezeichnung",
                    "info",
                    manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
                    300,
                    vboxRight);
    createMenuFooter(true,null, null);
  }

  @FXML
  protected void onActionBtnDisplayInformationsstelle() {
    System.out.println("displayInformationsstelle pressed");
    this.activeObject = "Informationsstelle";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
            createInfoTableView(
                    "Object-ID",
                    "infoType",
                    "Bezeichnung",
                    "info",
                    manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
                    300,
                    vboxRight);
    createMenuFooter(true,null, null);
  }
  @FXML
  protected void onActionBtnDisplayLeihradanlage() {
    System.out.println("displayInformationsstelle pressed");
    this.activeObject = "Leihradanlage";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
            createInfoTableView(
                    "Object-ID",
                    "infoType",
                    "Bezeichnung",
                    "info",
                    manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
                    300,
                    vboxRight);
    createMenuFooter(true,null, null);
  }

  @FXML
  protected void onActionBtnOtherStationPressed() {
    System.out.println("btn_otherStation pressed...");
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Bahnhof ID",
            "infoType",
            "Bahnhof Name",
            "info",
            manager.getHaltestelleList(),
            800,
            vboxRight);
    Button btnOk = new Button("Bahnhof aufrufen");
    btnOk.setOnAction(new ButtonOkClickHandler());
    vboxRight.getChildren().add(btnOk);
  }

  class ButtonBackClickHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(final ActionEvent event) {
      System.out.println("btnBack pressed");
      refreshStation();
    }
  }

  class ButtonSelectObjectClickHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(final ActionEvent event) {
      System.out.println("btnSelect pressed");
      System.out.println(activeObject);
      switch (activeObject) {
        case "Haltesteig":
          refreshHaltesteig();
          break;
        case "Aufzug":
          refreshAufzug();
          break;
        case "Engstelle":
          refreshEngstelle();
          break;
        case "Fahrkartenautomat":
          refreshFahrkartenautomat();
          break;
        case "Fahrradanlage":
          refreshFahrradanlage();
          break;
        case "Gleisquerung":
          refreshGleisquerung();
          break;
        case "Informationsstelle":
          refreshInformationsstelle();
          break;
        case "Leihradanlage":
          refreshLeihradanlage();
          break;

      }
    }
  }

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
    haltesteigObject =
        manager.searchHaltesteigById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(haltesteigObject.getPosLink(haltesteigObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, haltesteigObject.getInfo(),haltesteigObject.getLink());
  }

  private void refreshAufzug() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    aufzugObject =
        manager.searchAufzugById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(aufzugObject.getPosLink(aufzugObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false, aufzugObject.getInfo(),aufzugObject.getLink());
  }

  private void refreshEngstelle() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    engstelleObject =
        manager.searchEngstelleById(
            infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(engstelleObject.getPosLink(engstelleObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false,engstelleObject.getInfo(),engstelleObject.getLink());
  }

  private void refreshFahrkartenautomat() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    fahrkartenautomatObject =
            manager.searchFahrkartenautomatById(
                    infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(fahrkartenautomatObject.getPosLink(fahrkartenautomatObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false,fahrkartenautomatObject.getInfo(),fahrkartenautomatObject.getLink());
  }

  private void refreshFahrradanlage() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    fahrradanlageObject =
            manager.searchFahrradanlageById(
                    infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(fahrradanlageObject.getPosLink(fahrradanlageObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false,fahrradanlageObject.getInfo(),fahrradanlageObject.getLink());
  }

  private void refreshGleisquerung() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    gleisquerungObject =
            manager.searchGleisquerungById(
                    infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(gleisquerungObject.getPosLink(gleisquerungObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false,gleisquerungObject.getInfo(),gleisquerungObject.getLink());
  }

  private void refreshInformationsstelle() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    informationsstelleObject =
            manager.searchInformationsstelleById(
                    infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(informationsstelleObject.getPosLink(informationsstelleObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false,informationsstelleObject.getInfo(),informationsstelleObject.getLink());
  }

  private void refreshLeihradanlage() {
    System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    leihradanlageObject =
            manager.searchLeihradanlageById(
                    infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
    webView.getEngine().load(leihradanlageObject.getPosLink(leihradanlageObject.getPos()));
    infoDisplay.getChildren().clear();
    createMenuFooter(false,leihradanlageObject.getInfo(),leihradanlageObject.getLink());
    webView.getEngine().load(leihradanlageObject.getPosLink(leihradanlageObject.getPos()));
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

  private TableView createInfoTableView(
      String description1stColumn,
      String name1stColumn,
      String description2ndColumn,
      String name2ndColumn,
      ObservableList<InfoObject> listToShow,
      int hight,
      VBox positionToDisplay) {
    TableView infoObjectTableView;
    TableColumn<InfoObject, String> infoTypeColumn = new TableColumn<>(description1stColumn);
    infoTypeColumn.setCellValueFactory(new PropertyValueFactory<>(name1stColumn));

    TableColumn<InfoObject, String> infoColumn = new TableColumn<>(description2ndColumn);
    infoColumn.setCellValueFactory(new PropertyValueFactory<>(name2ndColumn));

    infoObjectTableView = new TableView<>();
    infoObjectTableView.setPrefSize(400, hight);
    infoObjectTableView.setItems(listToShow);
    infoObjectTableView.getColumns().addAll(infoTypeColumn, infoColumn);
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
    if (withButton == true) {
      createButtons();
    }
    infoDisplay = new VBox();
    vboxRight.getChildren().add(infoDisplay);
    createInfoTableView(
        "Art der Information", "infoType", "Information", "info", infoObjectsListToShow, 400, infoDisplay);
    createLinkListView(linkObjectsListToShow, infoDisplay);
  }

  private void createButtons() {
    HBox buttonbox = new HBox();
    Button btnSelect = new Button("ausgewähltes Objekt anzeigen");
    btnSelect.setOnAction(new ButtonSelectObjectClickHandler());
    Button btnBack = new Button("Zurück zu Bahnhof");
    btnBack.setOnAction(new ButtonBackClickHandler());
    vboxRight.getChildren().add(buttonbox);
    buttonbox.getChildren().add(btnSelect);
    buttonbox.getChildren().add(btnBack);
  }
}
