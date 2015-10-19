/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Account;
import accounting.Models.Document;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IDocumentService {
    public void addDocument(Connection con) throws Exception;
    public Document getDocumentById(Connection con, int id) throws Exception;
    public List<Document> getAllDocuments(Connection con) throws Exception;  
}
