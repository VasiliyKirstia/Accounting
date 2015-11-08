/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.interfaces;

import com.accounting.models.Employee;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Vasiliy Kirstia
 */
@Remote
public interface IEmployeesServices {
    public void addEmployee(String employeeName);
    public Employee getEmployeeById(int id);    
    public List<Employee> getAllEmployees();
}
