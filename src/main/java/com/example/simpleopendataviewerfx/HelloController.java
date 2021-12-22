package com.example.simpleopendataviewerfx;

import com.prog.station.HaltestelleObject;
import com.prog.station.StationManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
  HaltestelleObject haltestelleObject;

  public HelloController(){
    StationManager manager = new StationManager();
    this.haltestelleObject = manager.searchById("de:08118:1400");
  }

  @FXML private Label welcomeText;

  @FXML private Hyperlink linkPicture;

  @FXML private Pane testBox;


  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    welcomeText.setText(haltestelleObject.getHaltestelleTotale_Foto());
    linkPicture.setOnAction(e -> {
      System.out.println("Link pressed");
    });
    Image image3 = new Image("https://mobidata-bw.de/bfrk/haltestelle/bilder/de:08118:1400/ae5902e6-c54b-4fe3-9dbc-557a41f23d53.jpg", 100, 100, true,false);
    ImageView imageView = new ImageView(image3);
    linkPicture.setGraphic(imageView);

  }
}
