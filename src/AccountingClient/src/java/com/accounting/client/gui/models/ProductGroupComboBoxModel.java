/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
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
}
