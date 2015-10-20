/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.ProductGroup;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IProductGroupsManager {
    public void addProductGroup(Connection con, String productGroupName, int accountId) throws Exception;
    public ProductGroup getProductGroupById(Connection con, int id) throws Exception;    
    public List<ProductGroup> getAllProductGroups(Connection con) throws Exception;
}
