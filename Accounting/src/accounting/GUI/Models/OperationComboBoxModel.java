/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.GUI.Models;
import accounting.Models.Operation;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author vasiliy
 */
public class OperationComboBoxModel extends DefaultComboBoxModel<Operation>{

    public OperationComboBoxModel() {
        super();
    }

    @Override
    public Operation getSelectedItem() {
        return (Operation)super.getSelectedItem();
    }
}
