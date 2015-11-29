/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.verifiers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author vasiliy
 */
public class StringVerifier extends InputVerifier{
    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText().trim();
        return !text.isEmpty();
    }
    
    @Override
    public boolean shouldYieldFocus(JComponent input) {
        boolean valid = verify(input);
        if (!valid) {
           JOptionPane.showMessageDialog(null, "Поле должно содержать не пустую строку.");
        }
        return valid;
    }
}
