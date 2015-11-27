/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.server.services;

import com.accounting.server.Settings;
import javax.ejb.Stateless;
import com.accounting.interfaces.ICurrencysServices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.accounting.models.Currency;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vasiliy
 */
@Stateless
//@Remote(ICurrencysServices.class)
public class CurrencysServices implements  ICurrencysServices{

    @Override
    public void addCurrency(String currencyName){
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO currency (name) VALUES (?)");
            prepSt.setString(1, currencyName);
            prepSt.executeUpdate();
        }
        catch(SQLException e){}
    }

    @Override
    public Currency getCurrencyById(int id){
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            PreparedStatement prepSt = con.prepareStatement("SELECT * FROM currency WHERE id = ?");
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new Currency(resultSet.getInt("id"), resultSet.getString("name") );
            }else{
                return null;
            }
        }
        catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<Currency> getAllCurrencis(){
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM currency");
            List<Currency> currencis = new LinkedList<Currency>();
            while(resultSet.next()){
                currencis.add(new Currency(resultSet.getInt("id"), resultSet.getString("name")));
            }
            return currencis;
        }catch(SQLException e){
            return null;
        }
    }
}
