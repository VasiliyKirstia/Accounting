/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Services;

import accounting.Interfaces.IDestinationService;
import accounting.Models.Currency;
import accounting.Models.Destination;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class DestinationService implements IDestinationService{

    @Override
    public void addDestination(Connection con, String destinationName) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("INSERT INTO destination (name) VALUES (?)");
        prepSt.setString(1, destinationName);
        prepSt.executeUpdate();
    }

    @Override
    public Destination getDestinationyById(Connection con, int id) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("SELECT * FROM destination WHERE id = ?");
        prepSt.setInt(1, id);
        ResultSet resultSet = prepSt.executeQuery();
        
        if(resultSet.next()){
            return new Destination(resultSet.getInt("id"), resultSet.getString("name") );
        }else{
            return null;
        }
    }

    @Override
    public List<Destination> getAllDestinations(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM destination");
        List<Destination> destinations = new LinkedList<Destination>();
        while(resultSet.next()){
            destinations.add(new Destination(resultSet.getInt("id"), resultSet.getString("name")));
        }
        return destinations;
    }
    
}
