/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.ProductUnit;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IProductUnitService {
    public void addProductUnit(Connection con, String productUnitName) throws Exception;
    public ProductUnit getProductUnitById(Connection con, int id) throws Exception;    
    public List<ProductUnit> getAllProductUnits(Connection con) throws Exception;
}
