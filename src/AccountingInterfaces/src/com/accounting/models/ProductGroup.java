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
public class ProductGroup implements Serializable{
    public final int Id;
    public final String Name;
    public final int AccountId;
    
    public ProductGroup(int id, String name, int accountId){
        this.Id = id;
        this.Name = name;
        this.AccountId = accountId;
    }
    
    @Override
    public String toString(){
        return this.Name;
    }
}
