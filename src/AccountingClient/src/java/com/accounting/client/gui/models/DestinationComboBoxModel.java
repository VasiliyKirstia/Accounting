/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.interfaces.IDestinationsServices;
import com.accounting.models.Destination;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author vasiliy
 */
public class DestinationComboBoxModel extends DefaultComboBoxModel<Destination>{

    public DestinationComboBoxModel() {
        super();
    }

    @Override
    public Destination getSelectedItem() {
        return (Destination)super.getSelectedItem(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void update(){
        IDestinationsServices destinationsServices = null;
        try{
            destinationsServices = RemoteServicesProvider.getInstance().<IDestinationsServices>getServices(IDestinationsServices.class);
        }catch(NotSupportedServicesException e){
            System.err.println("NotSupportedServicesException");
        }
        
        if(null != destinationsServices){
            this.removeAllElements();
            for(Destination destination: destinationsServices.getAllDestinations())
                this.addElement(destination);
        }
    }
}
