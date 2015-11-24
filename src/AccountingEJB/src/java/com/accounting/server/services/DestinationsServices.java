/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.server.services;

import javax.ejb.Stateless;
import com.accounting.interfaces.IDestinationsServices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.accounting.models.Destination;

/**
 *
 * @author vasiliy
 */
@Stateless
public class DestinationsServices implements IDestinationsServices{
@Override
    public void addDestination(String destinationName){
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO destination (name) VALUES (?)");
            prepSt.setString(1, destinationName);
            prepSt.executeUpdate();
        }
        catch(SQLException e){}
    }

    @Override
    public Destination getDestinationyById(int id){
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            PreparedStatement prepSt = con.prepareStatement("SELECT * FROM destination WHERE id = ?");
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new Destination(resultSet.getInt("id"), resultSet.getString("name") );
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<Destination> getAllDestinations(){
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM destination");
            List<Destination> destinations = new LinkedList<Destination>();
            while(resultSet.next()){
                destinations.add(new Destination(resultSet.getInt("id"), resultSet.getString("name")));
            }
            return destinations;
        }catch(SQLException e){
            return null;
        }
    }
}
