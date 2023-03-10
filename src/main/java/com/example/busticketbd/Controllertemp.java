package com.example.busticketbd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controllertemp {
    @FXML
    private Button bt1;

    @FXML
    private Button bt2;

    @FXML
    private Button bt3;


    public void switchtoscene2(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("FXML2.fxml"));
        Stage stage;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtocancel(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("cancelticket.fxml"));
        Stage stage;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void info(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Ticketshow.fxml"));
        Stage stage;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }










}
