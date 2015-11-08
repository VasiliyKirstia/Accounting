/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Document;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IDocumentsManager {
    public void addDocument(String name);
    public Document getDocumentById(int id);
    public List<Document> getAllDocuments();  
}
