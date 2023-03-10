package com.example.busticketbd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Optional;

import static com.example.busticketbd.Controller2.date;
import static com.example.busticketbd.Controller3.*;

public class Controller_info {


    @FXML
    private Button Button;

    @FXML
    private Button Button2;

    @FXML
    private AnchorPane UserInfo;

    @FXML
    private Label infolabel2;

    @FXML
    private Label infolabel21;

    @FXML
    private Label infolabel22;

    @FXML
    private Label infolabel31;

    @FXML
    private TextField infotextfield1;

    @FXML
    private TextField infotextfield2;

    @FXML
    private TextField infotextfield3;

    @FXML
    private RadioButton rb1;

    @FXML
    private RadioButton rb2;

    @FXML
    private Label warninglabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchtoprev(ActionEvent event) throws IOException{
        if(Objects.equals(seat_form, "Economy Class")){
            Parent root = FXMLLoader.load(getClass().getResource("FXML4.fxml"));
            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(Objects.equals(seat_form, "Business Class")){
            Parent root = FXMLLoader.load(getClass().getResource("FXML5.fxml"));
            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else{
            Parent root = FXMLLoader.load(getClass().getResource("FXML6.fxml"));
            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();


        }


    }


    public void savedinfo(ActionEvent event) throws IOException {
        if((infotextfield1.getText() == null || infotextfield1.getText().trim().isEmpty()) ||(infotextfield2.getText() == null || infotextfield2.getText().trim().isEmpty()) || (infotextfield3.getText() == null || infotextfield3.getText().trim().isEmpty())){
            warninglabel.setText("Please fill up all required fields");
        }
        else {
            String s1, s2 = "", s3, s4;
            int passenger_id = 0;
            s1 = infotextfield1.getText();
            if (rb1.isSelected()) {
                s2 = rb1.getText();
            } else if (rb2.isSelected()) {
                s2 = rb2.getText();
            }
            s3 = infotextfield2.getText();
            s4 = infotextfield3.getText();
            String tempm = "",board="";
            int tempf = 0, temp = 0, tempr = 0;
            if (track == 1) {
                board=Controller4.boarding;
                tempm = Controller4.new_message;
                tempf = Controller4.tf;
                temp = Controller4.ts;
                tempr = Controller4.rs;
            } else if (track == 2) {
                board=Controller5.boarding;
                tempm = Controller5.new_message;
                tempf = Controller5.tf;
                temp = Controller5.ts;
                tempr = Controller5.rs;
            } else if (track == 3) {
                board=Controller6.boarding;
                tempm = Controller6.new_message;
                tempf = Controller6.tf;
                temp = Controller6.ts;
                tempr = Controller6.rs;
            }

            int flag = 1;
            for (int i = 0; i < s3.length(); i++) {
                if (s3.charAt(i) >= '0' && s3.charAt(i) <= '9') {
                    continue;
                } else {
                    flag = 0;
                }
            }
            if (flag == 0) {
                warninglabel.setText("Please input a valid mobile number");
            } else {


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialogue");
                Image icon = new Image("PIC1.png");
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(icon);
                alert.setHeaderText(null);
                alert.setContentText("Do you want to confirm reservation?");
                ButtonType bt1 = new ButtonType("Yes");
                ButtonType bt2 = new ButtonType("No");
                alert.getButtonTypes().setAll(bt1, bt2);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == bt1) {

                    Connection connection = null;
                    try {
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_info", "root", "Keno Dure Thako");
                        String query = "insert into bus_info.info_table(passenger_name, gender, mobile_no, email, bus_id, bus_name, bus_type, seat_formation, booked_seat, total_seat,start,destination, departure_time, fare, date_of_journey,remaining_seat,boardingpoint)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, s1);
                        preparedStatement.setString(2, s2);
                        preparedStatement.setString(3, s3);
                        preparedStatement.setString(4, s4);
                        preparedStatement.setInt(5, id);
                        preparedStatement.setString(6, operator);
                        preparedStatement.setString(7, bus_type);
                        preparedStatement.setString(8, seat_form);
                        preparedStatement.setString(9, tempm);
                        preparedStatement.setInt(10, temp);
                        preparedStatement.setString(11, starting_point);
                        preparedStatement.setString(12, ending_point);
                        preparedStatement.setString(13, departuretime);
                        preparedStatement.setInt(14, tempf);
                        preparedStatement.setString(15, date);
                        preparedStatement.setInt(16, tempr);
                        preparedStatement.setString(17,board);
                        preparedStatement.execute();

                        System.out.println("Data are inserted successfully");


                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    Connection connection1 = null;
                    try {
                        connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_info", "root", "Keno Dure Thako");
                        Statement statement = connection1.createStatement();
                        ResultSet rs = statement.executeQuery("SELECT * FROM bus_info.info_table ORDER BY pnr DESC LIMIT 1;");

                        if (rs.next()) {
                            passenger_id = rs.getInt("pnr");
                        }
                        passenger_id = passenger_id * 1000 + 125;
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setHeaderText("Reservation Completed!");
                        Stage stage1 = (Stage) alert1.getDialogPane().getScene().getWindow();
                        stage1.getIcons().add(icon);
                        alert1.setContentText("Your pnr number is " + passenger_id + ".Please collect the ticket from "+board+" counter by paying mentioned amount");
                        ButtonType bt = new ButtonType("OK");
                        alert1.getButtonTypes().setAll(bt);
                        Optional<ButtonType> pt = alert1.showAndWait();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }
            }
        }

    }

}
