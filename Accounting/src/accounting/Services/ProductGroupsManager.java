/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Services;

import accounting.Interfaces.IProductGroupsManager;
import accounting.Models.ProductGroup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class ProductGroupsManager implements IProductGroupsManager{

    @Override
    public void addProductGroup(Connection con, String productGroupName, int accountId) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("INSERT INTO product_group (name, account_id) VALUES (?, ?)");
        prepSt.setString(1, productGroupName);
        prepSt.setInt(2, accountId);
        prepSt.executeUpdate();
    }

    @Override
    public ProductGroup getProductGroupById(Connection con, int id) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("SELECT * FROM product_group WHERE id = ?");
        prepSt.setInt(1, id);
        ResultSet resultSet = prepSt.executeQuery();
        
        if(resultSet.next()){
            return new ProductGroup(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("account_id"));
        }else{
            return null;
        }
    }

    @Override
    public List<ProductGroup> getAllProductGroups(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM product_group");
        List<ProductGroup> productGroups = new LinkedList<ProductGroup>();
        while(resultSet.next()){
            productGroups.add(new ProductGroup(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("account_id")));
        }
        return productGroups;
    }
    
}
