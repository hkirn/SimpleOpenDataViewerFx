module com.example.simpleopendataviewerfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.web;

    opens com.example.simpleopendataviewerfx to javafx.fxml;
    exports com.example.simpleopendataviewerfx;
    exports com.prog.station;
    opens com.prog.station to javafx.fxml;
}