/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting;

import java.sql.*;
import accounting.Interfaces.*;
import accounting.Models.Currency;
import com.google.inject.Guice;
import java.util.List;
import com.google.inject.Injector;
import accounting.GUI.Window;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Vasiliy Kirstia
 */
public class Accounting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*PostgreModule psm = new PostgreModule();
        Injector injector = Guice.createInjector(psm);
        ICurrencysManager currencyService = injector.getInstance(ICurrencysManager.class);
        
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/accounting", "test_user","test_user")){
            List<Currency> currensis = currencyService.getAllCurrencis(con);
            for(Currency currency : currensis){
                System.out.println(currency.Id + " : " + currency.Name);
            }
        }
        catch(Exception exc){
            System.out.println("Ops");
        }
        */
    }
    
}
