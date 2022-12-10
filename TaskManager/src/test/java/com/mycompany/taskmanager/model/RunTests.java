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
public class RunTests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        //Testing P2R1
        System.out.println("Task manger is empty: "+TestP2.testCreateTaskManagerIsEmpty());
        System.out.println("Users are created: "+TestP2.testCreateUsers());
        System.out.println("Tasks are created: "+TestP2.testCreateTasks());
        System.out.println("Users are added to the task manager: "+TestP2.testAddedUsersToTaskManager());
        System.out.println("Tasks are added to the task manager: "+TestP2.testAddedTasksToTaskManager());
        //Testing P2R2
        System.out.println("User is removed: "+TestP2.testRemoveUser());
        System.out.println("Task is removed: "+TestP2.testRemoveTask());
        //Testing P2R3
        System.out.println("User has no task: "+TestP2.testUserHasNoTask());
        System.out.println("User has a task: "+TestP2.testAddingTaskToUser());
        //Testing P2R4
        System.out.println("User name has been edited: "+TestP2.testEditUser());
        System.out.println("Task priority has been edited: "+TestP2.testEditTask());
        //Testing P2R5
        System.out.println("SubTask added to task: "+TestP2.testSubTaskAddedToPreExistingTask());
        //Testing P2R6
        System.out.println("Users read from csv file: "+TestP2.testUsersLoadedFromCsvFile());
        System.out.println("Csv file contains all the expected users: "+TestP2.testUsersLoadedFromCsvFileAndContainsAllUsers());
        System.out.println("Tasks read from csv file: "+TestP2.testTaskLoadedFromCsvFile());
        System.out.println("Csv file contains all the expected tasks: "+TestP2.testTasksLoadedFromCsvFileAndContainsAllUsers());
        System.out.println("Sub Tasks read from csv file: "+TestP2.testSubTaskLoadedFromCsvFile());
       //Testing P2R7
        System.out.println("Write to User csv file successful: "+TestP2.testWriteUsersToCsvFile());
        System.out.println("Write to Task csv file successful: "+TestP2.testWriteTasksToCsvFile());
        System.out.println("Write to SubTask csv file successful: "+TestP2.testWriteSubTasksToCsvFile());
    }    
}
