/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.models;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Vasiliy Kirstia
 */
public class Transaction implements Serializable{
    public final int Id;
    public final Date Date;
    public final double ProductAmount;
    public final int DocumentId;
    public final int ProductId;
    public final int DestinationId;
    public final int EmployeeId;
    public final int OperationId;
    
    public Transaction(int id, Date date, double productAmount, int documentId, int productId, int destinationId, int employeeId, int operationId){
        this.Id = id;
        this.Date = date;
        this.ProductAmount = productAmount;
        this.DocumentId = documentId;
        this.ProductId = productId;
        this.DestinationId = destinationId;
        this.EmployeeId = employeeId;
        this.OperationId = operationId;
    }
}
