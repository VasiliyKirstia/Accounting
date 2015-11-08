/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.interfaces;

import com.accounting.models.Operation;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Vasiliy Kirstia
 */
@Remote
public interface IOperationsServices {
    public void addOperation(String operationName);
    public Operation getOperationById(int id);    
    public List<Operation> getAllOperations();
}
