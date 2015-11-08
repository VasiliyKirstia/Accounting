/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.server.services;

import javax.ejb.Stateless;
import com.accounting.interfaces.IOperationsServices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.accounting.models.Operation;
import static com.accounting.server.services.Setings.CONECTION_STRING;
import static com.accounting.server.services.Setings.PASSWORD;
import static com.accounting.server.services.Setings.USERNAME;

/**
 *
 * @author vasiliy
 */
@Stateless
public class OperationsServices implements IOperationsServices{
@Override
    public void addOperation(String operationName){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO operation (name) VALUES (?)");
            prepSt.setString(1, operationName);
            prepSt.executeUpdate();
        }catch(SQLException e){}
    }

    @Override
    public Operation getOperationById(int id){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("SELECT * FROM operation WHERE id = ?");
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new Operation(resultSet.getInt("id"), resultSet.getString("name") );
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<Operation> getAllOperations(){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM operation");
            List<Operation> operations = new LinkedList<Operation>();
            while(resultSet.next()){
                operations.add(new Operation(resultSet.getInt("id"), resultSet.getString("name")));
            }
            return operations;
        }catch(SQLException e){
            return null;
        }
    }
}