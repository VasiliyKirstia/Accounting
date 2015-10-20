/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Services;

import accounting.Interfaces.ICurrencysManager;
import accounting.Models.Currency;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class CurrencysManager implements ICurrencysManager{
    
    @Override
    public void addCurrency(Connection con, String currencyName) throws SQLException {
        PreparedStatement prepSt = con.prepareStatement("INSERT INTO currency (name) VALUES (?)");
        prepSt.setString(1, currencyName);
        prepSt.executeUpdate();
    }

    @Override
    public Currency getCurrencyById(Connection con, int id) throws SQLException {
        PreparedStatement prepSt = con.prepareStatement("SELECT * FROM currency WHERE id = ?");
        prepSt.setInt(1, id);
        ResultSet resultSet = prepSt.executeQuery();
        
        if(resultSet.next()){
            return new Currency(resultSet.getInt("id"), resultSet.getString("name") );
        }else{
            return null;
        }
    }

    @Override
    public List<Currency> getAllCurrencis(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM currency");
        List<Currency> currencis = new LinkedList<Currency>();
        while(resultSet.next()){
            currencis.add(new Currency(resultSet.getInt("id"), resultSet.getString("name")));
        }
        return currencis;
    }
    
}
