/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.PostgreManagers;

import accounting.Interfaces.ICurrencysManager;
import accounting.Models.Currency;
import static accounting.PostgreManagers.PostgreModule.CONECTION_STRING;
import static accounting.PostgreManagers.PostgreModule.PASSWORD;
import static accounting.PostgreManagers.PostgreModule.USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class PostgreCurrencysManager implements ICurrencysManager{
    
    @Override
    public void addCurrency(String currencyName){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO currency (name) VALUES (?)");
            prepSt.setString(1, currencyName);
            prepSt.executeUpdate();
        }
        catch(SQLException e){}
    }

    @Override
    public Currency getCurrencyById(int id){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
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
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
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
