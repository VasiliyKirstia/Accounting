/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting;

import accounting.GUI.Main;
import java.sql.*;
import accounting.GUI.WindowsFactory;

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
