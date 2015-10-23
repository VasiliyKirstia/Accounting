/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.PostgreManagers;

import accounting.Interfaces.IProductsManager;
import accounting.Models.Product;
import static accounting.PostgreManagers.PostgreModule.CONECTION_STRING;
import static accounting.PostgreManagers.PostgreModule.PASSWORD;
import static accounting.PostgreManagers.PostgreModule.USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class PostgreProductsManager implements IProductsManager{

    @Override
    public void addProduct(String productName, double amount, double price, int productGroupId, int currencyId, int productUnitId) {
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO product (name, amount, price, product_croup_id, currency_id, product_unit_id) VALUES (?,?,?,?,?,?)");
            prepSt.setString(1, productName);
            prepSt.setDouble(2, amount);
            prepSt.setDouble(3, price);
            prepSt.setInt(4, productGroupId);
            prepSt.setInt(5, currencyId);
            prepSt.setInt(6, productUnitId);
            prepSt.executeUpdate();
        }catch(SQLException e){}
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
                        resultSet.getDouble("price"),
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
                        resultSet.getDouble("price"),
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
