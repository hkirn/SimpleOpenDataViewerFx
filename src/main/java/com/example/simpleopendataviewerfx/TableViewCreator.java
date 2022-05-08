package com.example.simpleopendataviewerfx;

import com.prog.station.InfoObject;
import com.prog.station.LinkObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class TableViewCreator {
    private final HaltestelleController controller;

    public TableViewCreator(HaltestelleController controller) {
        this.controller = controller;
    }

    protected TableView<InfoObject> createStationSelectInfoTableView(
            ObservableList<InfoObject> listToShow, int hight, VBox positionToDisplay) {
        String description1stColumn = "Objekt-Id";
        String description2ndColumn = "Name";
        String description3stColumn = "Landkreis";
        String description4thColumn = "Ort";
        String description5thColumn = "Fotos";
        String name1stColumn = "infoType";
        String name2ndColumn = "info";
        String name3stColumn = "extra1";
        String name4thColumn = "extra2";
        String name5thColumn = "extra3";
        TableView<InfoObject> infoObjectTableView;

        TableColumn<InfoObject, String> infoTypeColumn = new TableColumn<>(description1stColumn);
        infoTypeColumn.setCellValueFactory(new PropertyValueFactory<>(name1stColumn));

        TableColumn<InfoObject, String> infoColumn = new TableColumn<>(description2ndColumn);
        infoColumn.setCellValueFactory(new PropertyValueFactory<>(name2ndColumn));

        infoObjectTableView = new TableView<>();
        infoObjectTableView.setPrefSize(400, hight);
        infoObjectTableView.setItems(listToShow);

        TableColumn<InfoObject, String> extra1 = new TableColumn<>(description3stColumn);
        extra1.setCellValueFactory(new PropertyValueFactory<>(name3stColumn));

        TableColumn<InfoObject, String> extra2 = new TableColumn<>(description4thColumn);
        extra2.setCellValueFactory(new PropertyValueFactory<>(name4thColumn));


        TableColumn<InfoObject, String> extra3 = new TableColumn<>(description5thColumn);
        extra3.setCellValueFactory(new PropertyValueFactory<>(name5thColumn));

        infoObjectTableView.getColumns().addAll(infoTypeColumn, extra1, extra2, infoColumn, extra3);
        extra2.setSortType(TableColumn.SortType.ASCENDING);
        infoObjectTableView.getSortOrder().add(extra2);
        infoObjectTableView.sort();

        Separator separator1 = new Separator();
        positionToDisplay.getChildren().add(separator1);
        positionToDisplay.getChildren().add(infoObjectTableView);
        Separator separator2 = new Separator();
        positionToDisplay.getChildren().add(separator2);
        return infoObjectTableView;
    }

    protected TableView<InfoObject> createClickableObjectInfoTableView(
            ObservableList<InfoObject> listToShow, int hight, VBox positionToDisplay) {
        String description1stColumn = "Objekt-Id";
        String description2ndColumn = "Bezeichnung";
        String name1stColumn = "infoType";
        String name2ndColumn = "info";
        TableView<InfoObject> infoObjectTableView;

        TableColumn<InfoObject, String> infoTypeColumn = new TableColumn<>(description1stColumn);
        infoTypeColumn.setCellValueFactory(new PropertyValueFactory<>(name1stColumn));

        TableColumn<InfoObject, String> infoColumn = new TableColumn<>(description2ndColumn);
        infoColumn.setCellValueFactory(new PropertyValueFactory<>(name2ndColumn));

        infoObjectTableView = new TableView<>();
        infoObjectTableView.setPrefSize(500, hight);
        infoObjectTableView.setItems(listToShow);

        infoObjectTableView.getColumns().addAll(infoTypeColumn, infoColumn);
        infoObjectTableView.getSortOrder().add(infoTypeColumn);
        infoObjectTableView.sort();

        infoObjectTableView.setOnMouseClicked(
                event -> {
                    controller.loadObject();
                });

        Separator separator1 = new Separator();
        positionToDisplay.getChildren().add(separator1);
        positionToDisplay.getChildren().add(infoObjectTableView);
        Separator separator2 = new Separator();
        positionToDisplay.getChildren().add(separator2);
        return infoObjectTableView;
    }

    protected TableView<InfoObject> createInfoObjectInfoTableView(
            ObservableList<InfoObject> listToShow, int hight, VBox positionToDisplay) {
        String description1stColumn = "Art der Information";
        String description2ndColumn = "Information";
        String name1stColumn = "infoType";
        String name2ndColumn = "info";
        TableView<InfoObject> infoObjectTableView;

        TableColumn<InfoObject, String> infoTypeColumn = new TableColumn<>(description1stColumn);
        infoTypeColumn.setCellValueFactory(new PropertyValueFactory<>(name1stColumn));

        TableColumn<InfoObject, String> infoColumn = new TableColumn<>(description2ndColumn);
        infoColumn.setCellValueFactory(new PropertyValueFactory<>(name2ndColumn));

        infoObjectTableView = new TableView<>();
        infoObjectTableView.setPrefSize(400, hight);
        infoObjectTableView.setItems(createListWithoutEmptyLines(listToShow));

        infoObjectTableView.getColumns().addAll(infoTypeColumn, infoColumn);
        Separator separator1 = new Separator();
        positionToDisplay.getChildren().add(separator1);
        positionToDisplay.getChildren().add(infoObjectTableView);
        Separator separator2 = new Separator();
        positionToDisplay.getChildren().add(separator2);
        return infoObjectTableView;
    }

    class LinkCell extends ListCell<LinkObject> {
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
                removeButton.setOnAction((event) -> onActionShow(item, controller));
                removeButton.setDisable(true);
                textProperty().setValue("NICHT VORHANDEN " + item.getBezeichnung());
                setGraphic(removeButton);
            } else {
                Button removeButton = new Button("Anzeigen");
                removeButton.setOnAction((event) -> onActionShow(item, controller));
                textProperty().setValue("" + item.getBezeichnung());
                setGraphic(removeButton);
            }
        }
    }

    private void onActionShow(LinkObject item, HaltestelleController controller) {
        controller.webView.getEngine().load(item.getLink());
    }

    protected void createLinkListView(
            ObservableList<LinkObject> linkObjects, VBox positionToDisplay) {
        ListView<LinkObject> linkListView = new ListView<>();
        linkListView.setCellFactory(list -> new LinkCell(controller));
        linkListView.setItems(linkObjects);
        positionToDisplay.getChildren().add(linkListView);
    }

    private ObservableList<InfoObject> createListWithoutEmptyLines(ObservableList<InfoObject> list2Convert) {
        ObservableList<InfoObject> listToReturn = FXCollections.observableArrayList();
        if (list2Convert == null) {
            return null;
        }
        for (InfoObject infoObject : list2Convert) {
            if ((infoObject.getInfo() != null) && (!infoObject.getInfo().trim().equals("")) && (!infoObject.getInfo().trim().equals("0"))) {
                listToReturn.add(infoObject);
            }
        }
        return listToReturn;
    }
}
