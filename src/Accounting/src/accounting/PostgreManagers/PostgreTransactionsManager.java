/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.PostgreManagers;

import accounting.Interfaces.ITransactionsManager;
import accounting.Models.Transaction;
import static accounting.PostgreManagers.PostgreModule.CONECTION_STRING;
import static accounting.PostgreManagers.PostgreModule.PASSWORD;
import static accounting.PostgreManagers.PostgreModule.USERNAME;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class PostgreTransactionsManager implements ITransactionsManager{

    @Override
    public void addTransaction(Date date, double productAmount, int documentId, int productId, int destinationId, int employeeId, int operationId){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO transaction (date, product_amount, document_id, product_id, destination_id, employee_id, operation_id) VALUES (?,?,?,?,?,?,?)");
            prepSt.setDate(1, date);
            prepSt.setDouble(2, productAmount);
            prepSt.setInt(3, documentId);
            prepSt.setInt(4, productId);
            prepSt.setInt(5, destinationId);
            prepSt.setInt(6, employeeId);
            prepSt.setInt(7, operationId);
            prepSt.executeUpdate();
        }catch(SQLException e){}
    }

    @Override
    public Transaction getTransactionById(int id) {
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
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
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
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
