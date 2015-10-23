/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.ProductUnit;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IProductUnitsManager {
    public void addProductUnit(String productUnitName);
    public ProductUnit getProductUnitById(int id);    
    public List<ProductUnit> getAllProductUnits();
}
