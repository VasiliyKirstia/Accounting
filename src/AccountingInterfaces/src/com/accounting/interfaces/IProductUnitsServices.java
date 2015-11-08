/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.interfaces;

import com.accounting.models.ProductUnit;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Vasiliy Kirstia
 */
@Remote
public interface IProductUnitsServices {
    public void addProductUnit(String productUnitName);
    public ProductUnit getProductUnitById(int id);    
    public List<ProductUnit> getAllProductUnits();
}
