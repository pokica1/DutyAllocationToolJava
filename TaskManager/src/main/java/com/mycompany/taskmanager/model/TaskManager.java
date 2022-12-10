/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taskmanager.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orsol
 */
public class TaskManager {

    private List<Task> tasks = new ArrayList();

    private List<User> users = new ArrayList();

    /**
     * Get the value of users
     *
     * @return the value of users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Set the value of users
     *
     * @param users new value of users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }


    /**
     * Get the value of tasks
     *
     * @return the value of tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Set the value of tasks
     *
     * @param tasks new value of tasks
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    /**
     * Adding a task to Task
     * @param task we are adding
     * @return the added task as Boolean
     */
    public boolean addTask(Task task){
        return tasks.add(task);
    }
    
    /**
     * Adding a user to User
     * @param user we want to add
     * @return the added user as Boolean
     */
    public boolean addUser(User user){
        return users.add(user);
    }
    
    /**
     * Getting a task using id as a parameter
     * @param id of the task
     * @return task
     */
    public Task getTask(String id){
        Task task = null;
        for(Task t: tasks){
            if (t.getId().equals(id)) task=t;
        }
        return task;
    }
    
    /**
     * Getting a user using id as a parameter
     * @param id of the user
     * @return user
     */
    public User getUser(String id){
        User user = null;
        for(User u: users){
            if (u.getId().equals(id)) user = u;
        }
        return user;
    }
    /**
     * Removing a task from Task
     *@param task that we want to remove
     * @return the removed task as Boolean
     */
    public boolean removeTask(Task task){
        return tasks.remove(task);
    }
    /**
     * Removing a user from User
     * @param user that we want to remove
     * @return the removed user, returns true or false
     */
    public boolean removeUser(User user){
        return users.remove(user);
    }
    
    /**
     * Getting the specific user and it's property that we specify in parameters
     *@param user we want to get
     * @param property we want to get
     * @return the selected value
     */
    public String getUserValue(User user, String property){
        String value = null;
        //set value to be the value of the selected property
        switch(property){
            case "name":
                   value = user.getName();
                   break;
            case "id":
                value = user.getId();
                break;
        }
        return value;
    }
    /**
     * Getting the specific task and it's property that we specify in parameters
     * @param task that we are getting
     * @param property that we are getting
     * @return the selected value
     */
    public String getTaskValue(Task task, String property){
        String value = null;
        //set value to be the value of the selected property
        switch(property){
            case "title":
                   value = task.getTitle();
                   break;
            case "priority":
                //converting the priority int to String
                   value = Integer.toString(task.getPriority());
                   break;  
            case "targetDate":
                //converting the targetDate to String
                   value = task.getTargetDate().toString();
                   break;         
            case "id":
                value = task.getId();
                break;
        }
        return value;
    }
    
    /**
     * Setting the specific task, it's property to a new value that we specify in parameters
     * @param task that we are setting
     * @param property that we are setting
     * @param value that we are setting
     * @return the result as Boolean
     */
    public boolean setTaskValue(Task task, String property, String value){
        boolean result = false;
        //set value to be the value of the selected property
        switch(property){
            case "title":
                   task.setTitle(value);
                   result = true;
                   break;
            case "priority":
                //converting the String value to integer before setting the priority 
                   task.setPriority(Integer.parseInt(value));
                   result = true;
                   break;  
            case "targetDate":
                //converting the targetDate to String
                   task.setTargetDate(LocalDate.parse(value));
                   result = true;
                   break;         
            case "id":
                task.setId(value);
                result = true;
                break;
        }
        return result;
    }
    /**
     * Setting the specific user, it's property to a new value that we specify in parameters
     * 
     * @param user that we are setting
     * @param property that we are setting
     * @param value that we are setting
     *
     * @return the result as Boolean
     */
    public boolean setUserValue(User user, String property, String value){
        boolean result = false;
        //set value to be the value of the selected property
        switch(property){
            case "name":
                user.setName(value);
                result = true;
                break;
            case "id":
                user.setId(value);
                result = true;
                break;
        }
        return result;
    }
    /**
     * Reading users from the CSV file that we specify in the parameter where to read it from
     *
     * @param filename where we read from
     */
    public void readUsersFromCsvFile(String filename){
        try (BufferedReader in = new BufferedReader(new FileReader(filename))){
            while(in.ready()){
                String csvLine = in.readLine();
                User user = new User(csvLine);
                this.addUser(user);
            }
            in.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Reading tasks from the CSV file that we specify in the parameter where to read it from
     *
     * @param filename where we read from
     */
    public void readTasksFromCsvFile(String filename){
        try (BufferedReader in = new BufferedReader(new FileReader(filename))){
            while(in.ready()){
                String csvLine = in.readLine();
                Task task = new Task(csvLine);
                this.addTask(task);
            }
            in.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Reading SubTasks from the CSV file that we specify in the parameter where to read it from
     * Note: Need to load Tasks first in order to load SubTasks!
     * @param filename where we read from
     */
    public void readSubTasksFromCsvFile(String filename){
        try (BufferedReader in = new BufferedReader(new FileReader(filename))){
            while(in.ready()){
                String csvLine = in.readLine();
                SubTask st = new SubTask(csvLine);
                String attributes[] = csvLine.split(",");
                String taskID = attributes[1];
                for(Task t: tasks){
                    if(t.getId().equals(taskID)){
                         t.addSubTask(st);
                    } 
                }
            }
            in.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Write SubTasks to a CSV file, specify the CSV file name in parameter
     *
     * @param filename where we write to
     */
    public void writeSubTasksToCsvFile(String filename){
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
            for(Task t: tasks){
                for(SubTask st: t.getSubTasks()){
                    out.write(st.toString(t.getId()));
                    out.newLine();
                }
            }
            out.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
   
    /**
     * Write tasks to a CSV file, specify the CSV file name in parameter
     *
     * @param filename where we write to
     */
    public void writeTasksToCsvFile(String filename){
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
            for(Task t: tasks){
                out.write(t.toString());
                out.newLine();
            }
            out.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Write users to a CSV file, specify the CSV file name in parameter
     *
     * @param filename where we write to
     */
    public void writeUsersToCsvFile(String filename){
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
            for(User u: users){
                out.write(u.toString());
                out.newLine();
            }
            out.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
