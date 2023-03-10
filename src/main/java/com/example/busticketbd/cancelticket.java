package com.example.busticketbd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class cancelticket {

    @FXML
    private Button bt1;

    @FXML
    private Button bt2;

    @FXML
    private Label warninglabel;



    @FXML
    private TextField pnr;

    @FXML
    private TextField mobile;


    private Stage stage;
    private Scene scene;
    private Parent root;
    int i,j,k,identity,sum=0;
    String journey;
    @FXML
    void switchtotemp(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("temp.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        if((pnr.getText() == null || pnr.getText().trim().isEmpty()) ||(mobile.getText() == null || mobile.getText().trim().isEmpty())){
            warninglabel.setText("Please fill up all required fields");
        }
        else {
            String s;
            s = pnr.getText();
            int temp = Integer.parseInt(s);
            int id = (temp - 125) / 1000;
            s = mobile.getText();
            int flag = 0;
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_info", "root", "Keno Dure Thako");
                Statement statement = connection.createStatement();
                ResultSet rs;
                rs = statement.executeQuery("SELECT * FROM bus_info.info_table where pnr='" + id + "'AND mobile_no='" + s + "'");
                if (rs.next()) {
                    i=rs.getInt("total_seat");
                    journey=rs.getString("date_of_journey");
                    identity=rs.getInt("bus_id");
                    ResultSet rs1=statement.executeQuery("SELECT * FROM bus_info.info_table where bus_id ='" + identity +"'AND date_of_journey='" + journey + "'");
                    while(rs1.next()){
                        sum=sum+rs1.getInt("total_seat");
                    }
                    k=sum-i;
                    ResultSet rs2=statement.executeQuery("SELECT * FROM bus_info.new_table where id='" + identity+"'");
                    if(rs2.next()){
                        k=rs2.getInt("available seat")-k;
                    }
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialogue");
                    Image icon = new Image("PIC1.png");
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(icon);
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure you want to cancel reservation?");
                    ButtonType bt1 = new ButtonType("Yes");
                    ButtonType bt2 = new ButtonType("No");
                    alert.getButtonTypes().setAll(bt1, bt2);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == bt1) {
                        flag=1;
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        Image icon1 = new Image("PIC1.png");
                        Stage stage1 = (Stage) alert1.getDialogPane().getScene().getWindow();
                        stage1.getIcons().add(icon1);
                        alert1.setContentText("Your ticket has been cancelled.");
                        ButtonType bt = new ButtonType("Ok");
                        alert1.getButtonTypes().setAll(bt);
                        Optional<ButtonType> result1 = alert1.showAndWait();
                        Statement statement1 = connection.createStatement();
                        statement1.executeUpdate("DELETE FROM bus_info.info_table where pnr='" + id + "'");
                        Statement statement2=connection.createStatement();
                        statement2.executeUpdate("update bus_info.info_table set remaining_seat='" + k +"'where date_of_journey='" + journey +"'AND bus_id='" + identity +"'");
                    }
                    else if(result.get()==bt2){
                        flag=2;
                    }

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (flag == 1) {
                Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else if(flag==0){
                warninglabel.setText("Sorry!Entry Not Found");
            }

        }


    }

}