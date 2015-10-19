/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Currency;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface ICurrencyService {
    public void addCurrency(Connection con, String currencyName) throws Exception;
    public Currency getCurrencyById(Connection con, int id) throws Exception;
    
    //TODO: в названии этого метода нужно проверить орфографию 
    public List<Currency> getAllCurrencis(Connection con) throws Exception;
}
