module com.example.busticketbd {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.mail;

    opens com.example.busticketbd to javafx.fxml;
    exports com.example.busticketbd;
}