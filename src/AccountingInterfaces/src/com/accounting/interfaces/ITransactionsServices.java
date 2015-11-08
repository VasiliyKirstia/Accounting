/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.interfaces;

import com.accounting.models.Transaction;
import java.sql.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Vasiliy Kirstia
 */
@Remote
public interface ITransactionsServices {
    public void addTransaction(Date date, double productAmount, int documentId, int productId, int destinationId, int employeeId, int operationId);
    public Transaction getTransactionById(int id);
    public List<Transaction> getAllTransactions();
}
