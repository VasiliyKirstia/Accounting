/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Services;

import accounting.Interfaces.IProductUnitsManager;
import accounting.Models.ProductUnit;
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
public class ProductUnitsManager implements IProductUnitsManager{

    @Override
    public void addProductUnit(Connection con, String productUnitName) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("INSERT INTO product_unit (name) VALUES (?)");
        prepSt.setString(1, productUnitName);
        prepSt.executeUpdate();
    }

    @Override
    public ProductUnit getProductUnitById(Connection con, int id) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("SELECT * FROM product_unit WHERE id = ?");
        prepSt.setInt(1, id);
        ResultSet resultSet = prepSt.executeQuery();
        
        if(resultSet.next()){
            return new ProductUnit(resultSet.getInt("id"), resultSet.getString("name") );
        }else{
            return null;
        }
    }

    @Override
    public List<ProductUnit> getAllProductUnits(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM product_unit");
        List<ProductUnit> productUnits = new LinkedList<ProductUnit>();
        while(resultSet.next()){
            productUnits.add(new ProductUnit(resultSet.getInt("id"), resultSet.getString("name")));
        }
        return productUnits;
    }

}
