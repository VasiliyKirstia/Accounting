/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.server.services;

import javax.ejb.Stateless;
import com.accounting.interfaces.IProductGroupsServices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.accounting.models.ProductGroup;

/**
 *
 * @author vasiliy
 */
@Stateless
public class ProductGroupsServices implements IProductGroupsServices{
@Override
    public void addProductGroup(String productGroupName, int accountId){
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO product_group (name, account_id) VALUES (?, ?)");
            prepSt.setString(1, productGroupName);
            prepSt.setInt(2, accountId);
            prepSt.executeUpdate();
        }catch(SQLException e){}
    }

    @Override
    public ProductGroup getProductGroupById(int id){
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            PreparedStatement prepSt = con.prepareStatement("SELECT * FROM product_group WHERE id = ?");
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new ProductGroup(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("account_id"));
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<ProductGroup> getAllProductGroups(){
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM product_group");
            List<ProductGroup> productGroups = new LinkedList<ProductGroup>();
            while(resultSet.next()){
                productGroups.add(new ProductGroup(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("account_id")));
            }
            return productGroups;
        }catch(SQLException e){
            return null;
        }
    }
}
