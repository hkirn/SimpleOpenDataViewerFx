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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HaltestelleController implements Initializable {
  protected StationManager manager;
  private HaltestelleObject haltestelleObject;
  private final TableViewCreator tableViewCreator = new TableViewCreator(this);

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
  @FXML private Button btn_license;
  @FXML private Label lbl_status;

  private TableView<InfoObject> infoObjectTableView;
  protected WebView webView;
  private VBox infoDisplay;
  protected String activeObject;
  private ObjectLoader objectLoader;
  private TextField textFieldSearchStationByTown;


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    webView = new WebView();
    URL url = HaltestelleController.class.getResource("/startscreen.html");
    webView.getEngine().load(String.valueOf(url));
    pane_pictureView.getChildren().add(webView);
    onActionBtnOtherStationPressed();
    lbl_status.setText(
        "Nach der Wahl werden die Daten synchronisiert. Das kann Wartezeit verursachen.");
    btn_back.setDisable(true);
    objectLoader =
        new ObjectLoader(
            this, this.manager, vboxRight, lbl_hstName, webView);
  }

  @FXML
  protected void onActionBtnLicensePressed() {
    System.out.println("displayLicence pressed");
    URL url = HaltestelleController.class.getResource("/license.html");
    System.out.println(url);
    webView.getEngine().load(String.valueOf(url));
  }

  @FXML
  protected void onActionBtnDisplayHaltesteig() {
    System.out.println("displayHaltesteig pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Haltesteig";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayAufzug() {
    System.out.println("displayHaltesteig pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Aufzug";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayEngstelle() {
    System.out.println("displayEngstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Engstelle";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayFahrkartenautomat() {
    System.out.println("displayEngstelle pressed");
    setAllButtonStateDisable(true);
    activeObject = "Fahrkartenautomat";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayFahrradanlage() {
    System.out.println("displayEngstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Fahrradanlage";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayGleisquerung() {
    System.out.println("displayGleisquerung pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Gleisquerung";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayInformationsstelle() {
    System.out.println("displayInformationsstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Informationsstelle";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayLeihradanlage() {
    System.out.println("displayInformationsstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Leihradanlage";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayParkplatz() {
    System.out.println("displayParkplatz pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Parkplatz";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayRampe() {
    System.out.println("displayRampe pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Rampe";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayRolltreppe() {
    System.out.println("displayRolltreppe pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Rolltreppe";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayStationsplan() {
    System.out.println("displayStationsplan pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Stationsplan";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayTaxi() {
    System.out.println("displayTaxi pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Taxi";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayToilette() {
    System.out.println("displayToilette pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Toilette";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayTreppe() {
    System.out.println("displayTreppe pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Treppe";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayTuer() {
    System.out.println("displayTuer pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Tuer";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayVerkaufsstelle() {
    System.out.println("displayVerkaufsstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Verkaufsstelle";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnDisplayWeg() {
    System.out.println("displayInformationsstelle pressed");
    setAllButtonStateDisable(true);
    this.activeObject = "Weg";
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createClickableObjectInfoTableView(
            manager.getObjekteList(this.haltestelleObject.getID(), this.activeObject),
            400,
            vboxRight);
    createMenuFooter(null, null);
  }

  @FXML
  protected void onActionBtnOtherStationPressed() {
    System.out.println("btn_otherStation pressed...");
    setAllButtonStateDisable(true);
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        tableViewCreator.createStationSelectInfoTableView(
            manager.getHaltestelleList(null), 900, vboxRight);
    createStationViewFooter();
  }

  private void createStationViewFooter(){
    Button btnOk = new Button("gewählten Bahnhof anzeigen");
    textFieldSearchStationByTown = new TextField();
    textFieldSearchStationByTown.setPrefWidth(700);
    textFieldSearchStationByTown.setPromptText("Ortsname, Bahnhofsname oder Teil davon eingeben");
    textFieldSearchStationByTown.setOnAction(new ButtonSearchStationByTownClickHandler());
    Button btnSearchStationByTown = new Button("Stadt oder Name suchen");
    btnOk.setStyle("-fx-font-weight: bold;");
    btnSearchStationByTown.setStyle("-fx-font-weight: bold;");
    btnOk.setPrefSize(180, 50);
    btnOk.setMinSize(180, 45);
    btnSearchStationByTown.setPrefSize(180, 50);
    btnSearchStationByTown.setMinSize(180, 45);
    btnOk.setOnAction(new ButtonOkClickHandler());
    btnSearchStationByTown.setOnAction(new ButtonSearchStationByTownClickHandler());
    HBox buttonHBox = new HBox();
    vboxRight.getChildren().add(buttonHBox);
    buttonHBox.getChildren().add(btnOk);
    buttonHBox.getChildren().add(textFieldSearchStationByTown);
    buttonHBox.getChildren().add(btnSearchStationByTown);
  }

  @FXML
  protected void onActionBtnBackPressed() {
    System.out.println("btnBack pressed");
    objectLoader.refreshStation(haltestelleObject);
  }

  class ButtonOkClickHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(final ActionEvent event) {
      System.out.println("btn_ok pressed");
      haltestelleObject =
          manager.searchById(
              infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
      objectLoader.refreshStation(haltestelleObject);
    }
  }

  class ButtonSearchStationByTownClickHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(final ActionEvent event) {
      System.out.println("Button SearchStationByTownClick pressed");
      System.out.println("Bahnhof gesucht: "+textFieldSearchStationByTown.getText());
      System.out.println("btn_otherStation pressed...");
      setAllButtonStateDisable(true);
      vboxRight.getChildren().clear();
      infoObjectTableView =
              tableViewCreator.createStationSelectInfoTableView(
                      manager.getHaltestelleList(textFieldSearchStationByTown.getText()), 900, vboxRight);
      createStationViewFooter();
    }
  }

  protected void loadObject() {
    objectLoader.loadObject(
        infoDisplay, infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
  }

  protected void createMenuFooter(
      ObservableList<InfoObject> infoObjectsListToShow,
      ObservableList<LinkObject> linkObjectsListToShow) {
    infoDisplay = new VBox();
    vboxRight.getChildren().add(infoDisplay);
    tableViewCreator.createInfoObjectInfoTableView(infoObjectsListToShow, 400, infoDisplay);
    tableViewCreator.createLinkListView(linkObjectsListToShow, infoDisplay);
    setAllButtonStateDisable(false);
    System.out.println(webView.getEngine().getOnError());
  }

  private ArrayList<Button> createButtonList() {
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
    return arrayListButton;
  }

  void setAllButtonStateDisable(boolean state) {
    if (state) {
      for (Button button : createButtonList()) {
        button.setDisable(true);
      }
    } else {
      for (Button button : createButtonList()) {
        button.setDisable(true);
      }
      checkObjectListAndActivateButtons();
      lbl_status.setText("");
    }
  }

  private void checkObjectListAndActivateButtons() {
    btn_displayHaltesteig.setDisable(false);
    if (manager.getObjekteList(haltestelleObject.getID(), "Aufzug").size() > 0) {
      btn_displayAufzug.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Engstelle").size() > 0) {
      btn_displayEngstelle.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Fahrkartenautomat").size() > 0) {
      btn_displayFahrkartenautomat.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Fahrradanlage").size() > 0) {
      btn_displayFahrradanlage.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Gleisquerung").size() > 0) {
      btn_displayGleisquerung.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Informationsstelle").size() > 0) {
      btn_displayInformationsstelle.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Leihradanlage").size() > 0) {
      btn_displayLeihradanlage.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Parkplatz").size() > 0) {
      btn_displayParkplatz.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Rampe").size() > 0) {
      btn_displayRampe.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Rolltreppe").size() > 0) {
      btn_displayRolltreppe.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Stationsplan").size() > 0) {
      btn_displayStationsplan.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Taxi").size() > 0) {
      btn_displayTaxi.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Toilette").size() > 0) {
      btn_displayToilette.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Treppe").size() > 0) {
      btn_displayTreppe.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Tuer").size() > 0) {
      btn_displayTuer.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Verkaufsstelle").size() > 0) {
      btn_displayVerkaufsstelle.setDisable(false);
    }
    if (manager.getObjekteList(haltestelleObject.getID(), "Weg").size() > 0) {
      btn_displayWeg.setDisable(false);
    }
    btn_otherStation.setDisable(false);
    btn_back.setDisable(false);
  }
}
