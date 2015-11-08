/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
import com.accounting.models.Account;
import javax.swing.DefaultComboBoxModel;

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
}
