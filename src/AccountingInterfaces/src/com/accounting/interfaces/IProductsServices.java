/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.interfaces;

import com.accounting.models.Product;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Vasiliy Kirstia
 */
@Remote
public interface IProductsServices {
    public void addProduct(String productName, double productAmount, BigDecimal price, int productGroupId, int currencyId, int productUnitId, int documentId, int employeeId);
    public void consumeProduct( int productId, double productAmount, int documentId, int destinationId, int employeeId);
    public Product getProductById(int id);
    public List<Product> getAllProducts();
}
