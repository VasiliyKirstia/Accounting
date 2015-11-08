/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.models;

import java.io.Serializable;

/**
 *
 * @author Vasiliy Kirstia
 */
public class Account implements Serializable{
    public final int Id;
    public final String AccountNumber;
    
    public Account(int id, String accountNumber){
        this.Id = id;
        this.AccountNumber = accountNumber;
    }
    
    @Override
    public String toString(){
        return this.AccountNumber;
    }
}
