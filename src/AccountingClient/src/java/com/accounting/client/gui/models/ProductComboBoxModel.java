/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.interfaces.IAccountsServices;
import com.accounting.interfaces.IProductsServices;
import com.accounting.models.Account;
import com.accounting.models.Operation;
import com.accounting.models.Product;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author vasiliy
 */
public class ProductComboBoxModel extends DefaultComboBoxModel<Product>{

    public ProductComboBoxModel() {
        super();
    }

    @Override
    public Product getSelectedItem() {
        return (Product)super.getSelectedItem(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void update(){
        IProductsServices productsServices = null;
        try{
            productsServices = RemoteServicesProvider.getInstance().<IProductsServices>getServices(IProductsServices.class);
        }catch(NotSupportedServicesException e){
            System.err.println("NotSupportedServicesException");
        }
        
        if(null != productsServices){
            this.removeAllElements();
            for(Product product: productsServices.getAllProducts())
                this.addElement(product);
        }
    }
}
