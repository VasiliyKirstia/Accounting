/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting;
import java.sql.*;
import accounting.Services.*;
import accounting.Interfaces.*;
import accounting.Models.Currency;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public class Accounting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ICurrencyService currencyService = new CurrencyService();
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/accounting", "test_user","test_user")){
            List<Currency> currensis = currencyService.getAllCurrencis(con);
            for(Currency currency : currensis){
                System.out.println(currency.Id + " : " + currency.Name);
            }
        }
        catch(Exception exc){
            System.out.println("Ops");
        }
        
        
    }
    
}
