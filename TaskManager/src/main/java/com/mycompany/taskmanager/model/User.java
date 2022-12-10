/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taskmanager.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orsol
 */
public class User {

    private String id;
    
    private String name;

    private List<Task> tasks = new ArrayList();
    /**
     * Constructor with one parameter for User
     * 
     * @param csvLine new value of csvLine
     */
    public User(String csvLine) {
        //"1,Marge Simpson"
        String attributes[] = csvLine.split(",");
        this.id = attributes[0];
        this.name = attributes[1];
    }

    /**
     * Constructor with two parameters for User
     * 
     * @param id new value of id
     * @param name new value of name 
     */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(String id) {
        this.id = id;
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
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
  
    /**
     * toString() method for User
     *
     * @return the id and name
     */
    @Override
    public String toString() {
        return id + "," + name;
    }
    
    /**
     * Add task to user method
     * @param task that's added
     * @return the task that's added and return it as a Boolean
     */
     public boolean addTask(Task task){
        return tasks.add(task);
    }
}
