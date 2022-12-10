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
public class SubTaskForm extends JPanel {
    
    private JTextField subTaskSequenceField = new JTextField();
    private JTextField subTaskTitleField = new JTextField();
    private JTextField subTaskCompletedField = new JTextField();
    private JTextField taskIDField = new JTextField();
    private JButton addSubTaskButton = new JButton("Add Subtask");
    private JButton deleteSubTaskButton = new JButton("Delete Subtask");
    private JButton openFile = new JButton("Open file");
    private JButton saveSubTasks = new JButton("Save Subtasks");
    private JLabel subTaskSequenceLabel = new JLabel("Subtask sequence number:");
    private JLabel subTaskTitleLabel = new JLabel("Subtask Title:");
    private JLabel subTaskCompletedLabel = new JLabel("Subtask completed (true/false):");
    private JLabel taskIDLabel = new JLabel("Task ID");
    private JTable subTaskTable = new JTable();
    private JScrollPane pane = new JScrollPane(subTaskTable);
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JFileChooser chooseFile = new JFileChooser(System.getProperty("user.dir"));

    /**
     * Constructor for subTaskForm
     * sets layout
     * set bounds for every element in the sub task form
     * adds all the elements to the sub task form
     * creates columns and names for the table
     * sets the table
     */
    public SubTaskForm(){
        super();
        this.setLayout(null);
        this.pane.setBounds(0,0,880,200);
        this.subTaskSequenceLabel.setBounds(10, 220, 200, 25);
        this.subTaskSequenceField.setBounds(250,220,200,25);
        this.subTaskTitleLabel.setBounds(10, 250, 200, 25);
        this.subTaskTitleField.setBounds(250,250,200,25);
        this.subTaskCompletedLabel.setBounds(10, 280, 200, 25);
        this.subTaskCompletedField.setBounds(250, 280, 200, 25);
        this.taskIDLabel.setBounds(10, 310, 200, 25);
        this.taskIDField.setBounds(250, 310, 200, 25);
        this.addSubTaskButton.setBounds(250, 340, 200, 25);
        this.deleteSubTaskButton.setBounds(250, 370, 200, 25);
        this.openFile.setBounds(250,400,200,25);
        this.saveSubTasks.setBounds(250, 430, 200, 25);
        this.add(pane);
        this.add(subTaskSequenceLabel);
        this.add(subTaskSequenceField);
        this.add(subTaskTitleLabel);
        this.add(subTaskTitleField);
        this.add(subTaskCompletedLabel);
        this.add(subTaskCompletedField);
        this.add(taskIDLabel);
        this.add(taskIDField);
        this.add(addSubTaskButton);
        this.add(deleteSubTaskButton);
        this.add(openFile);
        this.add(saveSubTasks);
        Object[] columns = {"Subtask sequence number", "Subtask Title", "Completed (true/false)", "Task ID"};
        this.tableModel.setColumnIdentifiers(columns);
        this.subTaskTable.setModel(tableModel);
        this.subTaskTable.setRowHeight(25);
    }
    /**
     * Get the value of saveSubTasks
     *
     * @return the value of saveSubTasks
     */
    public JButton getSaveSubTasks() {
        return saveSubTasks;
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
     * Get the value of chooseFile
     *
     * @return the value of chooseFile
     */
    public JFileChooser getChooseFile() {
        return chooseFile;
    }

    /**
     * Get the value of deleteSubTaskButton
     *
     * @return the value of deleteSubTaskButton
     */
    public JButton getDeleteSubTaskButton() {
        return deleteSubTaskButton;
    }

    /**
     * Get the value of taskIDLabel
     *
     * @return the value of taskIDLabel
     */
    public JLabel getTaskIDLabel() {
        return taskIDLabel;
    }

    /**
     * Get the value of taskIDField
     *
     * @return the value of taskIDField
     */
    public JTextField getTaskIDField() {
        return taskIDField;
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
     * Get the value of subTaskTable
     *
     * @return the value of subTaskTable
     */
    public JTable getSubTaskTable() {
        return subTaskTable;
    }

    /**
     * Get the value of subTaskCompletedLabel
     *
     * @return the value of subTaskCompletedLabel
     */
    public JLabel getSubTaskCompletedLabel() {
        return subTaskCompletedLabel;
    }
    
    /**
     * Get the value of subTaskTitleLabel
     *
     * @return the value of subTaskTitleLabel
     */
    public JLabel getSubTaskTitleLabel() {
        return subTaskTitleLabel;
    }

    /**
     * Get the value of subTaskSequenceLabel
     *
     * @return the value of subTaskSequenceLabel
     */
    public JLabel getSubTaskSequenceLabel() {
        return subTaskSequenceLabel;
    }

    /**
     * Get the value of addSubTaskButton
     *
     * @return the value of addSubTaskButton
     */
    public JButton getAddSubTaskButton() {
        return addSubTaskButton;
    }
    
    /**
     * Get the value of subTaskCompletedField
     *
     * @return the value of subTaskCompletedField
     */
    public JTextField getSubTaskCompletedField() {
        return subTaskCompletedField;
    }

    /**
     * Get the value of subTaskTitleField
     *
     * @return the value of subTaskTitleField
     */
    public JTextField getSubTaskTitleField() {
        return subTaskTitleField;
    }

    /**
     * Get the value of subTaskSequenceField
     *
     * @return the value of subTaskSequenceField
     */
    public JTextField getSubTaskSequenceField() {
        return subTaskSequenceField;
    }
}
