/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui;

import com.accounting.client.gui.models.DestinationComboBoxModel;
import com.accounting.client.gui.models.DocumentComboBoxModel;
import com.accounting.client.gui.models.EmployeeComboBoxModel;
import com.accounting.interfaces.IDestinationsServices;
import com.accounting.interfaces.IDocumentsServices;
import com.accounting.interfaces.IEmployeesServices;
import com.accounting.interfaces.IProductsServices;
import com.accounting.models.Destination;
import com.accounting.models.Document;
import com.accounting.models.Employee;
import com.accounting.models.Product;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author vasiliy
 */
public class ProductConsumingMaster extends javax.swing.JPanel {
    
    /**
     * Creates new form ProductConsumingMaster
     */
    private Product product;
    
    public ProductConsumingMaster(int productId) {
        this.product = lookupProductsServicesRemote().getProductById(productId);

        initComponents();

        jTextFieldProductName.setText(product.Name);

        DestinationComboBoxModel dcm = new DestinationComboBoxModel();
        for (Destination des : lookupDestinationsServicesRemote().getAllDestinations()) {
            dcm.addElement(des);
        }

        DocumentComboBoxModel doccm = new DocumentComboBoxModel();
        for (Document doc : lookupDocumentsServicesRemote().getAllDocuments()) {
            doccm.addElement(doc);
        }

        EmployeeComboBoxModel ecm = new EmployeeComboBoxModel();
        for (Employee emp : lookupEmployeesServicesRemote().getAllEmployees()) {
            ecm.addElement(emp);
        }

        jComboBoxEmployee.setModel(ecm);
        jComboBoxDestination.setModel(dcm);
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

        jButton1 = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldProductName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxDocument = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxDestination = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxEmployee = new javax.swing.JComboBox();

        jButton1.setText("Расходовать");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumeProduct(evt);
            }
        });

        jButtonCancel.setText("Отмена");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeWindow(evt);
            }
        });

        jLabel1.setText("Название:");

        jTextFieldProductName.setEditable(false);

        jLabel2.setText("Количество:");

        jLabel3.setText("Документ:");

        jLabel4.setText("Место назначения:");

        jLabel5.setText("Сотрудник:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 317, Short.MAX_VALUE)
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldProductName)
                            .addComponent(jTextFieldAmount)
                            .addComponent(jComboBoxDocument, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDestination, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxEmployee, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void closeWindow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeWindow
        ((Window) this.getTopLevelAncestor()).dispose();
    }//GEN-LAST:event_closeWindow

    private void consumeProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumeProduct
        lookupProductsServicesRemote().consumeProduct(
                product.Id,
                Double.valueOf(jTextFieldAmount.getText()),
                ((DocumentComboBoxModel) jComboBoxDocument.getModel()).getSelectedItem().Id,
                ((DestinationComboBoxModel) jComboBoxDestination.getModel()).getSelectedItem().Id,
                ((EmployeeComboBoxModel) jComboBoxEmployee.getModel()).getSelectedItem().Id
        );

        ((Window) this.getTopLevelAncestor()).dispose();
    }//GEN-LAST:event_consumeProduct


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JComboBox jComboBoxDestination;
    private javax.swing.JComboBox jComboBoxDocument;
    private javax.swing.JComboBox jComboBoxEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldProductName;
    // End of variables declaration//GEN-END:variables

    private IProductsServices lookupProductsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IProductsServices) c.lookup("java:comp/env/ProductsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private IDestinationsServices lookupDestinationsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IDestinationsServices) c.lookup("java:comp/env/DestinationsServices");
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

    private IEmployeesServices lookupEmployeesServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IEmployeesServices) c.lookup("java:comp/env/EmployeesServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
