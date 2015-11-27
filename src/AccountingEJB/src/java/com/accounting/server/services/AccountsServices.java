/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.server.services;

import com.accounting.server.Settings;
import javax.ejb.Stateless;
import com.accounting.interfaces.IAccountsServices;
import com.accounting.models.Account;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author vasiliy
 */
@Stateless
public class AccountsServices implements IAccountsServices {

    @Override
    public void addAccount(String accountNumber) {
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
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
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
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
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
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
