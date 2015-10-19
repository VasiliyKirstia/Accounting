/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Employee;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IEmployeeService {
    public void addEmployee(Connection con, String employeeName) throws Exception;
    public Employee getEmployeeById(Connection con, int id) throws Exception;    
    public List<Employee> getAllEmployees(Connection con) throws Exception;
}
