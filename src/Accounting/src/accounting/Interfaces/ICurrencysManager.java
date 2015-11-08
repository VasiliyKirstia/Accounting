/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Currency;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface ICurrencysManager {
    public void addCurrency(String currencyName);
    public Currency getCurrencyById(int id);
    
    //TODO: в названии этого метода нужно проверить орфографию 
    public List<Currency> getAllCurrencis();
}
