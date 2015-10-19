/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Models;

/**
 *
 * @author Vasiliy Kirstia
 */
public class Product {
    public final int Id;
    public final String Name;
    public final double Amount;
    public final double Price;
    public final int ProductGroupId;
    public final int CurrencyId;
    public final int ProductUnitId;
    
    public Product(int id, String name, double amount, double price, int productGroupId, int currencyId, int productUnitId){
        this.Id = id;
        this.Name = name;
        this.Amount = amount;
        this.Price = price;
        this.ProductGroupId = productGroupId;
        this.CurrencyId = currencyId;
        this.ProductUnitId = productUnitId;
    }
}
