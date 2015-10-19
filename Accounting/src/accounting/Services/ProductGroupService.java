/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Services;

import accounting.Interfaces.IProductGroupService;
import accounting.Models.ProductGroup;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class ProductGroupService implements IProductGroupService{

    @Override
    public void addProductGroup(Connection con, String productGroupName, int accountId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductGroup getProductGroupById(Connection con, int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductGroup> getAllProductGroups(Connection con) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
