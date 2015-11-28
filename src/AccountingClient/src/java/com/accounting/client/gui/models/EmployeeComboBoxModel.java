/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.gui.models;
import com.accounting.client.utils.NotSupportedServicesException;
import com.accounting.client.utils.RemoteServicesProvider;
import com.accounting.interfaces.IEmployeesServices;
import com.accounting.models.Employee;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author vasiliy
 */
public class EmployeeComboBoxModel extends DefaultComboBoxModel<Employee>{

    public EmployeeComboBoxModel() {
        super();
    }

    @Override
    public Employee getSelectedItem() {
        return (Employee)super.getSelectedItem(); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(){
        IEmployeesServices employeesServices = null;
        try{
            employeesServices = RemoteServicesProvider.getInstance().<IEmployeesServices>getServices(IEmployeesServices.class);
        }catch(NotSupportedServicesException e){
            System.err.println("NotSupportedServicesException");
        }
        
        if(null != employeesServices){
            this.removeAllElements();
            for(Employee employee: employeesServices.getAllEmployees())
                this.addElement(employee);
        }
    }
}
