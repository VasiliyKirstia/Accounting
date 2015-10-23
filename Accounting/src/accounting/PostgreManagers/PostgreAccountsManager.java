/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.PostgreManagers;

import accounting.Interfaces.IAccountsManager;
import accounting.Models.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import static accounting.PostgreManagers.PostgreModule.*;
import java.sql.SQLException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


//

/**
 *
 * @author vasiliy
 */
public class PostgreAccountsManager implements IAccountsManager{
    
    @Override
    public void addAccount(String accountNumber) {
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO account (account_number) VALUES (?)");
            prepSt.setString(1, accountNumber);
            prepSt.executeUpdate();
        }
        catch(SQLException e){
            ;
        }
    }

    @Override
    public Account getAccountById(int id) {
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("SELECT * FROM account WHERE id = ?");
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new Account(resultSet.getInt("id"), resultSet.getString("account_number"));
            }else{
                return null;
            }
        }
        catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM account");
            List<Account> accounts = new LinkedList<Account>();
            while(resultSet.next()){
                accounts.add(new Account(resultSet.getInt("id"), resultSet.getString("account_number")));
            }
            return accounts;
        }
        catch(SQLException e){
            return null;
        }
    }
}
