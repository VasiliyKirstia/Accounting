/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.GUI.Models;
import accounting.Models.Destination;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author vasiliy
 */
public class DestinationComboBoxModel extends DefaultComboBoxModel<Destination>{

    public DestinationComboBoxModel() {
        super();
    }

    @Override
    public Destination getSelectedItem() {
        return (Destination)super.getSelectedItem(); //To change body of generated methods, choose Tools | Templates.
    }
}
