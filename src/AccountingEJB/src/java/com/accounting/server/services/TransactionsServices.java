/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.server.services;

import com.accounting.server.Settings;
import javax.ejb.Stateless;
import com.accounting.interfaces.ITransactionsServices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.accounting.models.Transaction;

/**
 *
 * @author vasiliy
 */
@Stateless
public class TransactionsServices implements ITransactionsServices{
    
    @Override
    public Transaction getTransactionById(int id) {
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            PreparedStatement prepSt = con.prepareStatement("SELECT * FROM transaction WHERE id = ?");
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new Transaction(
                    resultSet.getInt("id"),
                    resultSet.getDate("date"),
                    resultSet.getDouble("product_amount"),
                    resultSet.getInt("document_id"),
                    resultSet.getInt("product_id"),
                    resultSet.getInt("destination_id"),
                    resultSet.getInt("employee_id"),
                    resultSet.getInt("operation_id")
                );
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM transaction");
            List<Transaction> transactions = new LinkedList<Transaction>();
            while(resultSet.next()){
                transactions.add(
                    new Transaction(
                        resultSet.getInt("id"),
                        resultSet.getDate("date"),
                        resultSet.getDouble("product_amount"),
                        resultSet.getInt("document_id"),
                        resultSet.getInt("product_id"),
                        resultSet.getInt("destination_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getInt("operation_id")
                    )
                );
            }
            return transactions;
        }catch(SQLException e){
            return null;
        }
    }

}
