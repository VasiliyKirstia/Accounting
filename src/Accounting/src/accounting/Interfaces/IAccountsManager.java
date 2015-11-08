/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Account;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IAccountsManager {
    public void addAccount(String accountNumber);
    public Account getAccountById(int id);
    public List<Account> getAllAccounts();  
}
