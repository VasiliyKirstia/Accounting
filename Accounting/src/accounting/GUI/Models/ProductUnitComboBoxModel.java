/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.GUI.Models;
import accounting.Models.ProductUnit;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author vasiliy
 */
public class ProductUnitComboBoxModel extends DefaultComboBoxModel<ProductUnit>{

    public ProductUnitComboBoxModel() {
        super();
    }

    @Override
    public ProductUnit getSelectedItem() {
        return (ProductUnit)super.getSelectedItem();
    }
}
