/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.models.Account;
import javax.swing.DefaultComboBoxModel;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.interfaces.IAccountsServices;

/**
 *
 * @author vasiliy
 */
public class AccountComboBoxModel extends DefaultComboBoxModel<Account>{

    public AccountComboBoxModel() {
        super();
    }

    @Override
    public Account getSelectedItem() {
        return (Account)super.getSelectedItem();
    }
    
    public void update(){
        IAccountsServices accountsServices = null;
        try{
            accountsServices = RemoteServicesProvider.getInstance().<IAccountsServices>getServices(IAccountsServices.class);
        }catch(NotSupportedServicesException e){
            System.err.println("NotSupportedServicesException");
        }
        
        if(null != accountsServices){
            this.removeAllElements();
            for(Account account: accountsServices.getAllAccounts())
                this.addElement(account);
        }
    }
}
