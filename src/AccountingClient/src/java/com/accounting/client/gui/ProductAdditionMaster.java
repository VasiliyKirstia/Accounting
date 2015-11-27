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
import com.accounting.client.utils.RemoteServicesProvider;
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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author vasiliy
 */
public class ProductAdditionMaster extends javax.swing.JPanel {
    
    private final RemoteServicesProvider<IProductGroupsServices> productGroupsServicesProvider;
    private final RemoteServicesProvider<IProductUnitsServices> productUnitsServicesProvider;
    private final RemoteServicesProvider<IProductsServices> productsServicesProvider;
    private final RemoteServicesProvider<IDocumentsServices> documentsServicesProvider;
    private final RemoteServicesProvider<ICurrencysServices> currencysServicesProvider;
    private final RemoteServicesProvider<IEmployeesServices> employeesServicesProvider;
    
    /**
     * Creates new form ProductAdditionMaster
     */
    public ProductAdditionMaster() {
        productGroupsServicesProvider = new RemoteServicesProvider<IProductGroupsServices>() {
            @Override
            public IProductGroupsServices getServices() throws NamingException, Exception {
                Context c = new InitialContext();
                return (IProductGroupsServices) c.lookup("java:comp/env/ProductGroupsServices");
            }
        };
        productUnitsServicesProvider = new RemoteServicesProvider<IProductUnitsServices>() {
            @Override
            public IProductUnitsServices getServices() throws NamingException, Exception {
                Context c = new InitialContext();
                return (IProductUnitsServices) c.lookup("java:comp/env/ProductUnitsServices");
            }
        };
        productsServicesProvider = new RemoteServicesProvider<IProductsServices>() {
            @Override
            public IProductsServices getServices() throws NamingException, Exception {
                Context c = new InitialContext();
                return (IProductsServices) c.lookup("java:comp/env/ProductsServices");
            }
        };
        documentsServicesProvider = new RemoteServicesProvider<IDocumentsServices>() {
            @Override
            public IDocumentsServices getServices() throws NamingException, Exception {
                Context c = new InitialContext();
                return (IDocumentsServices) c.lookup("java:comp/env/DocumentsServices");
            }
        };
        currencysServicesProvider = new RemoteServicesProvider<ICurrencysServices>() {
            @Override
            public ICurrencysServices getServices() throws NamingException, Exception {
                Context c = new InitialContext();
                return (ICurrencysServices) c.lookup("java:comp/env/CurrencysServices");
            }
        };
        employeesServicesProvider = new RemoteServicesProvider<IEmployeesServices>() {
            @Override
            public IEmployeesServices getServices() throws NamingException, Exception {
                Context c = new InitialContext();
                return (IEmployeesServices) c.lookup("java:comp/env/EmployeesServices");
            }
        };
        
        initComponents();
        updateCurrencyComboBox();
        
        
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
        
        jComboBoxEmployee.setModel(ecm);
        jComboBoxDocument.setModel(doccm);
    }

    private void updateCurrencyComboBox() {
        ICurrencysServices currencysServices = currencysServicesProvider.getServicesSafely();
        if(null != currencysServices){
            CurrencyComboBoxModel ccm = new CurrencyComboBoxModel();
            for(Currency cur : currencysServices.getAllCurrencis()){
                ccm.addElement(cur);
            }
            jComboBoxCurrency.setModel(ccm);
        }else{
            System.err.println("NullPointerException");
        }
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
        jButtonAddProductUnit = new javax.swing.JButton();
        jButtonAddCurrency = new javax.swing.JButton();
        jButtonAddProductGroup = new javax.swing.JButton();
        jButtonAddEmployee = new javax.swing.JButton();
        jButtonAddDocument = new javax.swing.JButton();

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

        jButtonAddProductUnit.setText("Ещё");
        jButtonAddProductUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductUnit(evt);
            }
        });

        jButtonAddCurrency.setText("Ещё");
        jButtonAddCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCurrency(evt);
            }
        });

        jButtonAddProductGroup.setText("Ещё");
        jButtonAddProductGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductGroup(evt);
            }
        });

        jButtonAddEmployee.setText("Ещё");
        jButtonAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployee(evt);
            }
        });

        jButtonAddDocument.setText("Ещё");
        jButtonAddDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDocument(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
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
                            .addComponent(jComboBoxUnit, 0, 335, Short.MAX_VALUE)
                            .addComponent(jComboBoxCurrency, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxGroup, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxEmployee, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDocument, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAddDocument, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAddEmployee, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAddProductGroup, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAddCurrency, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAddProductUnit, javax.swing.GroupLayout.Alignment.TRAILING)))
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
                        .addComponent(jTextFieldPrice)))
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
                    .addComponent(jComboBoxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddProductUnit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddCurrency))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddProductGroup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddEmployee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddDocument))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
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

    private void addProductUnit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductUnit
        // TODO add your handling code here:
    }//GEN-LAST:event_addProductUnit

    private void addCurrency(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCurrency
        // TODO add your handling code here:
    }//GEN-LAST:event_addCurrency

    private void addProductGroup(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductGroup
        // TODO add your handling code here:
    }//GEN-LAST:event_addProductGroup

    private void addEmployee(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployee
        // TODO add your handling code here:
    }//GEN-LAST:event_addEmployee

    private void addDocument(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDocument
        // TODO add your handling code here:
    }//GEN-LAST:event_addDocument


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddCurrency;
    private javax.swing.JButton jButtonAddDocument;
    private javax.swing.JButton jButtonAddEmployee;
    private javax.swing.JButton jButtonAddProductGroup;
    private javax.swing.JButton jButtonAddProductUnit;
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
}
