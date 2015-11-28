/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.interfaces.IAccountsServices;
import com.accounting.interfaces.IProductGroupsServices;
import com.accounting.models.Account;
import com.accounting.models.ProductGroup;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author vasiliy
 */
public class ProductGroupComboBoxModel extends DefaultComboBoxModel<ProductGroup>{
    public ProductGroupComboBoxModel() {
        super();
    }

    @Override
    public ProductGroup getSelectedItem() {
        return (ProductGroup)super.getSelectedItem();
    }
    
    public void update(){
        IProductGroupsServices productGroupsServices = null;
        try{
            productGroupsServices = RemoteServicesProvider.getInstance().<IProductGroupsServices>getServices(IProductGroupsServices.class);
        }catch(NotSupportedServicesException e){
            System.err.println("NotSupportedServicesException");
        }
        
        if(null != productGroupsServices){
            this.removeAllElements();
            for(ProductGroup productGroup: productGroupsServices.getAllProductGroups())
                this.addElement(productGroup);
        }
    }
}
