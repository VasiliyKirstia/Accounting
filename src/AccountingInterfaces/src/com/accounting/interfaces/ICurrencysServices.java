/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.interfaces;

import com.accounting.models.Currency;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Vasiliy Kirstia
 */
@Remote
public interface ICurrencysServices {
    public void addCurrency(String currencyName);
    public Currency getCurrencyById(int id);
    
    //TODO: в названии этого метода нужно проверить орфографию 
    public List<Currency> getAllCurrencis();
}
