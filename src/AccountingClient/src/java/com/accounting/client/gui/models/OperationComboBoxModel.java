/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.interfaces.IOperationsServices;
import com.accounting.models.Operation;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author vasiliy
 */
public class OperationComboBoxModel extends DefaultComboBoxModel<Operation>{

    public OperationComboBoxModel() {
        super();
    }

    @Override
    public Operation getSelectedItem() {
        return (Operation)super.getSelectedItem();
    }
    
    public void update(){
        IOperationsServices operationsServices = null;
        try{
            operationsServices = RemoteServicesProvider.getInstance().<IOperationsServices>getServices(IOperationsServices.class);
        }catch(NotSupportedServicesException e){
            System.err.println("NotSupportedServicesException");
        }
        
        if(null != operationsServices){
            this.removeAllElements();
            for(Operation operation: operationsServices.getAllOperations())
                this.addElement(operation);
        }
    }
}
