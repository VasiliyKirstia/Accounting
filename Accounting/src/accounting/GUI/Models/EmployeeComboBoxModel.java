/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.GUI.Models;
import accounting.Models.Employee;
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
}
