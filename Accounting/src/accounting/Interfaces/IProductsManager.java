/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Product;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IProductsManager {
    public void addProduct(String productName, double amount, double price, int productGroupId, int currencyId, int productUnitId);
    public Product getProductById(int id);
    public List<Product> getAllProducts();
}
