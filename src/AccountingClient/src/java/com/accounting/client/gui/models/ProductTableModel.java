/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;

import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.interfaces.IProductsServices;
import com.accounting.models.Product;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vasiliy
 */
public class ProductTableModel extends AbstractTableModel{

    private List<Product> products = new LinkedList<Product>();  
    private final String[] tableHeader = {
        "Название", 
        "Количество",
        "Стоимость еденицы",
        "Группа",
        "Валюта",
        "Ед. изм."
    };
    
    public ProductTableModel(){
        super();
    }
    
    public ProductTableModel(List<Product> productsList){
        this();
        products.addAll(productsList);
    }
    
    public void appendProduct(Product product){
        products.add(product);
        this.fireTableDataChanged();
    }
    
    public void appendProduct(List<Product> productList){
        this.products.addAll(productList);
        this.fireTableDataChanged();
    }
    
    public void replaceProducts(List<Product> productList){
        this.products.clear();
        this.products.addAll(productList);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return tableHeader.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return products.get(rowIndex).Name;
            case 1:
                return products.get(rowIndex).Amount;
            case 2:
                return products.get(rowIndex).Price;
            case 3:
                return products.get(rowIndex).ProductGroupName;
            case 4:
                return products.get(rowIndex).CurrencyName;
            case 5:
                return products.get(rowIndex).ProductUnitName;
            default:
                throw new AssertionError();
        }
    }
    
    public Product getProductAtRow(int rowIndex){
        return products.get(rowIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return tableHeader[columnIndex];
    }
    
    public void update(){
        IProductsServices productsServices = null;
        try{
            productsServices = RemoteServicesProvider.getInstance().<IProductsServices>getServices(IProductsServices.class);
        }catch(NotSupportedServicesException e){
            System.err.println("NotSupportedServicesException");
        }
        
        if(null != productsServices){
            this.replaceProducts(productsServices.getAllProducts());
        }
    }
}
