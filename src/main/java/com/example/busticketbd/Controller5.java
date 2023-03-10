package com.example.busticketbd;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static com.example.busticketbd.Controller2.trace;
import static com.example.busticketbd.Controller3.*;

public  class Controller5 implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchtoscene3(ActionEvent event) throws IOException{
        Parent root= FXMLLoader.load(getClass().getResource("FXML3.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private CheckBox A1;

    @FXML
    private CheckBox A2;

    @FXML
    private CheckBox A3;

    @FXML
    private CheckBox B1;

    @FXML
    private CheckBox B2;

    @FXML
    private CheckBox B3;

    @FXML
    private CheckBox C1;

    @FXML
    private CheckBox C2;

    @FXML
    private CheckBox C3;

    @FXML
    private CheckBox D1;

    @FXML
    private CheckBox D2;

    @FXML
    private CheckBox D3;

    @FXML
    private CheckBox E1;

    @FXML
    private CheckBox E2;

    @FXML
    private CheckBox E3;

    @FXML
    private CheckBox F1;

    @FXML
    private CheckBox F2;

    @FXML
    private CheckBox F3;

    @FXML
    private CheckBox G1;

    @FXML
    private CheckBox G2;

    @FXML
    private CheckBox G3;

    @FXML
    private CheckBox H1;

    @FXML
    private CheckBox H2;

    @FXML
    private CheckBox H3;

    @FXML
    private CheckBox I1;

    @FXML
    private CheckBox I2;

    @FXML
    private CheckBox I3;

    @FXML
    private AnchorPane Rectangle2;

    @FXML
    private Button Scene5Button1;

    @FXML
    private Button Scene5Button2;

    @FXML
    private Label TextLabel1;

    @FXML
    private Label TextLabel2;

    @FXML
    private Label TextLabel3;

    @FXML
    private Label warninglabel;

    @FXML
    private ComboBox<String> Combobox;

    public static String boarding;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection connection = null;
        if(trace==1){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_info", "root", "Keno Dure Thako");
                Statement statement = connection.createStatement();
                ResultSet rs;
                rs = statement.executeQuery("Select * From bus_info.info_table where bus_id='" + id + "'");
                while (rs.next()) {
                    String s = rs.getString("booked_seat");
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == 'A' && s.charAt(i + 1) == '1') {
                            A1.setDisable(true);
                        }
                        if (s.charAt(i) == 'A' && s.charAt(i + 1) == '2') {
                            A2.setDisable(true);
                        }
                        if (s.charAt(i) == 'A' && s.charAt(i + 1) == '3') {
                            A3.setDisable(true);
                        }

                        if (s.charAt(i) == 'B' && s.charAt(i + 1) == '1') {
                            B1.setDisable(true);
                        }
                        if (s.charAt(i) == 'B' && s.charAt(i + 1) == '2') {
                            B2.setDisable(true);
                        }
                        if (s.charAt(i) == 'B' && s.charAt(i + 1) == '3') {
                            B3.setDisable(true);
                        }

                        if (s.charAt(i) == 'C' && s.charAt(i + 1) == '1') {
                            C1.setDisable(true);
                        }
                        if (s.charAt(i) == 'C' && s.charAt(i + 1) == '2') {
                            C2.setDisable(true);
                        }
                        if (s.charAt(i) == 'C' && s.charAt(i + 1) == '3') {
                            C3.setDisable(true);
                        }

                        if (s.charAt(i) == 'D' && s.charAt(i + 1) == '1') {
                            D1.setDisable(true);
                        }
                        if (s.charAt(i) == 'D' && s.charAt(i + 1) == '2') {
                            D2.setDisable(true);
                        }
                        if (s.charAt(i) == 'D' && s.charAt(i + 1) == '3') {
                            D3.setDisable(true);
                        }

                        if (s.charAt(i) == 'E' && s.charAt(i + 1) == '1') {
                            E1.setDisable(true);
                        }
                        if (s.charAt(i) == 'E' && s.charAt(i + 1) == '2') {
                            E2.setDisable(true);
                        }
                        if (s.charAt(i) == 'E' && s.charAt(i + 1) == '3') {
                            E3.setDisable(true);
                        }

                        if (s.charAt(i) == 'F' && s.charAt(i + 1) == '1') {
                            F1.setDisable(true);
                        }
                        if (s.charAt(i) == 'F' && s.charAt(i + 1) == '2') {
                            F2.setDisable(true);
                        }
                        if (s.charAt(i) == 'F' && s.charAt(i + 1) == '3') {
                            F3.setDisable(true);
                        }

                        if (s.charAt(i) == 'G' && s.charAt(i + 1) == '1') {
                            G1.setDisable(true);
                        }
                        if (s.charAt(i) == 'G' && s.charAt(i + 1) == '2') {
                            G2.setDisable(true);
                        }
                        if (s.charAt(i) == 'G' && s.charAt(i + 1) == '3') {
                            G3.setDisable(true);
                        }

                        if (s.charAt(i) == 'H' && s.charAt(i + 1) == '1') {
                            H1.setDisable(true);
                        }
                        if (s.charAt(i) == 'H' && s.charAt(i + 1) == '2') {
                            H2.setDisable(true);
                        }
                        if (s.charAt(i) == 'H' && s.charAt(i + 1) == '3') {
                            H3.setDisable(true);
                        }

                        if (s.charAt(i) == 'I' && s.charAt(i + 1) == '1') {
                            I1.setDisable(true);
                        }
                        if (s.charAt(i) == 'I' && s.charAt(i + 1) == '2') {
                            I2.setDisable(true);
                        }
                        if (s.charAt(i) == 'I' && s.charAt(i + 1) == '3') {
                            I3.setDisable(true);
                        }

                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            Connection connection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_info", "root", "Keno Dure Thako");
            Statement statement = connection1.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("Select * From bus_info.boarding_table where district='" + starting_point + "'");
            if(rs.next()){
                System.out.println(-1);
                ObservableList data= FXCollections.observableArrayList();
                data.add(new String(rs.getString("point")));
                while(rs.next()){
                    data.add(new String(rs.getString("point")));
                }
                Combobox.setItems(data);
            }
            else{
                String board=starting_point+" Bus Terminal";
                Combobox.getItems().addAll(board);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Combobox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                boarding=Combobox.getSelectionModel().getSelectedItem();

            }
        });
    }




    public static String new_message;
    public static int tf,ts,rs;


    public void checkevent(ActionEvent event)
    {
        int new_seat=0;
        int new_fare=0;
        String message="";
        if(A1.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=A1.getText()+" ";
        }

        if(A2.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=A2.getText()+" ";
        }

        if(A3.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=A3.getText()+" ";
        }
        if(B1.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=B1.getText()+" ";
        }
        if(B2.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=B2.getText()+" ";
        }
        if(B3.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=B3.getText()+" ";
        }

        if(C1.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=C1.getText()+" ";
        }
        if(C2.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=C2.getText()+" ";
        }
        if(C3.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=C3.getText()+" ";
        }

        if(D1.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=D1.getText()+" ";
        }
        if(D2.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=D2.getText()+" ";
        }
        if(D3.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=D3.getText()+" ";
        }

        if(E1.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=E1.getText()+" ";
        }
        if(E2.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=E2.getText()+" ";
        }
        if(E3.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=E3.getText()+" ";
        }

        if(F1.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=F1.getText()+" ";
        }
        if(F2.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=F2.getText()+" ";
        }
        if(F3.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=F3.getText()+" ";
        }

        if(G1.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=G1.getText()+" ";
        }
        if(G2.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=G2.getText()+" ";
        }
        if(G3.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=G3.getText()+" ";
        }

        if(H1.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=H1.getText()+" ";
        }
        if(H2.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=H2.getText()+" ";
        }
        if(H3.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=H3.getText()+" ";
        }

        if(I1.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=I1.getText()+" ";
        }
        if(I2.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=I2.getText()+" ";
        }
        if(I3.isSelected()){
            new_seat++;
            new_fare+= fare;
            message+=I3.getText()+" ";
        }

        TextLabel1.setText(message);
        TextLabel2.setText(String.valueOf(new_seat));
        TextLabel3.setText(String.valueOf(new_fare));
        new_message=message;
        ts=new_seat;
        rs=seat-ts;
        tf=new_fare;

    }

    public void switchttoinfo(ActionEvent event) throws IOException{
        if((A1.isSelected() || A2.isSelected() || A3.isSelected() || B1.isSelected() || B2.isSelected() || B3.isSelected() || C1.isSelected() || C2.isSelected() || C3.isSelected()  || D1.isSelected() || D2.isSelected() || D3.isSelected() ||  E1.isSelected() || E2.isSelected() || E3.isSelected()  || F1.isSelected() || F2.isSelected() || F3.isSelected() || G1.isSelected() || G2.isSelected() || G3.isSelected() || H1.isSelected() || H2.isSelected() || H3.isSelected() || I1.isSelected() || I2.isSelected() || I3.isSelected()) && boarding!=null) {
            Parent root = FXMLLoader.load(getClass().getResource("FXML_info.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            warninglabel.setText("Please choose a seat and a boarding point!");
        }
    }



}

