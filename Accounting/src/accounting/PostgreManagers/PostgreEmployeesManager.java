/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.PostgreManagers;

import accounting.Interfaces.IEmployeesManager;
import accounting.Models.Employee;
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
public class PostgreEmployeesManager implements IEmployeesManager{

    @Override
    public void addEmployee(Connection con, String employeeName) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("INSERT INTO employee (name) VALUES (?)");
        prepSt.setString(1, employeeName);
        prepSt.executeUpdate();
    }

    @Override
    public Employee getEmployeeById(Connection con, int id) throws Exception {
        PreparedStatement prepSt = con.prepareStatement("SELECT * FROM employee WHERE id = ?");
        prepSt.setInt(1, id);
        ResultSet resultSet = prepSt.executeQuery();
        
        if(resultSet.next()){
            return new Employee(resultSet.getInt("id"), resultSet.getString("name"));
        }else{
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM employee");
        List<Employee> employees = new LinkedList<Employee>();
        while(resultSet.next()){
            employees.add(new Employee(resultSet.getInt("id"), resultSet.getString("name")));
        }
        return employees;
    }

}
