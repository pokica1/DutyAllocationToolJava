/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taskmanager.view;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author orsol
 */
public class ButtonPanel extends JPanel {
  
    private JButton quitWindow = new JButton("Quit");
    
    /**
     * Constructor for buttonPanel
     * Sets the layout and add quit button to the panel
     */
    ButtonPanel(){
        super();
        this.setLayout(new FlowLayout());
        this.add(quitWindow);
    }

    /**
     * Get the value of quitWindow
     *
     * @return the value of quitWindow
     */
    public JButton getQuitWindow() {
        return quitWindow;
    }
}
