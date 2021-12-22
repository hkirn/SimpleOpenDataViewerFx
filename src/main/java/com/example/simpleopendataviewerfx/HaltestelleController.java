package com.example.simpleopendataviewerfx;

import com.prog.station.HaltestelleObject;
import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import com.prog.station.StationManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;

public class HaltestelleController implements Initializable {
  HaltestelleObject haltestelleObject;

  public HaltestelleController() {
    StationManager manager = new StationManager();
    this.haltestelleObject = manager.searchById("de:08121:26");
  }

  @FXML private Label lbl_hstName;

  @FXML private StackPane pane_pictureView;

  @FXML private VBox vboxRight;

  private TableView<InfoObject> infoObjectTableView;

  private ListView<LinkObject> linkListView;

  private WebView webView;

  // @FXML
  // protected void onHelloButtonClick() {
  //  welcomeText.setText("Welcome to JavaFX Application!");
  // }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    lbl_hstName.setText(haltestelleObject.getHST_Name());
    // Image image3 = new Image(haltestelleObject.getHaltestelleTotale_Foto(), 640, 480, true,true);
    // ImageView imageView = new ImageView(image3);
    // pane_pictureView.getChildren().add(imageView);
    webView = new WebView();
    webView.getEngine().load(haltestelleObject.getHaltestelleTotale_Foto());
    pane_pictureView.getChildren().add(webView);
    Button btn_test = new Button();
    createInfoTableView();
    createLinkListView();
  }

  private void createInfoTableView() {
    TableColumn<InfoObject, String> infoTypeColumn = new TableColumn<>("Art der Information");
    // infoTypeColumn.setMinWidth(200);
    infoTypeColumn.setCellValueFactory(new PropertyValueFactory<InfoObject, String>("infoType"));

    TableColumn<InfoObject, String> infoColumn = new TableColumn<>("Information");
    infoColumn.setMinWidth(400);
    infoColumn.setCellValueFactory(new PropertyValueFactory<InfoObject, String>("info"));

    infoObjectTableView = new TableView<>();
    infoObjectTableView.setItems(haltestelleObject.getInfo());
    infoObjectTableView.getColumns().addAll(infoTypeColumn, infoColumn);

    vboxRight.getChildren().add(infoObjectTableView);
  }

  private void createLinkListView() {
    linkListView = new ListView<>();
    linkListView.setCellFactory(list -> new LinkCell(HaltestelleController.this));
    linkListView.setItems(haltestelleObject.getLink());
    vboxRight.getChildren().add(linkListView);
  }

  static class LinkCell extends ListCell<LinkObject>{
    private final HaltestelleController controller;

    public LinkCell(final HaltestelleController haltestelleController){
      this.controller = haltestelleController;
    }
    @Override
    public void updateItem(LinkObject item, boolean empty){
      super.updateItem(item, empty);
      if (empty||item==null){
        textProperty().setValue(null);
        setGraphic(null);
      }
      else if(item.getLink()==null){
        Button removeButton = new Button("Anzeigen");
        removeButton.setOnAction((event) -> controller.onActionShow(item, controller));
        removeButton.setDisable(true);
        textProperty().setValue("NICHT VORHANDEN "+item.getBezeichnung());
        setGraphic(removeButton);
      }
      else {
        Button removeButton = new Button("Anzeigen");
        removeButton.setOnAction((event) -> controller.onActionShow(item, controller));
        textProperty().setValue(""+item.getBezeichnung());
        setGraphic(removeButton);
      }
    }
  }

  private void onActionShow(LinkObject item, HaltestelleController controller) {
    controller.webView.getEngine().load(item.getLink());
  }
}
