/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui;

import com.accounting.client.gui.models.AccountComboBoxModel;
import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.client.utils.WindowsFactory;
import com.accounting.interfaces.IProductGroupsServices;
import java.awt.Window;
import javax.swing.JFrame;

/**
 *
 * @author vasiliy
 */
public class ProductGroupAdditionMaster extends javax.swing.JPanel {
    
    /**
     * Creates new form ProductGroupAdditionMaster
     */
    public ProductGroupAdditionMaster() {
        initComponents();
        
        jComboBoxAccount.setModel(new AccountComboBoxModel());
        ((AccountComboBoxModel)jComboBoxAccount.getModel()).update();
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
        jTextFieldGroupName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAccount = new javax.swing.JComboBox();
        jButtonAdd = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonAddAccount = new javax.swing.JButton();

        jLabel1.setText("Название группы:");

        jLabel2.setText("Счет:");

        jButtonAdd.setText("Добавить");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductGroup(evt);
            }
        });

        jButtonCancel.setText("Отмена");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeWindow(evt);
            }
        });

        jButtonAddAccount.setText("Ещё");
        jButtonAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccount(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxAccount, 0, 302, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddAccount))
                            .addComponent(jTextFieldGroupName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdd)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddAccount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addProductGroup(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductGroup
        IProductGroupsServices productGroupsServices = null;
        try{
            productGroupsServices = RemoteServicesProvider.getInstance().<IProductGroupsServices>getServices(IProductGroupsServices.class);
        }catch(NotSupportedServicesException e){
            throw new RuntimeException(e);
        }
        
        if(null != productGroupsServices){
            productGroupsServices.addProductGroup(
                    jTextFieldGroupName.getText(),
                    ((AccountComboBoxModel)jComboBoxAccount.getModel()).getSelectedItem().Id 
            );
        }
        ((Window)this.getTopLevelAncestor()).dispose();
    }//GEN-LAST:event_addProductGroup

    private void closeWindow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeWindow
        ((Window)this.getTopLevelAncestor()).dispose();
    }//GEN-LAST:event_closeWindow

    private void addAccount(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAccount
        WindowsFactory.createDialog((Window)this.getTopLevelAncestor(), new AccountAdditionMaster(), "Добавление счета");
        ((AccountComboBoxModel)jComboBoxAccount.getModel()).update();
    }//GEN-LAST:event_addAccount


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddAccount;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JComboBox jComboBoxAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldGroupName;
    // End of variables declaration//GEN-END:variables
}
