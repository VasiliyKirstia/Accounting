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
public class ProductGroup {
    public final int Id;
    public final String Name;
    public final int AccountId;
    
    public ProductGroup(int id, String name, int accountId){
        this.Id = id;
        this.Name = name;
        this.AccountId = accountId;
    }
}
