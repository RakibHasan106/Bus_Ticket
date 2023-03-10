package com.example.busticketbd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.busticketbd.Ticketshow.*;

public class Final implements Initializable {
    @FXML
    private Button bt;

    @FXML
    private AnchorPane finalscene;

    @FXML
    private ImageView image;

    @FXML
    private Label l1;

    @FXML
    private Label l10;

    @FXML
    private Label l11;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Label l5;

    @FXML
    private Label l6;

    @FXML
    private Label l7;

    @FXML
    private Label l8;

    @FXML
    private Label l9;

    @FXML
    private Label l12;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        l1.setText("Name:"+s1);
        l2.setText("Mobile Number:"+s2);
        l3.setText("Operator Name:"+s3);
        l4.setText("Bus Type:"+s4);
        l5.setText("Seat Formation:"+s5);
        l6.setText("Booked Seat(s):"+s6);
        l7.setText("From:"+s7);
        l8.setText("To:"+s8);
        l9.setText("Departure Time:"+s9);
        l10.setText("Date Of Journey:"+s11);
        l11.setText("Total Fare:"+String.valueOf(s10));
        l12.setText("Boarding Point:"+s12);

    }



    public void finalswitch(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Ticketshow.fxml"));
        Stage stage;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
