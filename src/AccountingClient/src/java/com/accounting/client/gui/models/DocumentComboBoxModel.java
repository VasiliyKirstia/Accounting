/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
import javax.swing.DefaultComboBoxModel;
import com.accounting.models.Document;

/**
 *
 * @author vasiliy
 */
public class DocumentComboBoxModel extends DefaultComboBoxModel<Document>{

    public DocumentComboBoxModel() {
        super();
    }

    @Override
    public Document getSelectedItem() {
        return (Document)super.getSelectedItem();
    }    
}
