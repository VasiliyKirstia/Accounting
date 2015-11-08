/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.server.services;

import javax.ejb.Stateless;
import com.accounting.interfaces.IProductsServices;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.accounting.models.Product;
import static com.accounting.server.services.Setings.CONECTION_STRING;
import static com.accounting.server.services.Setings.PASSWORD;
import static com.accounting.server.services.Setings.USERNAME;

/**
 *
 * @author vasiliy
 */
@Stateless
public class ProductsServices implements IProductsServices{
    @Override
    public void addProduct(String productName, double amount, BigDecimal price, int productGroupId, int currencyId, int productUnitId) {
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO product (name, amount, price, product_group_id, currency_id, product_unit_id) VALUES (?,?,?,?,?,?)");
            prepSt.setString(1, productName);
            prepSt.setDouble(2, amount);
            prepSt.setBigDecimal(3, price);
            prepSt.setInt(4, productGroupId);
            prepSt.setInt(5, currencyId);
            prepSt.setInt(6, productUnitId);
            prepSt.executeUpdate();
        }catch(SQLException e){System.err.println(e.toString());}
    }

    @Override
    public Product getProductById(int id) {
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("SELECT * FROM product WHERE id = ?");
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("amount"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getInt("product_group_id"),
                        resultSet.getInt("currency_id"),
                        resultSet.getInt("product_unit_id")
                );
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM product");
            List<Product> products = new LinkedList<Product>();
            while(resultSet.next()){
                products.add(
                    new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("amount"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getInt("product_group_id"),
                        resultSet.getInt("currency_id"),
                        resultSet.getInt("product_unit_id")
                    )
                );
            }
            return products;
        }catch(SQLException e){
            return null;
        }
    }
}
