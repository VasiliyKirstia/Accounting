/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.PostgreManagers;

import accounting.Interfaces.IDocumentsManager;
import accounting.Models.Document;
import static accounting.PostgreManagers.PostgreModule.CONECTION_STRING;
import static accounting.PostgreManagers.PostgreModule.PASSWORD;
import static accounting.PostgreManagers.PostgreModule.USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vasiliy
 */
public class PostgreDocumentsManager implements IDocumentsManager{

    @Override
    public void addDocument(String documentName){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO document (name) VALUES (?)");
            prepSt.setString(1, documentName);
            prepSt.executeUpdate();
        }catch(SQLException e){System.out.println("ERROR");}
    }

    @Override
    public Document getDocumentById(int id){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("SELECT * FROM document WHERE id = ?");
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new Document(
                        resultSet.getInt("id"), 
                        resultSet.getString("name")
                );
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<Document> getAllDocuments(){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM document");
            List<Document> documents = new LinkedList<Document>();
            while(resultSet.next()){
                documents.add(new Document(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                    )
                );
            }
            return documents;
        }catch(SQLException e){
            return null;
        }
    }
    
}
