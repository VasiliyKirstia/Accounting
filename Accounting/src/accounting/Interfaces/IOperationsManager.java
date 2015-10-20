/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Operation;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IOperationsManager {
    public void addOperation(Connection con, String operationName) throws Exception;
    public Operation getOperationById(Connection con, int id) throws Exception;    
    public List<Operation> getAllOperations(Connection con) throws Exception;
}
