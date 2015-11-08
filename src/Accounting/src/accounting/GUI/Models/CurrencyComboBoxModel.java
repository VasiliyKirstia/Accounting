/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.GUI.Models;
import accounting.Models.Currency;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author vasiliy
 */
public class CurrencyComboBoxModel extends DefaultComboBoxModel<Currency>{

    public CurrencyComboBoxModel() {
        super();
    }

    @Override
    public Currency getSelectedItem() {
        return  (Currency)super.getSelectedItem(); //To change body of generated methods, choose Tools | Templates.
    }    
}
