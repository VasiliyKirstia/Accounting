/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Services;

import accounting.Interfaces.ITransactionService;
import accounting.Models.Transaction;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class TransactionService implements ITransactionService{

    @Override
    public void addTransaction(Connection con, Date date, double productAmount, int documentId, int productId, int destinationId, int employeeId, int operationId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaction getTransactionById(Connection con, int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaction> getAllTransactions(Connection con) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
