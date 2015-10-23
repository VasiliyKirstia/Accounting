/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author vasiliy
 */
public class MastersFactory {
    public static void createFrame(JPanel panel, String title){
        JFrame frame = new JFrame(title);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
