/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taskmanager.model;

/**
 *
 * @author orsol
 */
public class SubTask {
    
    private String title;

    private int sequence;
    
    private boolean completed;

    /**
     * default constructor of SubTask
     */
    public SubTask() {
    }
    /**
     * Constructor of SubTask with one parameter
     * 
     * @param csvLine new value of csvLine
     */
    public SubTask(String csvLine) {
        String attributes[] = csvLine.split(",");
        if (attributes.length == 3){
            this.sequence = Integer.parseInt(attributes[0]);
            this.title = attributes[1];
            this.completed = Boolean.parseBoolean(attributes[2]);
        }else{
            this.sequence = Integer.parseInt(attributes[0]);
            this.title = attributes[2];
            this.completed = Boolean.parseBoolean(attributes[3]);
        }
        
    }
    /**
     * Constructor of SubTask with three parameters
     * 
     * @param title new value of title
     * @param sequence new value of sequence
     * @param completed new value of completed
     */
    public SubTask(int sequence, String title, boolean completed) {
        this.sequence = sequence;
        this.title = title;
        this.completed = completed;
    }
    
    /**
     * Get the value of completed
     *
     * @return the value of completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Set the value of completed
     *
     * @param completed new value of completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    
    /**
     * Get the value of sequence
     *
     * @return the value of sequence
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * Set the value of sequence
     *
     * @param sequence new value of sequence
     */
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

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
     * toString() method for SubTask
     * 
     * @return sequence, title, completed
     */
    @Override
    public String toString() {
        return sequence + "," + title + "," + completed;
    }
    
    /**
     * toString() method for SubTask
     * 
     * @param taskId new value of taskId
     * @return sequence, taskId, title, completed
     */
    public String toString(String taskId) {
        return sequence + ","+ taskId + "," + title + "," + completed;
    }
}
