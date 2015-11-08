/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author vasiliy
 */
public class WindowsFactory {
    public static void createFrame(JPanel panel, String title){
        JFrame frame = new JFrame(title);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void createDialog(JFrame parent, JPanel panel, String title){
        JDialog dialog = new JDialog(parent, title);
        dialog.setModal(true);
        dialog.add(panel);
        dialog.pack();
        dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
