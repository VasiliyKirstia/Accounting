/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.PostgreManagers;

import accounting.Interfaces.IOperationsManager;
import accounting.Models.Operation;
import java.util.List;

import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author vasiliy
 */
public class PostgreOperationsManager implements IOperationsManager{

    @Override
    public void addOperation(Connection con, String operationName) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("INSERT INTO operation (name) VALUES (?)");
        prepSt.setString(1, operationName);
        prepSt.executeUpdate();
    }

    @Override
    public Operation getOperationById(Connection con, int id) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("SELECT * FROM operation WHERE id = ?");
        prepSt.setInt(1, id);
        ResultSet resultSet = prepSt.executeQuery();
        
        if(resultSet.next()){
            return new Operation(resultSet.getInt("id"), resultSet.getString("name") );
        }else{
            return null;
        }
    }

    @Override
    public List<Operation> getAllOperations(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM operation");
        List<Operation> operations = new LinkedList<Operation>();
        while(resultSet.next()){
            operations.add(new Operation(resultSet.getInt("id"), resultSet.getString("name")));
        }
        return operations;
    }
    
}
