/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
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
}
