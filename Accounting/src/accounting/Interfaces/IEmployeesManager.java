/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Employee;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IEmployeesManager {
    public void addEmployee(String employeeName);
    public Employee getEmployeeById(int id);    
    public List<Employee> getAllEmployees();
}
