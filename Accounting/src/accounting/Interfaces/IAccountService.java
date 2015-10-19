/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Account;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IAccountService {
    public void addAccount(Connection con, String accountNumber) throws Exception;
    public Account getAccountById(Connection con, int id) throws Exception;
    public List<Account> getAllAccounts(Connection con) throws Exception;  
}
