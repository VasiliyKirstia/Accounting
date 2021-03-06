/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.server.services;

import com.accounting.server.Settings;
import javax.ejb.Stateless;
import com.accounting.interfaces.IProductUnitsServices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.accounting.models.ProductUnit;

/**
 *
 * @author vasiliy
 */
@Stateless
public class ProductUnitsServices implements IProductUnitsServices{
    
    @Override
    public void addProductUnit(String productUnitName){
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO product_unit (name) VALUES (?)");
            prepSt.setString(1, productUnitName);
            prepSt.executeUpdate();
        }catch(SQLException e){}
    }

    @Override
    public ProductUnit getProductUnitById(int id) {
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            PreparedStatement prepSt = con.prepareStatement("SELECT * FROM product_unit WHERE id = ?");
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new ProductUnit(resultSet.getInt("id"), resultSet.getString("name") );
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<ProductUnit> getAllProductUnits() {
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM product_unit");
            List<ProductUnit> productUnits = new LinkedList<ProductUnit>();
            while(resultSet.next()){
                productUnits.add(new ProductUnit(resultSet.getInt("id"), resultSet.getString("name")));
            }
            return productUnits;
        }catch(SQLException e){
            return null;
        }
    }
}
