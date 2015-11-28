/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.interfaces.ICurrencysServices;
import com.accounting.models.Currency;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author vasiliy
 */
public class CurrencyComboBoxModel extends DefaultComboBoxModel<Currency>{

    public CurrencyComboBoxModel() {
        super();
    }

    @Override
    public Currency getSelectedItem() {
        return  (Currency)super.getSelectedItem(); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(){
        ICurrencysServices currencysServices = null;
        try{
            currencysServices = RemoteServicesProvider.getInstance().<ICurrencysServices>getServices(ICurrencysServices.class);
        }catch(NotSupportedServicesException e){
            System.err.println("NotSupportedServicesException");
        }
        
        if(null != currencysServices){
            this.removeAllElements();
            for(Currency currency: currencysServices.getAllCurrencis())
                this.addElement(currency);
        }
    }    
}
