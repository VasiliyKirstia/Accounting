/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.PostgreManagers;

import accounting.Interfaces.IEmployeesManager;
import accounting.Models.Employee;
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
public class PostgreEmployeesManager implements IEmployeesManager{

    @Override
    public void addEmployee(String employeeName){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("INSERT INTO employee (name) VALUES (?)");
            prepSt.setString(1, employeeName);
            prepSt.executeUpdate();
        }catch(SQLException e){}
    }

    @Override
    public Employee getEmployeeById(int id){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            PreparedStatement prepSt = con.prepareStatement("SELECT * FROM employee WHERE id = ?");
            prepSt.setInt(1, id);
            ResultSet resultSet = prepSt.executeQuery();

            if(resultSet.next()){
                return new Employee(resultSet.getInt("id"), resultSet.getString("name"));
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees(){
        try(Connection con = DriverManager.getConnection(CONECTION_STRING, USERNAME, PASSWORD)){
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM employee");
            List<Employee> employees = new LinkedList<Employee>();
            while(resultSet.next()){
                employees.add(new Employee(resultSet.getInt("id"), resultSet.getString("name")));
            }
            return employees;
        }catch(SQLException e){
            return null;
        }
    }

}
