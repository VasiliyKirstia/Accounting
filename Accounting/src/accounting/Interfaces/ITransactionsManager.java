/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Transaction;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface ITransactionsManager {
    public void addTransaction(Connection con, Date date, double productAmount, int documentId, int productId, int destinationId, int employeeId, int operationId) throws Exception;
    public Transaction getTransactionById(Connection con, int id) throws Exception;
    public List<Transaction> getAllTransactions(Connection con) throws Exception;
}
