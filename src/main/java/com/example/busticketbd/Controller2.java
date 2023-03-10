package com.example.busticketbd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Controller2  {

    @FXML
    private Button BUTTON2;

    @FXML
    private DatePicker DATEPICKER1;

    @FXML
    private AnchorPane SCENE2;

    @FXML
    private TextField TEXTFIELD1;

    @FXML
    private TextField TEXTFIELD2;

    @FXML
    private Label TEXTLABEL2;

    @FXML
    private Label TEXTLABEL3;

    @FXML
    private Label TEXTLABEL4;


    @FXML
    private Button BUTTON21;

    @FXML
    private Label warninglabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static String s1,s2,date;
    public static int trace;






    public void switchtoscene3(ActionEvent event) throws IOException {
        if((TEXTFIELD1.getText() == null || TEXTFIELD1.getText().trim().isEmpty()) ||(TEXTFIELD2.getText() == null || TEXTFIELD2.getText().trim().isEmpty())){
            warninglabel.setText("Please fill up all required fields");
        }
        else {
            s1 = TEXTFIELD1.getText();
            s2 = TEXTFIELD2.getText();
            LocalDate mydate = DATEPICKER1.getValue();
            LocalDate currentdate = LocalDate.now();
            if (currentdate.compareTo(mydate) > 0) {
                warninglabel.setText("Sorry!No bus is available for this date");
            } else {
                date = mydate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                Connection connection = null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_info", "root", "Keno Dure Thako");
                    Statement statement = connection.createStatement();
                    ResultSet rs;
                    rs = statement.executeQuery("Select * From bus_info.info_table where date_of_journey='" + date + "'");
                    if (rs.next()) {
                        trace = 1;
                    } else {
                        trace = -1;
                    }


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                Parent root = FXMLLoader.load(getClass().getResource("FXML3.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }

    }

    public void swithctotemp(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("temp.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
