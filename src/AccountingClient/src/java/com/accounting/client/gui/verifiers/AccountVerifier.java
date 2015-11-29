/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.verifiers;

import javax.swing.InputVerifier;
import java.util.regex.*;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author vasiliy
 */
public class AccountVerifier extends InputVerifier{

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        return Pattern.matches("^[0-9]{20}$", text);
    }
    
    @Override
    public boolean shouldYieldFocus(JComponent input) {
        boolean valid = verify(input);
        if (!valid) {
           JOptionPane.showMessageDialog(null, "Номер счета должен состоять только из 20-ти цифр.");
        }
        return valid;
    }
}
