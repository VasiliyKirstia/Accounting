/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.interfaces.IDocumentsServices;
import javax.swing.DefaultComboBoxModel;
import com.accounting.models.Document;

/**
 *
 * @author vasiliy
 */
public class DocumentComboBoxModel extends DefaultComboBoxModel<Document>{

    public DocumentComboBoxModel() {
        super();
    }

    @Override
    public Document getSelectedItem() {
        return (Document)super.getSelectedItem();
    }

    public void update(){
        IDocumentsServices documentsServices = null;
        try{
            documentsServices = RemoteServicesProvider.getInstance().<IDocumentsServices>getServices(IDocumentsServices.class);
        }catch(NotSupportedServicesException e){
            System.err.println("NotSupportedServicesException");
        }
        
        if(null != documentsServices){
            this.removeAllElements();
            for(Document document: documentsServices.getAllDocuments())
                this.addElement(document);
        }
    }
}
