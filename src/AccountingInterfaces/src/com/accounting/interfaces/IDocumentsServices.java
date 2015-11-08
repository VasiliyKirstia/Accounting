/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.interfaces;

import com.accounting.models.Document;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Vasiliy Kirstia
 */
@Remote
public interface IDocumentsServices {
    public void addDocument(String name);
    public Document getDocumentById(int id);
    public List<Document> getAllDocuments();  
}
