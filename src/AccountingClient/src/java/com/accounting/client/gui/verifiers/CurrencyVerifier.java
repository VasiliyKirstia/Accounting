/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.verifiers;

import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author vasiliy
 */
public class CurrencyVerifier extends InputVerifier{
    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        return Pattern.matches("^[A-Z]{3}$", text);
    }
    
    @Override
    public boolean shouldYieldFocus(JComponent input) {
        boolean valid = verify(input);
        if (!valid) {
           JOptionPane.showMessageDialog(null, "Код валюты должен состоять из 3-х заглавных латинских букв.");
        }
        return valid;
    }
}
