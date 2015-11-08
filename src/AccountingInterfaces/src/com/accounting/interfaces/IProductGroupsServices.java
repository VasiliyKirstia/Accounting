/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.interfaces;

import com.accounting.models.ProductGroup;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Vasiliy Kirstia
 */
@Remote
public interface IProductGroupsServices {
    public void addProductGroup(String productGroupName, int accountId);
    public ProductGroup getProductGroupById(int id);    
    public List<ProductGroup> getAllProductGroups();
}
