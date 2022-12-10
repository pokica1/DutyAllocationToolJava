/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taskmanager.view;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author orsol
 */
public class TaskForm extends JPanel {
    
    private JTextField taskIdField = new JTextField();
    private JTextField taskTitleField = new JTextField();
    private JTextField taskPriorityField = new JTextField();
    private JTextField taskTargetDateField = new JTextField(); 
    private JTextField selectedTaskIdField = new JTextField();
    private JTextField selectedUserIdField = new JTextField();
    private JButton addTaskButton = new JButton("Add Task");
    private JButton removeTaskButton = new JButton("Delete Task");
    private JButton assignTaskToAUser = new JButton("Assign the task to the user"); 
    private JButton openFile = new JButton("Open file");
    private JButton saveTasks = new JButton("Save Tasks");
    private JLabel taskIdLabel = new JLabel("Task ID:");
    private JLabel taskTitleLabel = new JLabel("Task Title:");
    private JLabel taskPriorityLabel = new JLabel("Task Priority Number:");
    private JLabel taskTargetDateLabel = new JLabel("Task Target Date:");
    private JLabel selectedTaskIdLabel = new JLabel("Task ID to assign to a user:");
    private JLabel selectedUserIdLabel = new JLabel("User ID to assign to a task:");
    private JTable taskTable = new JTable();
    private JScrollPane pane = new JScrollPane(taskTable);
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JFileChooser chooseFile = new JFileChooser(System.getProperty("user.dir"));
    
   /**
     * Constructor for TaskForm
     * sets layout
     * set bounds for every element in the sub task form
     * adds all the elements to the task form
     * creates columns and names for the table
     * sets the table
     */
    public TaskForm(){
        super();
        this.setLayout(null);
        this.pane.setBounds(0,0,920,200);
        this.taskIdLabel.setBounds(10, 220, 150, 25);
        this.taskIdField.setBounds(150,220,200,25);
        this.taskTitleLabel.setBounds(10, 250, 150, 25);
        this.taskTitleField.setBounds(150,250,200,25);
        this.taskPriorityLabel.setBounds(10, 280, 150, 25);
        this.taskPriorityField.setBounds(150, 280, 200, 25);
        this.taskTargetDateLabel.setBounds(10, 310, 150, 25);
        this.taskTargetDateField.setBounds(150, 310, 200, 25);
        this.selectedTaskIdLabel.setBounds(400,220,200,25);
        this.selectedTaskIdField.setBounds(600,220,200,25);
        this.selectedUserIdLabel.setBounds(400,250,200,25);
        this.selectedUserIdField.setBounds(600,250,200,25);
        this.addTaskButton.setBounds(150, 340, 200, 25);
        this.removeTaskButton.setBounds(150, 370, 200, 25);
        this.openFile.setBounds(150, 400, 200, 25);
        this.saveTasks.setBounds(150, 430, 200, 25);
        this.assignTaskToAUser.setBounds(600, 280, 200, 25);
        this.add(pane);
        this.add(taskIdLabel);
        this.add(taskIdField);
        this.add(taskTitleLabel);
        this.add(taskTitleField);
        this.add(taskPriorityLabel);
        this.add(taskPriorityField);
        this.add(taskTargetDateLabel);
        this.add(taskTargetDateField);
        this.add(selectedTaskIdLabel);
        this.add(selectedTaskIdField);
        this.add(selectedUserIdLabel);
        this.add(selectedUserIdField);
        this.add(addTaskButton);
        this.add(removeTaskButton);
        this.add(assignTaskToAUser);
        this.add(openFile);
        this.add(saveTasks);
        Object[] columns = {"Task ID", "Task Title", "Task Priority", "Task Target Date", "Assigned User ID"};
        this.tableModel.setColumnIdentifiers(columns);
        this.taskTable.setModel(tableModel);
        this.taskTable.setRowHeight(25);
    }
    /**
     * Get the value of saveTasks
     *
     * @return the value of saveTasks
     */
    public JButton getSaveTasks() {
        return saveTasks;
    }

     /**
     * Get the value of chooseFile
     *
     * @return the value of chooseFile
     */
    public JFileChooser getChooseFile() {
        return chooseFile;
    }

    /**
     * Get the value of openFile
     *
     * @return the value of openFile
     */
    public JButton getOpenFile() {
        return openFile;
    }

    /**
     * Get the value of assignTaskToAUser
     *
     * @return the value of assignTaskToAUser
     */
    public JButton getAssignTaskToAUser() {
        return assignTaskToAUser;
    }

    /**
     * Get the value of selectedUserIdLabel
     *
     * @return the value of selectedUserIdLabel
     */
    public JLabel getSelectedUserIdLabel() {
        return selectedUserIdLabel;
    }

    /**
     * Get the value of selectedUserIdField
     *
     * @return the value of selectedUserIdField
     */
    public JTextField getSelectedUserIdField() {
        return selectedUserIdField;
    }

    /**
     * Get the value of selectedTaskIdField
     *
     * @return the value of selectedTaskIdField
     */
    public JTextField getSelectedTaskIdField() {
        return selectedTaskIdField;
    }

    /**
     * Get the value of selectedTaskIdLabel
     *
     * @return the value of selectedTaskIdLabel
     */
    public JLabel getSelectedTaskIdLabel() {
        return selectedTaskIdLabel;
    }

    /**
     * Get the value of tableModel
     *
     * @return the value of tableModel
     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    /**
     * Get the value of taskTable
     *
     * @return the value of taskTable
     */
    public JTable getTaskTable() {
        return taskTable;
    }

    /**
     * Get the value of taskTargetDateLabel
     *
     * @return the value of taskTargetDateLabel
     */
    public JLabel getTaskTargetDateLabel() {
        return taskTargetDateLabel;
    }

    /**
     * Get the value of taskPriorityLabel
     *
     * @return the value of taskPriorityLabel
     */
    public JLabel getTaskPriorityLabel() {
        return taskPriorityLabel;
    }

    /**
     * Get the value of taskTitleLabel
     *
     * @return the value of taskTitleLabel
     */
    public JLabel getTaskTitleLabel() {
        return taskTitleLabel;
    }
    
    /**
     * Get the value of taskIdLabel
     *
     * @return the value of taskIdLabel
     */
    public JLabel getTaskIdLabel() {
        return taskIdLabel;
    }
    
    /**
     * Get the value of addTaskButton
     *
     * @return the value of addTaskButton
     */
    public JButton getAddTaskButton() {
        return addTaskButton;
    }

    /**
     * Get the value of taskTargetDateField
     *
     * @return the value of taskTargetDateField
     */
    public JTextField getTaskTargetDateField() {
        return taskTargetDateField;
    }

    /**
     * Get the value of taskPriorityField
     *
     * @return the value of taskPriorityField
     */
    public JTextField getTaskPriorityField() {
        return taskPriorityField;
    }

    /**
     * Get the value of taskTitleField
     *
     * @return the value of taskTitleField
     */
    public JTextField getTaskTitleField() {
        return taskTitleField;
    }

    /**
     * Get the value of taskIdField
     *
     * @return the value of taskIdField
     */
    public JTextField getTaskIdField() {
        return taskIdField;
    }

    /**
     * Get the value of removeTaskButton
     *
     * @return the value of removeTaskButton
     */
    public JButton getRemoveTaskButton() {
        return removeTaskButton;
    }
}
