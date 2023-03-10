package com.example.busticketbd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Ticketshow {

    @FXML
    private Button bt1;

    @FXML
    private Button bt2;

    @FXML
    private Label infolabel2;

    @FXML
    private TextField pnr;

    @FXML
    private Label warninglabel;

    @FXML
    private TextField mobile;

 

    public static String s1,s2,s3,s4,s5,s6,s7,s8,s9,s11,s12;
    public static int s10;


    @FXML
    void switchtotemp(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("temp.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void showinfo(ActionEvent event) throws IOException {
        int fg;
        String s;
        if((pnr.getText() == null || pnr.getText().trim().isEmpty()) ||(mobile.getText() == null || mobile.getText().trim().isEmpty())){
            warninglabel.setText("Please fill up all required fields");
        }
        else {
            s = pnr.getText();
            int temp = Integer.parseInt(s);
            int id = (temp - 125) / 1000;
            s = mobile.getText();
            fg = 0;
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_info", "root", "Keno Dure Thako");
                Statement statement = connection.createStatement();
                ResultSet rs;
                rs = statement.executeQuery("SELECT * FROM bus_info.info_table where pnr='" + id + "'AND mobile_no='" + s + "'");
                if (rs.next()) {
                    fg = 1;
                    s1 = rs.getString("passenger_name");
                    s2 = rs.getString("mobile_no");
                    s3 = rs.getString("bus_name");
                    s4 = rs.getString("bus_type");
                    s5 = rs.getString("seat_formation");
                    s6 = rs.getString("booked_seat");
                    s7 = rs.getString("start");
                    s8 = rs.getString("destination");
                    s9 = rs.getString("departure_time");
                    s11 = rs.getString("date_of_journey");
                    s10 = rs.getInt("fare");
                    s12=rs.getString("boardingpoint");


                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (fg == 1) {

                Parent root = FXMLLoader.load(getClass().getResource("final.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                warninglabel.setText("Sorry!Entry Not Found");
            }

        }

        
    }

}
