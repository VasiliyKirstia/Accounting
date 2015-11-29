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
            PreparedStatement prepSt = con.prepareStatement(
                "SELECT tran.id AS id, tran.date AS date, tran.product_amount AS amount, op.name AS op_name, "+
                "prod.name AS prod_name, dest.name AS dest_name, emp.name AS emp_name, doc.name AS doc_name "+
                "FROM transaction AS tran "+
                "INNER JOIN operation AS op ON tran.operation_id = op.id "+
                "INNER JOIN product AS prod ON tran.product_id = prod.id "+
                "INNER JOIN destination AS dest ON tran.destination_id = dest.id "+
                "INNER JOIN employee AS emp ON tran.employee_id = emp.id "+
                "INNER JOIN document AS doc ON tran.document_id = doc.id "+
                "WHERE tran.id = ?;"
            );
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new Transaction(
                    resultSet.getInt("id"),
                    resultSet.getDate("date"),
                    resultSet.getDouble("amount"),
                    resultSet.getString("doc_name"),
                    resultSet.getString("prod_name"),
                    resultSet.getString("dest_name"),
                    resultSet.getString("emp_name"),
                    resultSet.getString("op_name")
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
            ResultSet resultSet = st.executeQuery(
                "SELECT tran.id AS id, tran.date AS date, tran.product_amount AS amount, op.name AS op_name, " +
                "prod.name AS prod_name, dest.name AS dest_name, emp.name AS emp_name, doc.name AS doc_name " +
                "FROM transaction AS tran " +
                "INNER JOIN operation AS op ON tran.operation_id = op.id " +
                "INNER JOIN product AS prod ON tran.product_id = prod.id " +
                "INNER JOIN destination AS dest ON tran.destination_id = dest.id " +
                "INNER JOIN employee AS emp ON tran.employee_id = emp.id " +
                "INNER JOIN document AS doc ON tran.document_id = doc.id;" 
            );
            List<Transaction> transactions = new LinkedList<Transaction>();
            while(resultSet.next()){
                transactions.add(
                    new Transaction(
                        resultSet.getInt("id"),
                        resultSet.getDate("date"),
                        resultSet.getDouble("amount"),
                        resultSet.getString("doc_name"),
                        resultSet.getString("prod_name"),
                        resultSet.getString("dest_name"),
                        resultSet.getString("emp_name"),
                        resultSet.getString("op_name")
                    )
                );
            }
            return transactions;
        }catch(SQLException e){
            return null;
        }
    }

}
