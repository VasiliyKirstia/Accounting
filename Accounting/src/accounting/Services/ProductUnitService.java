/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Services;

import accounting.Interfaces.IProductUnitService;
import accounting.Models.ProductUnit;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class ProductUnitService implements IProductUnitService{

    @Override
    public void addProductUnit(Connection con, String productUnitName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductUnit getProductUnitById(Connection con, int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductUnit> getAllProductUnits(Connection con) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
