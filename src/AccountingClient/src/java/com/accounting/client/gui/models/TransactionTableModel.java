/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;

import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.interfaces.ITransactionsServices;
import com.accounting.models.Transaction;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vasiliy
 */
public class TransactionTableModel extends AbstractTableModel {
    
    private List<Transaction> transactions = new LinkedList<Transaction>();  
    private final String[] tableHeader = {
        "Дата",
        "Место назначения",
        "Операция",
        "Количество",
        "Продукт", 
        "Сотрудник",
        "Документ"        
    };
    
    public TransactionTableModel(){
        super();
    }
    
    public TransactionTableModel(List<Transaction> transactionsList){
        this();
        this.transactions.addAll(transactionsList);
    }
    
    public void appendTransaction(Transaction transaction){
        this.transactions.add(transaction);
        this.fireTableDataChanged();
    }
    
    public void appendTransaction(List<Transaction> transactionsList){
        this.transactions.addAll(transactionsList);
        this.fireTableDataChanged();
    }
    
    public void replaceTransactions(List<Transaction> transactionsList){
        this.transactions.clear();
        this.transactions.addAll(transactionsList);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return transactions.size();
    }

    @Override
    public int getColumnCount() {
        return tableHeader.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return transactions.get(rowIndex).Date;
            case 1:
                return transactions.get(rowIndex).DestinationId;
            case 2:
                return transactions.get(rowIndex).OperationId;
            case 3:
                return transactions.get(rowIndex).ProductAmount;
            case 4:
                return transactions.get(rowIndex).ProductId;
            case 5:
                return transactions.get(rowIndex).EmployeeId;
            case 6:
                return transactions.get(rowIndex).DocumentId;
            default:
                throw new AssertionError();
        }
    }
    
    public Transaction getProductAtRow(int rowIndex){
        return transactions.get(rowIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return tableHeader[columnIndex];
    }
    
    public void update(){
        ITransactionsServices transactionsServices = null;
        try{
            transactionsServices = RemoteServicesProvider.getInstance().<ITransactionsServices>getServices(ITransactionsServices.class);
        }catch(NotSupportedServicesException e){
            System.err.println("NotSupportedServicesException");
        }
        
        if(null != transactionsServices){
            this.replaceTransactions(transactionsServices.getAllTransactions());
        }
    }
}
