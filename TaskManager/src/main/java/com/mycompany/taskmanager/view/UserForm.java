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
public class UserForm extends JPanel {
    
    private JTextField userId = new JTextField();
    private JTextField userName = new JTextField();
    private JButton addUserButton = new JButton("Add User");
    private JButton deleteUserButton = new JButton("Delete User");
    private JButton saveUsers = new JButton("Save users");
    private JButton openFile = new JButton("Open file");
    private JLabel userIdLabel = new JLabel("User ID:");
    private JLabel userNameLabel = new JLabel("User Full Name:");
    private JTable userTable = new JTable();
    private JScrollPane pane = new JScrollPane(userTable);
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JFileChooser chooseFile = new JFileChooser(System.getProperty("user.dir"));
    
    /**
     * Constructor for UserForm
     * sets layout
     * set bounds for every element in the sub task form
     * adds all the elements to the task form
     * creates columns and names for the table
     * sets the table
     */
    public UserForm() {
        super();
        this.setLayout(null);
        this.pane.setBounds(0,0,880,200);
        this.userIdLabel.setBounds(10, 220, 100, 25);
        this.userId.setBounds(150,220,200,25);
        this.userNameLabel.setBounds(10, 250, 100, 25);
        this.userName.setBounds(150,250,200,25);
        this.addUserButton.setBounds(150, 280, 200, 25);
        this.deleteUserButton.setBounds(150, 310, 200, 25);
        this.openFile.setBounds(150, 340, 200, 25);
        this.saveUsers.setBounds(150, 370, 200, 25);
        this.add(pane);
        this.add(userIdLabel);
        this.add(userId);
        this.add(userNameLabel);
        this.add(userName);
        this.add(addUserButton);
        this.add(deleteUserButton);
        this.add(saveUsers);
        this.add(openFile);
        Object[] columns = {"User Id", "User Full Name"};
        this.tableModel.setColumnIdentifiers(columns);
        this.userTable.setModel(tableModel);
        this.userTable.setRowHeight(25);
    }
    /**
     * Get the value of saveUsers
     *
     * @return the value of saveUsers
     */
    public JButton getSaveUsers() {
        return saveUsers;
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
     * Get the value of userName
     *
     * @return the value of userName
     */
    public JTextField getUserName() {
        return userName;
    }

    /**
     * Get the value of userId
     *
     * @return the value of userId
     */
    public JTextField getUserId() {
        return userId;
    }

    /**
     * Get the value of addUserButton
     *
     * @return the value of addUserButton
     */
    public JButton getaddUserButton() {
        return addUserButton;
    }

    /**
     * Get the value of userTable
     *
     * @return the value of userTable
     */
    public JTable getUserTable() {
        return this.userTable;
    }

    /**
     * Get the value of deleteUserButton
     *
     * @return the value of deleteUserButton
     */
    public JButton getDeleteUserButton() {
        return deleteUserButton;
    }

    /**
     * Get the value of tableModel
     *
     * @return the value of tableModel
     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
