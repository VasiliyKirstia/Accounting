/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting;

import accounting.PostgreManagers.PostgreModule;
import accounting.GUI.Main;
import accounting.GUI.ProductAdditionMaster;
import java.sql.*;
import accounting.Interfaces.*;
import accounting.Models.Currency;
import com.google.inject.Guice;
import java.util.List;
import com.google.inject.Injector;
import accounting.GUI.WindowsFactory;
import com.sun.org.apache.bcel.internal.generic.InstructionConstants;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Vasiliy Kirstia
 */
public class Accounting {
    private static Connection connection;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WindowsFactory.createFrame(new Main(), "Главное окно");
    }
    
}
