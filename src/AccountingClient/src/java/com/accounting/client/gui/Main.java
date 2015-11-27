/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui;

import com.accounting.client.utils.WindowsFactory;
import com.accounting.client.gui.models.ProductTableModel;
import javax.swing.JFrame;
import com.accounting.interfaces.IProductsServices;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JTable;
import com.accounting.client.utils.RemoteServicesProvider;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vasiliy
 */
public class Main extends javax.swing.JPanel {   
    
    private RemoteServicesProvider<IProductsServices> productsServicesProvider;
    
    /**
     * Creates new form Main
     */
    public Main() {
        productsServicesProvider = new RemoteServicesProvider<IProductsServices>() {
            @Override
            public IProductsServices getServices() throws NamingException, Exception {
                Context c = new InitialContext();
                return (IProductsServices) c.lookup("java:comp/env/ProductsServices");
            }
        };
        initComponents();
        updateTableData();
    }
    private void updateTableData(){
        final IProductsServices productsServices = productsServicesProvider.getServicesSafely();
        if(productsServices == null){
            jTable1.setModel(new DefaultTableModel());
        }else{
            jTable1.setModel(new ProductTableModel(productsServices.getAllProducts()));
        }
        
        jTable1.addMouseListener( new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    JTable table =(JTable) me.getSource();
                    Point p = me.getPoint();
                    int row = table.rowAtPoint(p);
                    WindowsFactory.createDialog(
                            (JFrame)table.getTopLevelAncestor(), 
                            new ProductConsumingMaster(((ProductTableModel)jTable1.getModel()).getProductAtRow(row).Id),
                            "Расходование товара"
                    );
                    //TODO: ИМХО надо переделать!
                    ((ProductTableModel)jTable1.getModel()).replaceProducts(productsServices.getAllProducts());
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonAccountAdd = new javax.swing.JButton();
        jButtonCurrencyAdd = new javax.swing.JButton();
        jButtonDestinationAdd = new javax.swing.JButton();
        jButtonDocumentAdd = new javax.swing.JButton();
        jButtonEmployeeAdd = new javax.swing.JButton();
        jButtonOperationAdd = new javax.swing.JButton();
        jButtonProductAdd = new javax.swing.JButton();
        jButtonProductGroupAdd = new javax.swing.JButton();
        jButtonProductUnitAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonAccountAdd.setText("счет");
        jButtonAccountAdd.setFocusable(false);
        jButtonAccountAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAccountAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAccountAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountCreationHandler(evt);
            }
        });
        jToolBar1.add(jButtonAccountAdd);

        jButtonCurrencyAdd.setText("валюта");
        jButtonCurrencyAdd.setFocusable(false);
        jButtonCurrencyAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCurrencyAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCurrencyAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currencyCreationHandler(evt);
            }
        });
        jToolBar1.add(jButtonCurrencyAdd);

        jButtonDestinationAdd.setText("место");
        jButtonDestinationAdd.setFocusable(false);
        jButtonDestinationAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDestinationAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDestinationAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                destinationCreationHandler(evt);
            }
        });
        jToolBar1.add(jButtonDestinationAdd);

        jButtonDocumentAdd.setText("документ");
        jButtonDocumentAdd.setFocusable(false);
        jButtonDocumentAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDocumentAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDocumentAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                documentCreationHandler(evt);
            }
        });
        jToolBar1.add(jButtonDocumentAdd);

        jButtonEmployeeAdd.setText("сотрудник");
        jButtonEmployeeAdd.setFocusable(false);
        jButtonEmployeeAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEmployeeAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEmployeeAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeCreationHandler(evt);
            }
        });
        jToolBar1.add(jButtonEmployeeAdd);

        jButtonOperationAdd.setText("операция");
        jButtonOperationAdd.setFocusable(false);
        jButtonOperationAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonOperationAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonOperationAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                operationCreationHandler(evt);
            }
        });
        jToolBar1.add(jButtonOperationAdd);

        jButtonProductAdd.setText("продукт");
        jButtonProductAdd.setFocusable(false);
        jButtonProductAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonProductAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonProductAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productCreationHandler(evt);
            }
        });
        jToolBar1.add(jButtonProductAdd);

        jButtonProductGroupAdd.setText("прод.гр.");
        jButtonProductGroupAdd.setFocusable(false);
        jButtonProductGroupAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonProductGroupAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonProductGroupAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productGroupCreationHandler(evt);
            }
        });
        jToolBar1.add(jButtonProductGroupAdd);

        jButtonProductUnitAdd.setText("ед.изм");
        jButtonProductUnitAdd.setFocusable(false);
        jButtonProductUnitAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonProductUnitAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonProductUnitAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productUnitCreationHandler(evt);
            }
        });
        jToolBar1.add(jButtonProductUnitAdd);

        jTable1.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void accountCreationHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountCreationHandler
        WindowsFactory.createDialog((JFrame)this.getTopLevelAncestor(), new AccountAdditionMaster(), "Добавление счета");
    }//GEN-LAST:event_accountCreationHandler

    private void currencyCreationHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currencyCreationHandler
        WindowsFactory.createDialog((JFrame)this.getTopLevelAncestor(), new CurrencyAdditionMaster(), "Добавление валюты");
    }//GEN-LAST:event_currencyCreationHandler

    private void destinationCreationHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_destinationCreationHandler
        WindowsFactory.createDialog((JFrame)this.getTopLevelAncestor(), new DestinationAdditionMaster(), "Добавление места");
    }//GEN-LAST:event_destinationCreationHandler

    private void documentCreationHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_documentCreationHandler
        WindowsFactory.createDialog((JFrame)this.getTopLevelAncestor(), new DocumentAdditionMaster(), "Добавление документа");
    }//GEN-LAST:event_documentCreationHandler

    private void operationCreationHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_operationCreationHandler
        WindowsFactory.createDialog((JFrame)this.getTopLevelAncestor(), new OperationAdditionMaster(), "Добавление операции");
    }//GEN-LAST:event_operationCreationHandler

    private void productCreationHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productCreationHandler
        WindowsFactory.createDialog((JFrame)this.getTopLevelAncestor(), new ProductAdditionMaster(), "Добавление товара");
        IProductsServices productsServices = this.productsServicesProvider.getServicesSafely();
        if(productsServices != null){
            //TODO: ИМХО надо переделать!
            ((ProductTableModel)jTable1.getModel()).replaceProducts(productsServices.getAllProducts());
        }
    }//GEN-LAST:event_productCreationHandler

    private void productGroupCreationHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productGroupCreationHandler
        WindowsFactory.createDialog((JFrame)this.getTopLevelAncestor(), new ProductGroupAdditionMaster(), "Добавление группы продуктов");
    }//GEN-LAST:event_productGroupCreationHandler

    private void productUnitCreationHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productUnitCreationHandler
        WindowsFactory.createDialog((JFrame)this.getTopLevelAncestor(), new ProductUnitAdditionMaster(), "Добавление единицы измерения");
    }//GEN-LAST:event_productUnitCreationHandler

    private void employeeCreationHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeCreationHandler
        WindowsFactory.createDialog((JFrame)this.getTopLevelAncestor(), new EmployeeAdditionMaster(), "Добавление сотрудника");
    }//GEN-LAST:event_employeeCreationHandler


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccountAdd;
    private javax.swing.JButton jButtonCurrencyAdd;
    private javax.swing.JButton jButtonDestinationAdd;
    private javax.swing.JButton jButtonDocumentAdd;
    private javax.swing.JButton jButtonEmployeeAdd;
    private javax.swing.JButton jButtonOperationAdd;
    private javax.swing.JButton jButtonProductAdd;
    private javax.swing.JButton jButtonProductGroupAdd;
    private javax.swing.JButton jButtonProductUnitAdd;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
