package com.example.busticketbd;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller3 implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchfromscene3toscene2(ActionEvent event) throws IOException{
        Parent root= FXMLLoader.load(getClass().getResource("FXML2.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private TableColumn<User,Integer> AvailableSeat;

    @FXML
    private TableColumn<User,String> BusName;

    @FXML
    private TableColumn<User,String> BusSpecification;

    @FXML
    private TableColumn<User,String> BusType;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;


    @FXML
    private TableColumn<User,String> DepartureTime;

    @FXML
    private TableColumn<User,Integer> Fare;


    @FXML
    private TableColumn<User,String> From;



    @FXML
    private AnchorPane SCENE3;

    @FXML
    private TableColumn<User,String> SeatFormation;

    @FXML
    private TableView<User> Table1;




    @FXML
    private Label TextLabel5;

    @FXML
    private Label TextLabel6;

    @FXML
    private Label Label_temp;


    @FXML
    private TableColumn<User,String> To;


    @FXML
    private RadioButton ac;

    @FXML
    private RadioButton all;

    @FXML
    private RadioButton nonac;

    @FXML
    private TableColumn<User,Integer> ID;

    @FXML
    private Label warninglabel;


    ObservableList<User> list;


    public static int flag=0;
    public static String a="AC",nc="Non Ac";



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BusName.setCellValueFactory(new PropertyValueFactory<User,String>("BusName"));
        BusSpecification.setCellValueFactory(new PropertyValueFactory<User,String>("BusSpecification"));
        BusType.setCellValueFactory(new PropertyValueFactory<User,String>("BusType"));
        SeatFormation.setCellValueFactory(new PropertyValueFactory<User,String>("SeatFormation"));
        From.setCellValueFactory(new PropertyValueFactory<User,String>("From"));
        To.setCellValueFactory(new PropertyValueFactory<User,String>("To"));
        DepartureTime.setCellValueFactory(new PropertyValueFactory<User,String>("DepartureTime"));
        AvailableSeat.setCellValueFactory(new PropertyValueFactory<User,Integer>("AvailableSeat"));
        Fare.setCellValueFactory(new PropertyValueFactory<User,Integer>("Fare"));
        ID.setCellValueFactory(new PropertyValueFactory<User,Integer>("ID"));
        list=JBDC1.get_connect();
        if(list.isEmpty()){
          warninglabel.setText("Sorry!no bus is available for this route");
        }
        Table1.setItems(list);




    }

    public void checkevent(ActionEvent event){
        if(nonac.isSelected()){
            flag=1;
            list=JBDC1.get_connect();
            Table1.setItems(list);
        }

        else if(ac.isSelected()){
            flag=2;
            list=JBDC1.get_connect();
            Table1.setItems(list);
        }
        else if(all.isSelected()){
            flag=0;
            list=JBDC1.get_connect();
            Table1.setItems(list);
        }
    }







    Integer index;
    public static String seat_form;

    public static int seat=0;
    public static long fare=0;
    public static String operator;
    public static String bus_type;
    public static String starting_point;
    public static String ending_point;
    public static String departuretime;

    public static int track;
    public static int id;


    public void getItem(ActionEvent event) throws IOException {
        index=Table1.getSelectionModel().getSelectedIndex();
        if(index==-1){
            Label_temp.setText("Please Select a specific operator");
            return;
        }
        seat_form=SeatFormation.getCellData(index);
        fare=Fare.getCellData(index);
        seat=AvailableSeat.getCellData(index);
        operator=BusName.getCellData(index);
        bus_type=BusType.getCellData(index);
        starting_point=From.getCellData(index);
        ending_point=To.getCellData(index);
        departuretime=DepartureTime.getCellData(index);
        id=ID.getCellData(index);

            if (Objects.equals(seat_form, "Economy Class")) {
                track = 1;
                Parent root = FXMLLoader.load(getClass().getResource("FXML4.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else if (Objects.equals(seat_form, "Business Class")) {
                track = 2;
                Parent root = FXMLLoader.load(getClass().getResource("FXML5.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                track=3;
                Parent root = FXMLLoader.load(getClass().getResource("FXML6.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
}





