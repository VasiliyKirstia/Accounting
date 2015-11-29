/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client;

import com.accounting.client.utils.WindowsFactory;

/**
 *
 * @author vasiliy
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WindowsFactory.createFrame(new com.accounting.client.gui.ProductsView(), "Главное окно");
    }
}
