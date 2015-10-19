/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Services;

import accounting.Interfaces.ICurrencyService;
import accounting.Models.Currency;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class CurrencyService implements ICurrencyService{
    
    @Override
    public void addCurrency(Connection con, String currencyName) throws SQLException {
        PreparedStatement prepSt = con.prepareStatement("INSERT INTO currency (name) VALUES (?)");
        prepSt.setString(1, currencyName);
        prepSt.executeUpdate();
    }

    @Override
    public Currency getCurrencyById(Connection con, int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Currency> getAllCurrencis(Connection con) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
