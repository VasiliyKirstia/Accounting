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
public class Window {
    public Window(JPanel panel){
        JFrame frame = new JFrame("Главное окно.");
        frame.add(panel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
