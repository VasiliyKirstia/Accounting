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
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author vasiliy
 */
@Stateless
public class ProductsServices implements IProductsServices{

    @Override
    public void addProduct(String productName, double productAmount, BigDecimal price, int productGroupId, int currencyId, int productUnitId, int documentId, int employeeId) {
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            con.setAutoCommit(Boolean.FALSE);
            
            Date dateNow = new Date(Calendar.getInstance().getTimeInMillis());
            
            PreparedStatement addProductStmt = con.prepareStatement(
                    "INSERT INTO product (id, name, amount, price, product_group_id, currency_id, product_unit_id) VALUES (DEFAULT,?,?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS
            );
            addProductStmt.setString(1, productName);
            addProductStmt.setDouble(2, productAmount);
            addProductStmt.setBigDecimal(3, price);
            addProductStmt.setInt(4, productGroupId);
            addProductStmt.setInt(5, currencyId);
            addProductStmt.setInt(6, productUnitId);
            addProductStmt.executeUpdate();
            
            ResultSet genKeys = addProductStmt.getGeneratedKeys();
            int productId;
            if(genKeys.next()){
                productId = genKeys.getInt(1);
            }else{
                throw new SQLException();
            }
            
            PreparedStatement addTransactionStmt = con.prepareStatement("INSERT INTO transaction (date, product_amount, document_id, product_id, destination_id, employee_id, operation_id) VALUES (?,?,?,?,?,?,?);");
            addTransactionStmt.setDate(1, dateNow);
            addTransactionStmt.setDouble(2, productAmount);
            addTransactionStmt.setInt(3, documentId);
            addTransactionStmt.setInt(4, productId);
            addTransactionStmt.setInt(5, settings.getDestinationStorageId());
            addTransactionStmt.setInt(6, employeeId);
            addTransactionStmt.setInt(7, settings.getProductAdditionId());
            addTransactionStmt.executeUpdate();
            
            con.commit();
            con.setAutoCommit(Boolean.TRUE);
        }catch(SQLException e){System.err.println(e.toString());}
    }
    
    @Override
    public void consumeProduct(int productId, double productAmount, int documentId, int destinationId, int employeeId) {
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            con.setAutoCommit(Boolean.FALSE);
            
            Date dateNow = new Date(Calendar.getInstance().getTimeInMillis());
            
            PreparedStatement updateProductStmt = con.prepareStatement("UPDATE product SET amount = amount - ? WHERE id = ?;");
            updateProductStmt.setDouble(1, productAmount);
            updateProductStmt.setInt(2, productId);
            updateProductStmt.executeUpdate();
            
            PreparedStatement addTransactionStmt = con.prepareStatement("INSERT INTO transaction (date, product_amount, document_id, product_id, destination_id, employee_id, operation_id) VALUES (?,?,?,?,?,?,?);");
            addTransactionStmt.setDate(1, dateNow);
            addTransactionStmt.setDouble(2, productAmount);
            addTransactionStmt.setInt(3, documentId);
            addTransactionStmt.setInt(4, productId);
            addTransactionStmt.setInt(5, destinationId);
            addTransactionStmt.setInt(6, employeeId);
            addTransactionStmt.setInt(7, settings.getProductConsumingId());
            addTransactionStmt.executeUpdate();
            
            con.commit();
            con.setAutoCommit(Boolean.TRUE);
        }catch(SQLException e){System.err.println(e.toString());}
    }

    @Override
    public Product getProductById(int id) {
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            PreparedStatement prepSt = con.prepareStatement(
                    "SELECT prod.id AS id, prod.name AS name, prod.amount AS amount, prod.price AS price, pg.name AS pg_name, cur.name AS cur_name, pu.name AS pu_name FROM product AS prod "
                    +"INNER JOIN product_group AS pg ON prod.product_group_id = pg.id "
                    +"INNER JOIN currency AS cur ON prod.currency_id = cur.id "
                    +"INNER JOIN product_unit AS pu ON prod.product_unit_id = pu.id "
                    +"WHERE prod.id = ?"
            );
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("amount"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getString("pg_name"),
                        resultSet.getString("cur_name"),
                        resultSet.getString("pu_name")
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
        Settings settings = Settings.getInstance();
        try(
                Connection con = DriverManager.getConnection(
                        settings.getConnectionURL(), 
                        settings.getUserName(), 
                        settings.getPassword()
                )
        ){
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(
                    "SELECT prod.id AS id, prod.name AS name, prod.amount AS amount, prod.price AS price, pg.name AS pg_name, cur.name AS cur_name, pu.name AS pu_name FROM product AS prod "
                    +"INNER JOIN product_group AS pg ON prod.product_group_id = pg.id "
                    +"INNER JOIN currency AS cur ON prod.currency_id = cur.id "
                    +"INNER JOIN product_unit AS pu ON prod.product_unit_id = pu.id "
            );
            List<Product> products = new LinkedList<Product>();
            while(resultSet.next()){
                products.add(
                    new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("amount"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getString("pg_name"),
                        resultSet.getString("cur_name"),
                        resultSet.getString("pu_name")
                    )
                );
            }
            return products;
        }catch(SQLException e){
            return null;
        }
    }
}
