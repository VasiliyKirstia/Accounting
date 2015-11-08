/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Operation;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IOperationsManager {
    public void addOperation(String operationName);
    public Operation getOperationById(int id);    
    public List<Operation> getAllOperations();
}
