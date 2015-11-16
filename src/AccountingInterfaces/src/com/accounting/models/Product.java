/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.models;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Vasiliy Kirstia
 */
public class Product implements Serializable{
    public final int Id;
    public final String Name;
    public final double Amount;
    public final BigDecimal Price;
    public final String ProductGroupName;
    public final String CurrencyName;
    public final String ProductUnitName;
    
    public Product(int id, String name, double amount, BigDecimal price, String productGroupName, String currencyName, String productUnitName){
        this.Id = id;
        this.Name = name;
        this.Amount = amount;
        this.Price = price;
        this.ProductGroupName = productGroupName;
        this.CurrencyName = currencyName;
        this.ProductUnitName = productUnitName;
    }
    
    @Override
    public String toString(){
        return this.Name;
    }
}
