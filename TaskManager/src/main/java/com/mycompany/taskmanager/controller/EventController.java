/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.model.SubTask;
import com.mycompany.taskmanager.model.Task;
import com.mycompany.taskmanager.model.TaskManager;
import com.mycompany.taskmanager.model.User;
import com.mycompany.taskmanager.view.DataViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author orsol
 */
public class EventController implements ActionListener {
    
    private DataViewer dView;
    private TaskManager taskManagerModel;
    
    /**
     * EventController for adding action listener and setting action commands  
     *
     * @param tm new value of TaskManager
     * @param dv new value of DataViewer
     */
    public EventController(TaskManager tm, DataViewer dv){
        this.dView = dv;
        this.taskManagerModel = tm;
        this.dView.getButtonPanel().getQuitWindow().addActionListener(this);
        this.dView.getButtonPanel().getQuitWindow().setActionCommand("quitWindow");
        this.dView.getAddUserForm().getaddUserButton().addActionListener(this);
        this.dView.getAddUserForm().getaddUserButton().setActionCommand("addUserToTheTable");
        this.dView.getAddTaskForm().getAddTaskButton().addActionListener(this);
        this.dView.getAddTaskForm().getAddTaskButton().setActionCommand("addTaskToTheTable");
        this.dView.getAddSubTaskForm().getAddSubTaskButton().addActionListener(this);
        this.dView.getAddSubTaskForm().getAddSubTaskButton().setActionCommand("addSubTaskToTheTable");
        this.dView.getAddUserForm().getDeleteUserButton().addActionListener(this);
        this.dView.getAddUserForm().getDeleteUserButton().setActionCommand("deleteUserFromTable");
        this.dView.getAddTaskForm().getRemoveTaskButton().addActionListener(this);
        this.dView.getAddTaskForm().getRemoveTaskButton().setActionCommand("deleteTaskFromTable");
        this.dView.getAddSubTaskForm().getDeleteSubTaskButton().addActionListener(this);
        this.dView.getAddSubTaskForm().getDeleteSubTaskButton().setActionCommand("deleteSubTaskFromTable");
        this.dView.getAddTaskForm().getAssignTaskToAUser().addActionListener(this);
        this.dView.getAddTaskForm().getAssignTaskToAUser().setActionCommand("assignTaskToAUser");
        this.dView.getAddUserForm().getOpenFile().addActionListener(this);
        this.dView.getAddUserForm().getOpenFile().setActionCommand("openFileInUser");
        this.dView.getAddTaskForm().getOpenFile().addActionListener(this);
        this.dView.getAddTaskForm().getOpenFile().setActionCommand("openFileInTask");
        this.dView.getAddSubTaskForm().getOpenFile().addActionListener(this);
        this.dView.getAddSubTaskForm().getOpenFile().setActionCommand("openFileInSubTask");
        this.dView.getAddUserForm().getSaveUsers().addActionListener(this);
        this.dView.getAddUserForm().getSaveUsers().setActionCommand("saveUsers");
        this.dView.getAddTaskForm().getSaveTasks().addActionListener(this);
        this.dView.getAddTaskForm().getSaveTasks().setActionCommand("saveTasks");
        this.dView.getAddSubTaskForm().getSaveSubTasks().addActionListener(this);
        this.dView.getAddSubTaskForm().getSaveSubTasks().setActionCommand("saveSubTasks");
    }
    
    /**
     * ActionPerformed method that gets the action command and for every case does something functional in the GUI
     *
     * @param e new value of e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){    
            case "quitWindow":
                System.out.println("Quit button has been clicked");
                System.exit(0);
                break;
            case "addUserToTheTable":
                String userID =this.dView.getAddUserForm().getUserId().getText();
                String userName=this.dView.getAddUserForm().getUserName().getText();
                writeUserData(userID,userName);
                List<User> users = ReadUserData();
                RefreshUserTableUI(users);
                this.dView.getAddUserForm().getUserId().setText("");
                this.dView.getAddUserForm().getUserName().setText("");
                break;
            case "addTaskToTheTable":
                String taskID =this.dView.getAddTaskForm().getTaskIdField().getText();
                String taskTitle=this.dView.getAddTaskForm().getTaskTitleField().getText();
                String taskPriority=this.dView.getAddTaskForm().getTaskPriorityField().getText();
                String taskTargetDate=this.dView.getAddTaskForm().getTaskTargetDateField().getText();
                writeTaskData(taskID,taskTitle,Integer.parseInt(taskPriority),LocalDate.parse(taskTargetDate));
                List<Task> tasks = ReadTaskData();
                RefreshTaskTableUI(tasks);
                this.dView.getAddTaskForm().getTaskIdField().setText("");
                this.dView.getAddTaskForm().getTaskTitleField().setText("");
                this.dView.getAddTaskForm().getTaskPriorityField().setText("");
                this.dView.getAddTaskForm().getTaskTargetDateField().setText("");
                break;
                
            case "addSubTaskToTheTable":
                String subTaskSequence =this.dView.getAddSubTaskForm().getSubTaskSequenceField().getText();
                String subTaskTitle =this.dView.getAddSubTaskForm().getSubTaskTitleField().getText();
                String subTaskCompleted =this.dView.getAddSubTaskForm().getSubTaskCompletedField().getText();
                String taskIDforSubtask =this.dView.getAddSubTaskForm().getTaskIDField().getText();
                writeSubTaskData(Integer.parseInt(subTaskSequence), subTaskTitle, Boolean.parseBoolean(subTaskCompleted), taskIDforSubtask);
                List<Task> tasks2 = ReadTaskData();
                RefreshSubTaskTableUI2(tasks2);
                this.dView.getAddSubTaskForm().getTaskIDField().setText("");
                this.dView.getAddSubTaskForm().getSubTaskSequenceField().setText("");
                this.dView.getAddSubTaskForm().getSubTaskTitleField().setText("");
                this.dView.getAddSubTaskForm().getSubTaskCompletedField().setText("");
                break;
                
            case "deleteUserFromTable":
                removeUserFromTM();
                RefreshUserTableUI(this.taskManagerModel.getUsers());
                break;
                
            case "deleteTaskFromTable":
                removeTaskFromTM();
                RefreshTaskTableUI(this.taskManagerModel.getTasks());
                break;
                
            case "deleteSubTaskFromTable":
                removeSubTaskFromTM();
                RefreshSubTaskTableUI2(this.taskManagerModel.getTasks());
                break;
                
            case "assignTaskToAUser":
                String selectedTaskID =this.dView.getAddTaskForm().getSelectedTaskIdField().getText();
                String selectedUserID =this.dView.getAddTaskForm().getSelectedUserIdField().getText();
                this.taskManagerModel.getUser(selectedUserID).addTask(this.taskManagerModel.getTask(selectedTaskID));
                List<User> usersTasks1 = ReadUserData();
                List<Task> tasks1 = ReadTaskData();
                RefreshTaskTableUI2(usersTasks1,tasks1);
                this.dView.getAddTaskForm().getSelectedUserIdField().setText("");
                this.dView.getAddTaskForm().getSelectedTaskIdField().setText("");
                break;
            
            case "openFileInUser":
                int uResponse = this.dView.getAddUserForm().getChooseFile().showOpenDialog(dView);
                if (uResponse == JFileChooser.APPROVE_OPTION){
                    this.taskManagerModel.readUsersFromCsvFile(this.dView.getAddUserForm().getChooseFile().getSelectedFile().toString());
                    System.out.println(this.taskManagerModel.getUsers().toString());
                    List<User> usersFromFile = ReadUserData();
                    RefreshUserTableUI(usersFromFile);
                }else{
                    System.out.println("It has been cancelled");
                }
                break;
                
            case "openFileInTask":
                int tResponse = this.dView.getAddTaskForm().getChooseFile().showOpenDialog(dView);
                if (tResponse == JFileChooser.APPROVE_OPTION){
                    this.taskManagerModel.readTasksFromCsvFile(this.dView.getAddTaskForm().getChooseFile().getSelectedFile().toString());
                    System.out.println(this.taskManagerModel.getTasks().toString());
                    List<Task> tasksFromFile = ReadTaskData();
                    RefreshTaskTableUI(tasksFromFile);
                }else{
                    System.out.println("It has been cancelled");
                }
                break;
                
                case "openFileInSubTask":
                int stResponse = this.dView.getAddSubTaskForm().getChooseFile().showOpenDialog(dView);
                if (stResponse == JFileChooser.APPROVE_OPTION){
                    this.taskManagerModel.readSubTasksFromCsvFile(this.dView.getAddSubTaskForm().getChooseFile().getSelectedFile().toString());
                    System.out.println(this.taskManagerModel.getTasks().toString());
                    List<Task> tasks3 = ReadTaskData();
                    RefreshSubTaskTableUI2(tasks3);
                }else{
                    System.out.println("It has been cancelled");
                }
                break;
            
            case "saveUsers":
                int saveUResponse = this.dView.getAddUserForm().getChooseFile().showSaveDialog(dView);
                if (saveUResponse == JFileChooser.APPROVE_OPTION){
                    this.taskManagerModel.writeUsersToCsvFile(this.dView.getAddUserForm().getChooseFile().getSelectedFile().toString());
                }else{
                    System.out.println("It has been cancelled");
                }
                break;
                
            case "saveTasks":
                int saveTResponse = this.dView.getAddTaskForm().getChooseFile().showSaveDialog(dView);
                if (saveTResponse == JFileChooser.APPROVE_OPTION){
                    this.taskManagerModel.writeTasksToCsvFile(this.dView.getAddTaskForm().getChooseFile().getSelectedFile().toString());
                }else{
                    System.out.println("It has been cancelled");
                }
                break;
                
            case "saveSubTasks":
                int saveSTResponse = this.dView.getAddSubTaskForm().getChooseFile().showSaveDialog(dView);
                if (saveSTResponse == JFileChooser.APPROVE_OPTION){
                    this.taskManagerModel.writeSubTasksToCsvFile(this.dView.getAddSubTaskForm().getChooseFile().getSelectedFile().toString());
                }else{
                    System.out.println("It has been cancelled");
                }
                break;       
        }
    }
    /**
     * Reads the users from the task manager  
     *
     * @return the list of users
     */
    public List<User> ReadUserData(){
        return this.taskManagerModel.getUsers();
    }
    /**
     * Adds users to the task manager 
     *
     * @param id new value of id
     * @param name new value of name
     */
    public void writeUserData(String id, String name){    
        User u1 = new User(id, name);
        this.taskManagerModel.addUser(u1);
    }
    /**
     * Writes users to the table in the GUI 
     *
     * @param userList new value of userList
     */
    public void RefreshUserTableUI(List<User> userList){
        this.dView.getAddUserForm().getTableModel().setRowCount(0); 
        for(User u: userList){
            this.dView.getAddUserForm().getTableModel().addRow(new Object[]{u.getId(),u.getName()});
        }  
    }
    /**
     * Reads the tasks from the task manager  
     *
     * @return the list of tasks
     */
    public List<Task> ReadTaskData(){
        return this.taskManagerModel.getTasks();
    }
    /**
     * Adds tasks to the task manager 
     *
     * @param id new value of id
     * @param title new value of title
     * @param priority new value of priority
     * @param targetDate new value of targetDate
     */
    public void writeTaskData(String id, String title, int priority, LocalDate targetDate){
        Task t1 = new Task(id, title, priority, targetDate);
        this.taskManagerModel.addTask(t1);
    }
    /**
     * Writes tasks to the table in the GUI 
     *
     * @param userList new value of userList
     * @param taskList new value of taskList
     */
    public void RefreshTaskTableUI2(List<User> userList, List<Task> taskList){
        List<String> encountered= new ArrayList<>();
        this.dView.getAddTaskForm().getTableModel().setRowCount(0);
        //Tasks assigned to user 
        for(User u: userList){
            for(Task t: u.getTasks()){
                //store task as encountered
                encountered.add(t.getId());
                this.dView.getAddTaskForm().getTableModel().addRow(new Object[]{t.getId(),t.getTitle(),t.getPriority(), t.getTargetDate(), u.getId()});
             }
         }
        //Tasks not assigned to a user
        for(Task t: taskList){
            for(String ownedTaskID: encountered){
               if(!ownedTaskID.equals(t.getId())){
                   this.dView.getAddTaskForm().getTableModel().addRow(new Object[]{t.getId(),t.getTitle(),t.getPriority(), t.getTargetDate()});
               }
            }
        }
    }
    /**
     * Writes tasks to the table in the GUI 
     *
     * @param taskList new value of taskList
     */
    public void RefreshTaskTableUI(List<Task> taskList){
        this.dView.getAddTaskForm().getTableModel().setRowCount(0);
        for(Task t: taskList){
             this.dView.getAddTaskForm().getTableModel().addRow(new Object[]{t.getId(),t.getTitle(),t.getPriority(), t.getTargetDate()});  
        }
    }    
     
    /**
     * Writes sub tasks to the table in the GUI 
     *
     * @param taskList new value of taskList
     */ 
    public void RefreshSubTaskTableUI2(List<Task> taskList){
      this.dView.getAddSubTaskForm().getTableModel().setRowCount(0);
      //Tasks assigned to user 
      for(Task t: taskList){
          for(SubTask st: t.getSubTasks()){
              this.dView.getAddSubTaskForm().getTableModel().addRow(new Object[]{st.getSequence(),st.getTitle(),st.isCompleted(), t.getId()});
           }
       }
    }
    /**
     * Adds sub tasks to the task that's in task manager 
     *
     * @param sequence new value of sequence
     * @param title new value of title
     * @param completed new value of completed
     * @param taskID new value of taskID
     */
    public void writeSubTaskData(int sequence, String title, boolean completed, String taskID){    
        SubTask st = new SubTask(sequence, title, completed);
        for(Task t: this.taskManagerModel.getTasks()){
            if(t.getId().equals(taskID)){
                 t.addSubTask(st);
            } 
        }
        System.out.println("Subtask in the list after adding it:" +this.taskManagerModel.getTask(taskID).getSubTasks().toString());
    }
    /**
     * Gets the row id from the user table that has been selected 
     *
     * @return row id as a String
     */
    public String getUserRowID(){
        int column = 0;
        int row = this.dView.getAddUserForm().getUserTable().getSelectedRow();
        String value = this.dView.getAddUserForm().getUserTable().getModel().getValueAt(row, column).toString();
        return value;
    }
    /**
     * Remove user from the task manager  that has been selected in the table
     *
     */
    public void removeUserFromTM(){
        User userSelected = this.taskManagerModel.getUser(getUserRowID());
        this.taskManagerModel.removeUser(userSelected);
    }
    /**
     * Gets the row id from the task table that has been selected 
     *
     * @return row id as a String
     */
    public String getTaskRowID(){
        int column = 0;
        int row = this.dView.getAddTaskForm().getTaskTable().getSelectedRow();
        String value = this.dView.getAddTaskForm().getTaskTable().getModel().getValueAt(row, column).toString();
        return value;
    }
    /**
     * Remove task from the task manager  that has been selected in the table
     *
     */
    public void removeTaskFromTM(){
        Task taskSelected = this.taskManagerModel.getTask(getTaskRowID());
        this.taskManagerModel.removeTask(taskSelected);
    }
   /**
     * Gets the row id from the sub task table that has been selected 
     * Removes the sub task from the task that's in the task manager
     */  
   public void removeSubTaskFromTM(){
        int row = this.dView.getAddSubTaskForm().getSubTaskTable().getSelectedRow();
        String taskID = this.dView.getAddSubTaskForm().getSubTaskTable().getModel().getValueAt(row, 3).toString();
        String subTaskTitle = this.dView.getAddSubTaskForm().getSubTaskTable().getModel().getValueAt(row, 1).toString();
       
        for(Task t: this.taskManagerModel.getTasks()){
            if(t.getId().equals(taskID)){
                 t.removeSubTask(subTaskTitle);
            } 
        }
        System.out.println("Subtask in the list after deletion:" + this.taskManagerModel.getTask(taskID).getSubTasks().toString());
    }
    
}
