/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui;

import com.accounting.client.utils.WindowsFactory;
import com.accounting.client.gui.models.ProductTableModel;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

/**
 *
 * @author vasiliy
 */
public class ProductsView extends javax.swing.JPanel {   

    /**
     * Creates new form Main
     */
    public ProductsView() {
        initComponents();
        
        jTableProducts.setModel(new ProductTableModel());
        ((ProductTableModel)jTableProducts.getModel()).update();
        
        jTableProducts.addMouseListener( new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    JTable table =(JTable) me.getSource();
                    Point p = me.getPoint();
                    int row = table.rowAtPoint(p);
                    WindowsFactory.createDialog(
                            (Window)table.getTopLevelAncestor(), 
                            new ProductConsumingMaster(((ProductTableModel)jTableProducts.getModel()).getProductAtRow(row).Id),
                            "Расходование товара"
                    );
                    ((ProductTableModel)jTableProducts.getModel()).update();
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
        jButtonOperationAdd = new javax.swing.JButton();
        jButtonProductAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonOperationAdd.setText("добавить операцию");
        jButtonOperationAdd.setFocusable(false);
        jButtonOperationAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonOperationAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonOperationAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                operationCreationHandler(evt);
            }
        });
        jToolBar1.add(jButtonOperationAdd);

        jButtonProductAdd.setText("добавить продукт");
        jButtonProductAdd.setFocusable(false);
        jButtonProductAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonProductAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonProductAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productCreationHandler(evt);
            }
        });
        jToolBar1.add(jButtonProductAdd);

        jButton1.setText("посмотреть транзакции");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTransactionView(evt);
            }
        });
        jToolBar1.add(jButton1);

        jTableProducts.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(jTableProducts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void operationCreationHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_operationCreationHandler
        WindowsFactory.createDialog((Window)this.getTopLevelAncestor(), new OperationAdditionMaster(), "Добавление операции");
    }//GEN-LAST:event_operationCreationHandler

    private void productCreationHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productCreationHandler
        WindowsFactory.createDialog((Window)this.getTopLevelAncestor(), new ProductAdditionMaster(), "Добавление товара");
        ((ProductTableModel)jTableProducts.getModel()).update();
    }//GEN-LAST:event_productCreationHandler

    private void showTransactionView(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTransactionView
        WindowsFactory.createFrame(new TransactionsView(), "Транзакции");
    }//GEN-LAST:event_showTransactionView


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonOperationAdd;
    private javax.swing.JButton jButtonProductAdd;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}