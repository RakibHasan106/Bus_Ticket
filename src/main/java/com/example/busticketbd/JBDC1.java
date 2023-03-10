package com.example.busticketbd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

import static com.example.busticketbd.Controller2.*;
import static com.example.busticketbd.Controller3.*;

public class JBDC1 {


    public static ObservableList<User> get_connect() {
        ObservableList<User> list = FXCollections.observableArrayList();
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_info", "root", "Keno Dure Thako");

            Statement statement = connection.createStatement();
            ResultSet rs;
            if (trace == -1) {
                if (flag == 0) {
                    rs = statement.executeQuery("SELECT * FROM bus_info.new_table where startingpoint='" + s1 + "'AND destination='" + s2 + "'");
                    while (rs.next()) {
                        list.add(new User(rs.getString("bus name"), rs.getString("bus specification"), rs.getString("bustype"), rs.getString("seat formation"), rs.getString("startingpoint"), rs.getString("destination"), rs.getString("departure time"), rs.getInt("available seat"), rs.getInt("fare"), rs.getInt("id")));
                    }

                } else if (flag == 1) {
                    rs = statement.executeQuery("SELECT * FROM bus_info.new_table where startingpoint='" + s1 + "'AND destination='" + s2 + "'AND bustype='" + nc + "'");
                    while (rs.next()) {
                        list.add(new User(rs.getString("bus name"), rs.getString("bus specification"), rs.getString("bustype"), rs.getString("seat formation"), rs.getString("startingpoint"), rs.getString("destination"), rs.getString("departure time"), rs.getInt("available seat"), rs.getInt("fare"), rs.getInt("id")));
                    }
                } else if (flag == 2) {
                    rs = statement.executeQuery("SELECT * FROM bus_info.new_table where startingpoint='" + s1 + "'AND destination='" + s2 + "'AND bustype='" + a + "'");
                    while (rs.next()) {
                        list.add(new User(rs.getString("bus name"), rs.getString("bus specification"), rs.getString("bustype"), rs.getString("seat formation"), rs.getString("startingpoint"), rs.getString("destination"), rs.getString("departure time"), rs.getInt("available seat"), rs.getInt("fare"), rs.getInt("id")));
                    }
                }
            }
            else if(trace==1){
                Statement statement1=connection.createStatement();
                ResultSet rs1;
                if(flag==0){
                    rs = statement.executeQuery("SELECT * FROM bus_info.new_table where startingpoint='" + s1 + "'AND destination='" + s2 + "'");
                    while(rs.next()){
                        int new_id=rs.getInt("id");
                        rs1 = statement1.executeQuery("Select * From bus_info.info_table where bus_id='" + new_id + "'");
                        int new_seat=0;
                        if(rs1.next()){
                            new_seat=rs1.getInt("remaining_seat");
                            while(rs1.next()){
                                new_seat=rs1.getInt("remaining_seat");

                            }
                            list.add(new User(rs.getString("bus name"), rs.getString("bus specification"), rs.getString("bustype"), rs.getString("seat formation"), rs.getString("startingpoint"), rs.getString("destination"), rs.getString("departure time"),new_seat, rs.getInt("fare"), rs.getInt("id")));
                        }
                        else{
                            list.add(new User(rs.getString("bus name"), rs.getString("bus specification"), rs.getString("bustype"), rs.getString("seat formation"), rs.getString("startingpoint"), rs.getString("destination"), rs.getString("departure time"), rs.getInt("available seat"), rs.getInt("fare"), rs.getInt("id")));
                        }

                    }
                }
                else if(flag==1){
                    rs = statement.executeQuery("SELECT * FROM bus_info.new_table where startingpoint='" + s1 + "'AND destination='" + s2 + "'AND bustype='" + nc + "'");
                    while(rs.next()){
                        int new_id=rs.getInt("id");
                        rs1 = statement1.executeQuery("Select * From bus_info.info_table where bus_id='" + new_id + "'");
                        int new_seat=0;
                        if(rs1.next()){
                            new_seat=rs1.getInt("remaining_seat");
                            while(rs1.next()){
                                new_seat=rs1.getInt("remaining_seat");
                            }
                            list.add(new User(rs.getString("bus name"), rs.getString("bus specification"), rs.getString("bustype"), rs.getString("seat formation"), rs.getString("startingpoint"), rs.getString("destination"), rs.getString("departure time"),new_seat, rs.getInt("fare"), rs.getInt("id")));
                        }
                        else{
                            list.add(new User(rs.getString("bus name"), rs.getString("bus specification"), rs.getString("bustype"), rs.getString("seat formation"), rs.getString("startingpoint"), rs.getString("destination"), rs.getString("departure time"), rs.getInt("available seat"), rs.getInt("fare"), rs.getInt("id")));
                        }

                    }

                }
                else if(flag==2){
                    rs = statement.executeQuery("SELECT * FROM bus_info.new_table where startingpoint='" + s1 + "'AND destination='" + s2 + "'AND bustype='" + a + "'");
                    while(rs.next()){
                        int new_id=rs.getInt("id");
                        rs1 = statement1.executeQuery("Select * From bus_info.info_table where bus_id='" + new_id + "'");
                        int new_seat=0;
                        if(rs1.next()){
                            new_seat=rs1.getInt("remaining_seat");
                            while(rs1.next()){
                                new_seat=rs1.getInt("remaining_seat");
                            }
                            list.add(new User(rs.getString("bus name"), rs.getString("bus specification"), rs.getString("bustype"), rs.getString("seat formation"), rs.getString("startingpoint"), rs.getString("destination"), rs.getString("departure time"),new_seat, rs.getInt("fare"), rs.getInt("id")));
                        }
                        else{
                            list.add(new User(rs.getString("bus name"), rs.getString("bus specification"), rs.getString("bustype"), rs.getString("seat formation"), rs.getString("startingpoint"), rs.getString("destination"), rs.getString("departure time"), rs.getInt("available seat"), rs.getInt("fare"), rs.getInt("id")));
                        }

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
