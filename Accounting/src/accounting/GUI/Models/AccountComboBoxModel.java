/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.GUI.Models;

import javax.swing.DefaultComboBoxModel;
import accounting.Models.Account;

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
