/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taskmanager.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author orsol
 */
public class Task {
  
    private int priority;

    private String title;

    private LocalDate targetDate;

    private List<SubTask> subTasks = new ArrayList();
    
    private String id;

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
     * Constructor with one parameter for Task
     * 
     * @param csvLine new value of csvLine
     */
    public Task(String csvLine) {
        //"1,Organise a party,1,2020-12-01"
        String attributes[] = csvLine.split(",");
        this.id = attributes[0];
        this.title = attributes[1];
        this.priority = Integer.parseInt(attributes[2]);
        this.targetDate = LocalDate.parse(attributes[3]);
    }
    /**
     * Constructor with four parameter for Task
     * 
     * @param priority new value of priority
     * @param title new value of title
     * @param targetDate new value of targetDate
     * @param id new value of id
     */
    public Task(String id, String title, int priority, LocalDate targetDate) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.targetDate = targetDate;
    }
    
    /**
     * Get the value of subTasks
     *
     * @return the value of subTasks
     */
    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    /**
     * Set the value of subTasks
     *
     * @param subTasks new value of subTasks
     */
    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    /**
     * Get the value of targetDate
     *
     * @return the value of targetDate
     */
    public LocalDate getTargetDate() {
        return targetDate;
    }

    /**
     * Set the value of targetDate
     *
     * @param targetDate new value of targetDate
     */
    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
    
    /*public void setTargetDate(String dateStr) throws DateTimeParseException{
        this.targetDate = LocalDate.parse(dateStr);
    }*/

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the value of priority
     *
     * @return the value of priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Set the value of priority
     *
     * @param priority new value of priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * toString() method for Task
     * 
     * @return id, title, priority, targetDate as String
     */
    @Override
    public String toString() {
        return id + "," + title + "," + priority + "," + targetDate.toString();
    }
    /**
     * Adding subTask method
     * 
     * @param subTask new value of subTask
     * 
     * @return the value of subTask that added as a Boolean
     */
    public boolean addSubTask(SubTask subTask){
        return subTasks.add(subTask);
    }
    /**
     * Removing subTask method
     * 
     * @param title new value of title
     */
    public void removeSubTask(String title){
        Iterator<SubTask> iter = this.subTasks.iterator();
        while(iter.hasNext()){
            SubTask st = iter.next();
            if (st.getTitle().equals(title)){
                iter.remove();
            }
        }
    }
}
