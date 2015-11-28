/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;

import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.interfaces.IAccountsServices;
import com.accounting.interfaces.IProductUnitsServices;
import com.accounting.models.Account;
import com.accounting.models.ProductUnit;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author vasiliy
 */
public class ProductUnitComboBoxModel extends DefaultComboBoxModel<ProductUnit>{

    public ProductUnitComboBoxModel() {
        super();
    }

    @Override
    public ProductUnit getSelectedItem() {
        return (ProductUnit)super.getSelectedItem();
    }
    
    public void update(){
        IProductUnitsServices productUnitsServices = null;
        try{
            productUnitsServices = RemoteServicesProvider.getInstance().<IProductUnitsServices>getServices(IProductUnitsServices.class);
        }catch(NotSupportedServicesException e){
            System.err.println("NotSupportedServicesException");
        }
        
        if(null != productUnitsServices){
            this.removeAllElements();
            for(ProductUnit productUnit: productUnitsServices.getAllProductUnits())
                this.addElement(productUnit);
        }
    }
}
