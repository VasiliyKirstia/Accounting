/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Services;

import accounting.Interfaces.IAccountsManager;
import accounting.Models.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class AccountsManager implements IAccountsManager{

    @Override
    public void addAccount(Connection con, String accountNumber) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("INSERT INTO account (account_number) VALUES (?)");
        prepSt.setString(1, accountNumber);
        prepSt.executeUpdate();
    }

    @Override
    public Account getAccountById(Connection con, int id) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("SELECT * FROM account WHERE id = ?");
        prepSt.setInt(1, id);
        ResultSet resultSet = prepSt.executeQuery();
        
        if(resultSet.next()){
            return new Account(resultSet.getInt("id"), resultSet.getString("account_number"));
        }else{
            return null;
        }
    }

    @Override
    public List<Account> getAllAccounts(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM account");
        List<Account> accounts = new LinkedList<Account>();
        while(resultSet.next()){
            accounts.add(new Account(resultSet.getInt("id"), resultSet.getString("account_number")));
        }
        return accounts;
    }
    
}
