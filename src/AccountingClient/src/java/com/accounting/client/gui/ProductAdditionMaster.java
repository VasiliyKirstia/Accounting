/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui;

import com.accounting.client.gui.models.CurrencyComboBoxModel;
import com.accounting.client.gui.models.DocumentComboBoxModel;
import com.accounting.client.gui.models.EmployeeComboBoxModel;
import com.accounting.client.gui.models.ProductGroupComboBoxModel;
import com.accounting.client.gui.models.ProductUnitComboBoxModel;
import com.accounting.interfaces.*;
import com.accounting.models.Currency;
import com.accounting.models.ProductGroup;
import com.accounting.models.ProductUnit;
import com.accounting.interfaces.IProductsServices;
import com.accounting.models.Document;
import com.accounting.models.Employee;

import java.awt.Window;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author vasiliy
 */
public class ProductAdditionMaster extends javax.swing.JPanel {
    
    /**
     * Creates new form ProductAdditionMaster
     */
    public ProductAdditionMaster() {      
        initComponents();
        
        CurrencyComboBoxModel ccm = new CurrencyComboBoxModel();
        for(Currency cur : lookupCurrencysServicesRemote().getAllCurrencis()){
            ccm.addElement(cur);
        }
        
        ProductUnitComboBoxModel pucm = new ProductUnitComboBoxModel();
        for(ProductUnit pu : lookupProductUnitsServicesRemote1().getAllProductUnits()){
            pucm.addElement(pu);
        }
        
        ProductGroupComboBoxModel pgcm = new ProductGroupComboBoxModel();
        for(ProductGroup pg : lookupProductGroupsServicesRemote().getAllProductGroups()){
            pgcm.addElement(pg);
        }
        
        EmployeeComboBoxModel ecm = new EmployeeComboBoxModel();
        for(Employee emp : lookupEmployeesServicesRemote().getAllEmployees()){
            ecm.addElement(emp);
        }
        
        DocumentComboBoxModel doccm = new DocumentComboBoxModel();
        for(Document doc : lookupDocumentsServicesRemote().getAllDocuments()){
            doccm.addElement(doc);
        }
        
        jComboBoxUnit.setModel(pucm);
        jComboBoxGroup.setModel(pgcm);
        jComboBoxCurrency.setModel(ccm);
        jComboBoxEmployee.setModel(ecm);
        jComboBoxDocument.setModel(doccm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldAmount = new javax.swing.JTextField();
        jTextFieldPrice = new javax.swing.JTextField();
        jComboBoxUnit = new javax.swing.JComboBox();
        jComboBoxCurrency = new javax.swing.JComboBox();
        jComboBoxGroup = new javax.swing.JComboBox();
        jButtonAdd = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxEmployee = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxDocument = new javax.swing.JComboBox();

        jLabel1.setText("Наименование:");

        jLabel2.setText("Количество:");

        jLabel3.setText("Стоимость всех N единиц:");

        jLabel4.setText("Единица измерения:");

        jLabel5.setText("Валюта:");

        jLabel6.setText("Группа:");

        jButtonAdd.setText("Добавить");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProduct(evt);
            }
        });

        jButtonCancel.setText("Отмена");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeWindow(evt);
            }
        });

        jLabel7.setText("Сотрудник:");

        jLabel8.setText("Документ:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAmount)
                            .addComponent(jTextFieldName)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPrice))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdd))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxCurrency, javax.swing.GroupLayout.Alignment.TRAILING, 0, 323, Short.MAX_VALUE)
                            .addComponent(jComboBoxUnit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxEmployee, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDocument, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProduct
        Double amount = Double.parseDouble(jTextFieldAmount.getText());
        
        lookupProductsServicesRemote().addProduct(
                jTextFieldName.getText(),
                amount,
                (new BigDecimal(jTextFieldPrice.getText())).divide(new BigDecimal(amount), 5, RoundingMode.HALF_DOWN),
                ((ProductGroupComboBoxModel)jComboBoxGroup.getModel()).getSelectedItem().Id,
                ((CurrencyComboBoxModel)jComboBoxCurrency.getModel()).getSelectedItem().Id,
                ((ProductUnitComboBoxModel)jComboBoxUnit.getModel()).getSelectedItem().Id,
                ((DocumentComboBoxModel)jComboBoxDocument.getModel()).getSelectedItem().Id,
                ((EmployeeComboBoxModel)jComboBoxEmployee.getModel()).getSelectedItem().Id
        );
        
        ((Window)this.getTopLevelAncestor()).dispose();
    }//GEN-LAST:event_addProduct

    private void closeWindow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeWindow
        ((Window)this.getTopLevelAncestor()).dispose();
    }//GEN-LAST:event_closeWindow


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JComboBox jComboBoxCurrency;
    private javax.swing.JComboBox jComboBoxDocument;
    private javax.swing.JComboBox jComboBoxEmployee;
    private javax.swing.JComboBox jComboBoxGroup;
    private javax.swing.JComboBox jComboBoxUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPrice;
    // End of variables declaration//GEN-END:variables

    private ICurrencysServices lookupCurrencysServicesRemote() {
        try {
            Context c = new InitialContext();
            return (ICurrencysServices) c.lookup("java:comp/env/CurrencysServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private IProductsServices lookupProductsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IProductsServices) c.lookup("java:comp/env/ProductsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private IProductUnitsServices lookupProductUnitsServicesRemote1() {
        try {
            Context c = new InitialContext();
            return (IProductUnitsServices) c.lookup("java:comp/env/ProductUnitsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private IProductGroupsServices lookupProductGroupsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IProductGroupsServices) c.lookup("java:comp/env/ProductGroupsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    private IEmployeesServices lookupEmployeesServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IEmployeesServices) c.lookup("java:comp/env/EmployeesServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    private IDocumentsServices lookupDocumentsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IDocumentsServices) c.lookup("java:comp/env/DocumentsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
