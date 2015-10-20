/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Services;

import accounting.Interfaces.IDocumentsManager;
import accounting.Models.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class DocumentsManager implements IDocumentsManager{

    @Override
    public void addDocument(Connection con) throws Exception {
        Statement st = con.createStatement();
        st.execute("INSERT INTO document");
    }

    @Override
    public Document getDocumentById(Connection con, int id) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("SELECT * FROM document WHERE id = ?");
        prepSt.setInt(1, id);
        ResultSet resultSet = prepSt.executeQuery();
        
        if(resultSet.next()){
            return new Document(resultSet.getInt("id"));
        }else{
            return null;
        }
    }

    @Override
    public List<Document> getAllDocuments(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM document");
        List<Document> documents = new LinkedList<Document>();
        while(resultSet.next()){
            documents.add(new Document(resultSet.getInt("id")));
        }
        return documents;
    }
    
}
