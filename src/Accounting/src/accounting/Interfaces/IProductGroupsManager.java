/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.ProductGroup;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IProductGroupsManager {
    public void addProductGroup(String productGroupName, int accountId);
    public ProductGroup getProductGroupById(int id);    
    public List<ProductGroup> getAllProductGroups();
}
