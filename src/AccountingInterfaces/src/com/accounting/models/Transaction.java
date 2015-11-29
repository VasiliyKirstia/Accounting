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
    public final String DocumentName;
    public final String ProductName;
    public final String DestinationName;
    public final String EmployeeName;
    public final String OperationName;
    
    public Transaction(int id, Date date, double productAmount, String documentName, String productName, String destinationName, String employeeName, String operationName){
        this.Id = id;
        this.Date = date;
        this.ProductAmount = productAmount;
        this.DocumentName = documentName;
        this.ProductName = productName;
        this.DestinationName = destinationName;
        this.EmployeeName = employeeName;
        this.OperationName = operationName;
    }
}
