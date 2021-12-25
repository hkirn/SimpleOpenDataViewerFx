package com.example.simpleopendataviewerfx;

import com.prog.station.HaltesteigObject;
import com.prog.station.HaltestelleObject;
import com.prog.station.InfoObject;
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
  HaltestelleObject haltestelleObject;
  HaltesteigObject haltesteigObject;

  public HaltestelleController() {
    manager = new StationManager();
    this.haltestelleObject = manager.searchById("de:08111:6115");
  }

  @FXML private Label lbl_hstName;
  @FXML private StackPane pane_pictureView;
  @FXML private VBox vboxRight;
  @FXML private Button btn_otherStation;
  @FXML private Button btn_displayHaltesteig;

  private StationManager manager;
  private TableView<InfoObject> infoObjectTableView;
  private ListView<LinkObject> linkListView;
  private WebView webView;

  @FXML
  protected void onActionBtnDisplayHaltesteig() {
    System.out.println("displayHaltesteig pressed");
    createHaltesteigMenu();
  }

  private void createHaltesteigMenu() {
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Steig-ID",
            "infoType",
            "Bezeichnung",
            "info",
            manager.getObjekteList(this.haltestelleObject.getID(), "Haltesteig"),
            200);
    createButtons();
    createInfoTableView("Art der Information", "infoType", "Information", "info", null, 400);
    createLinkListView(null);
  }

  private void createButtons() {
    HBox buttonbox = new HBox();
    Button btnSelect = new Button("Haltesteig anzeigen");
    btnSelect.setOnAction(new ButtonSelectHaltesteigClickHandler());
    Button btnBack = new Button("Zurück zu Bahnhof");
    btnBack.setOnAction(new ButtonBackClickHandler());
    vboxRight.getChildren().add(buttonbox);
    buttonbox.getChildren().add(btnSelect);
    buttonbox.getChildren().add(btnBack);
  }

  @FXML
  protected void onActionBtnOtherStationPressed() {
    System.out.println("btn_otherStation pressed...");
    vboxRight.getChildren().clear();
    this.infoObjectTableView =
        createInfoTableView(
            "Bahnhof ID", "infoType", "Bahnhof Name", "info", manager.getHaltestelleList(), 800);
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

  class ButtonSelectHaltesteigClickHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(final ActionEvent event) {
      System.out.println("btnSelect pressed");
      System.out.println(infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
      haltesteigObject =
          manager.searchHaltesteigById(
              infoObjectTableView.getSelectionModel().getSelectedItem().getInfoType());
      vboxRight.getChildren().clear();
      infoObjectTableView =
          createInfoTableView(
              "Steig-ID",
              "infoType",
              "Bezeichnung",
              "info",
              manager.getObjekteList(haltestelleObject.getID(), "Haltesteig"),
              200);
      createButtons();
      createInfoTableView(
          "Art der Information",
          "infoType",
          "Information",
          "info",
          haltesteigObject.getInfo(),
          400);
      createLinkListView(haltesteigObject.getLink());
      webView.getEngine().load(haltesteigObject.getPosLink(haltesteigObject.getPos()));
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

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    webView = new WebView();
    webView.getEngine().load(haltestelleObject.getHaltestelleTotale_Foto());
    pane_pictureView.getChildren().add(webView);
    refreshStation();
  }

  private void refreshStation() {
    this.vboxRight.getChildren().clear();
    lbl_hstName.setText(haltestelleObject.getHST_Name());
    if (haltestelleObject.getHaltestelleTotale_Foto() != null) {
      webView.getEngine().load(haltestelleObject.getHaltestelleTotale_Foto());
    } else {
      webView.getEngine().load(haltestelleObject.getPosLink(haltestelleObject.getPos()));
    }
    createInfoTableView(
        "Art der Information", "infoType", "Information", "info", haltestelleObject.getInfo(), 400);
    createLinkListView(haltestelleObject.getLink());
  }

  private TableView createInfoTableView(
      String description1stColumn,
      String name1stColumn,
      String description2ndColumn,
      String name2ndColumn,
      ObservableList<InfoObject> listToShow,
      int hight) {
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
    vboxRight.getChildren().add(separator1);
    vboxRight.getChildren().add(infoObjectTableView);
    Separator separator2 = new Separator();
    vboxRight.getChildren().add(separator2);
    return infoObjectTableView;
  }

  private void createLinkListView(ObservableList<LinkObject> linkObjects) {
    linkListView = new ListView<>();
    linkListView.setCellFactory(list -> new LinkCell(HaltestelleController.this));
    linkListView.setItems(linkObjects);
    vboxRight.getChildren().add(linkListView);
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
}
