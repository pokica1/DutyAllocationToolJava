/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taskmanager.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author orsol
 */
public class DataViewer extends JFrame {
    
    private ButtonPanel buttonPanel = new ButtonPanel();
    private JTabbedPane tabPane = new JTabbedPane();
    private UserForm addUserForm = new UserForm(); 
    private TaskForm addTaskForm = new TaskForm();
    private SubTaskForm addSubTaskForm = new SubTaskForm();
    
    
    public DataViewer(){
        super();
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        tabPane.addTab("User", addUserForm);
        tabPane.addTab("Task", addTaskForm);
        tabPane.addTab("Subtask", addSubTaskForm);
        this.add(tabPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    /**
     * Get the value of addSubTaskForm
     *
     * @return the value of addSubTaskForm
     */
    public SubTaskForm getAddSubTaskForm() {
        return addSubTaskForm;
    }

    /**
     * Set the value of addSubTaskForm
     *
     * @param addSubTaskForm new value of addSubTaskForm
     */
    public void setAddSubTaskForm(SubTaskForm addSubTaskForm) {
        this.addSubTaskForm = addSubTaskForm;
    }
    
    
    /**
     * Get the value of addTaskForm
     *
     * @return the value of addTaskForm
     */
    public TaskForm getAddTaskForm() {
        return addTaskForm;
    }

    /**
     * Set the value of addTaskForm
     *
     * @param addTaskForm new value of addTaskForm
     */
    public void setAddTaskForm(TaskForm addTaskForm) {
        this.addTaskForm = addTaskForm;
    }

    /**
     * Get the value of addUserForm
     *
     * @return the value of addUserForm
     */
    public UserForm getAddUserForm() {
        return addUserForm;
    }

    /**
     * Set the value of addUserForm
     *
     * @param addUserForm new value of addUserForm
     */
    public void setAddUserForm(UserForm addUserForm) {
        this.addUserForm = addUserForm;
    }
    
    /**
     * Get the value of tabPane
     *
     * @return the value of tabPane
     */
    public JTabbedPane getTabPane() {
        return tabPane;
    }

    /**
     * Set the value of tabPane
     *
     * @param tabPane new value of tabPane
     */
    public void setTabPane(JTabbedPane tabPane) {
        this.tabPane = tabPane;
    }
    
    /**
     * Get the value of buttonPanel
     *
     * @return the value of buttonPanel
     */
    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    /**
     * Set the value of buttonPanel
     *
     * @param buttonPanel new value of buttonPanel
     */
    public void setButtonPanel(ButtonPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    
}
