package com.mycompany.taskmanager.main;


import com.mycompany.taskmanager.controller.EventController;
import com.mycompany.taskmanager.model.TaskManager;
import com.mycompany.taskmanager.view.DataViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author orsol
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaskManager taskManagerModel = new TaskManager();
        DataViewer dataView = new DataViewer();
        EventController controller = new EventController(taskManagerModel,dataView);
    }
    
}
