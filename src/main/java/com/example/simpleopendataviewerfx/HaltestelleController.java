package com.example.simpleopendataviewerfx;

import com.prog.station.HaltestelleObject;
import com.prog.station.StationManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;

public class HaltestelleController implements Initializable {
  HaltestelleObject haltestelleObject;

  public HaltestelleController() {
    StationManager manager = new StationManager();
    this.haltestelleObject = manager.searchById("de:08125:2002");
  }

  @FXML private Label lbl_hstName;

  @FXML private StackPane pane_pictureView;

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
    WebView webView = new WebView();
    webView.getEngine().load(haltestelleObject.getHaltestelleTotale_Foto());
    pane_pictureView.getChildren().add(webView);

    //webView.getEngine().load(haltestelleObject.getPosLink());
  }
}
