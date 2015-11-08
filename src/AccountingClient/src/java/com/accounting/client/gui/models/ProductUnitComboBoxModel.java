/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;

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
}
