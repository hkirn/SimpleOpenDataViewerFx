package com.example.simpleopendataviewerfx;

import com.prog.station.HaltestelleObject;
import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import com.prog.station.StationManager;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;

public class HaltestelleController implements Initializable {
  HaltestelleObject haltestelleObject;

  public HaltestelleController() {
    manager = new StationManager();
    this.haltestelleObject = manager.searchById("de:08415:28716");
  }

  @FXML private Label lbl_hstName;

  @FXML private StackPane pane_pictureView;

  @FXML private VBox vboxRight;

  @FXML private Button btn_otherStation;

  private StationManager manager;
  private TableView<InfoObject> infoObjectTableView;

  private ListView<LinkObject> linkListView;

  private WebView webView;

  @FXML
  protected void onActionBtnOtherStationPressed() {
    System.out.println("Bahnhof wechseln...");
    this.haltestelleObject = manager.searchById("de:08125:1438");
    refreshStation();
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
    webView.getEngine().load(haltestelleObject.getHaltestelleTotale_Foto());
    createInfoTableView("Art der Information", "infoType", "Information", "info", haltestelleObject.getInfo());
    createLinkListView();
  }

  private void createInfoTableView(
      String description1stColumn,
      String name1stColumn,
      String description2ndColumn,
      String name2ndColumn,
      ObservableList<InfoObject> listToShow
  ) {
    TableColumn<InfoObject, String> infoTypeColumn = new TableColumn<>(description1stColumn);
    infoTypeColumn.setCellValueFactory(new PropertyValueFactory<InfoObject, String>(name1stColumn));

    TableColumn<InfoObject, String> infoColumn = new TableColumn<>(description2ndColumn);
    infoColumn.setMinWidth(500);
    infoColumn.setCellValueFactory(new PropertyValueFactory<InfoObject, String>(name2ndColumn));

    infoObjectTableView = new TableView<>();
    infoObjectTableView.setItems(listToShow);
    infoObjectTableView.getColumns().addAll(infoTypeColumn, infoColumn);
    Separator separator1 = new Separator();
    vboxRight.getChildren().add(separator1);
    vboxRight.getChildren().add(infoObjectTableView);
    Separator separator2 = new Separator();
    vboxRight.getChildren().add(separator2);
  }

  private void createLinkListView() {
    linkListView = new ListView<>();
    linkListView.setCellFactory(list -> new LinkCell(HaltestelleController.this));
    linkListView.setItems(haltestelleObject.getLink());
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
