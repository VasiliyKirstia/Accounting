/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
import com.accounting.models.Operation;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author vasiliy
 */
public class ProductComboBoxModel extends DefaultComboBoxModel<Operation>{

    public ProductComboBoxModel() {
        super();
    }

    @Override
    public Operation getSelectedItem() {
        return (Operation)super.getSelectedItem(); //To change body of generated methods, choose Tools | Templates.
    }
}
