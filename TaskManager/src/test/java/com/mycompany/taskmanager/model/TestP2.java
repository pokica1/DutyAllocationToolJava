/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taskmanager.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author orsol
 */
public class TestP2 {
    
    
    public static boolean testCreateTaskManagerIsEmpty(){
        /*P2R1*/
        TaskManager taskManager = new TaskManager();
        System.out.println("testing P2R1");
        int numberOfTasks = taskManager.getTasks().size();
        int numberOfUsers = taskManager.getUsers().size();
        return numberOfTasks == 0 && numberOfUsers == 0;
    }
    
    public static boolean testCreateUsers(){
        /*P2R1*/
        User testUser1 = new User("1,Marge Simpson");
        User testUser2 = new User("2,Jamie Oliver");
        return (testUser1.toString().equals("1,Marge Simpson"))&&(testUser2.toString().equals("2,Jamie Oliver"));
    }
    
    public static boolean testCreateTasks(){
        /*P2R1*/
        Task testTask1 = new Task("1,Organise a party,1,2020-12-01");
        Task testTask2 = new Task("2,Cook dinner,2,2020-12-02");
        return (testTask1.toString().equals("1,Organise a party,1,2020-12-01"))&&(testTask2.toString().equals("2,Cook dinner,2,2020-12-02"));
    }
    
    public static boolean testAddedUsersToTaskManager(){
        TaskManager taskManager = new TaskManager();
        User testUser1 = new User("1,Marge Simpson");
        User testUser2 = new User("2,Jamie Oliver");
         taskManager.addUser(testUser1);
         taskManager.addUser(testUser2);
         return ((taskManager.getUsers().size() == 2)&&(taskManager.getUsers().contains(testUser1))&&(taskManager.getUsers().contains(testUser2)));
    }
    
    public static boolean testAddedTasksToTaskManager(){
        TaskManager taskManager = new TaskManager();
        Task testTask1 = new Task("1,Organise a party,1,2020-12-01");
        Task testTask2 = new Task("2,Cook dinner,2,2020-12-02");
         taskManager.addTask(testTask1);
         taskManager.addTask(testTask2);
         return ((taskManager.getTasks().size() == 2)&&(taskManager.getTasks().contains(testTask1))&&(taskManager.getTasks().contains(testTask2)));
    }
    
    public static boolean testRemoveTask(){
        TaskManager taskManager = new TaskManager();
        Task testTask1 = new Task("1,Organise a party,1,2020-12-01");
        Task testTask2 = new Task("2,Cook dinner,2,2020-12-02");
        taskManager.addTask(testTask1);
        taskManager.addTask(testTask2);
        taskManager.removeTask(taskManager.getTask("1"));
        return ((taskManager.getTasks().size() == 1)&&(!taskManager.getTasks().contains(testTask1)));
    }
    public static boolean testRemoveUser(){
        TaskManager taskManager = new TaskManager();
        User testUser1 = new User("1,Marge Simpson");
        User testUser2 = new User("2,Jamie Oliver");
         taskManager.addUser(testUser1);
         taskManager.addUser(testUser2);
         taskManager.removeUser(taskManager.getUser("1"));
        return ((taskManager.getUsers().size() == 1)&&(!taskManager.getUsers().contains(testUser1)));
    }
    
    public static boolean testUserHasNoTask(){
        TaskManager taskManager = new TaskManager();
        User testUser1 = new User("1,Marge Simpson");
        User testUser2 = new User("2,Jamie Oliver");
         taskManager.addUser(testUser1);
         taskManager.addUser(testUser2);
         return (taskManager.getUser("2").getTasks().isEmpty());
    }
    
    public static boolean testAddingTaskToUser(){
        TaskManager taskManager = new TaskManager();
        User testUser1 = new User("1,Marge Simpson");
        User testUser2 = new User("2,Jamie Oliver");
        taskManager.addUser(testUser1);
        taskManager.addUser(testUser2);
        Task testTask1 = new Task("1,Organise a party,1,2020-12-01");
        Task testTask2 = new Task("2,Cook dinner,2,2020-12-02");
        taskManager.addTask(testTask1);
        taskManager.addTask(testTask2);

         taskManager.getUser("2").addTask(taskManager.getTask("2"));
         return ((taskManager.getUser("2").getTasks().size() == 1)&&(taskManager.getUser("2").getTasks().contains(testTask2)));
    }
    
    public static boolean testEditUser(){
        TaskManager taskManager = new TaskManager();
        User testUser1 = new User("1,Marge Simpson");
        User testUser2 = new User("2,Jamie Oliver");
        taskManager.addUser(testUser1);
        taskManager.addUser(testUser2);
        String propertyToEdit = "name";
        User userToEdit = taskManager.getUser("2");
        String valueToEdit = taskManager.getUserValue(userToEdit, propertyToEdit);
        String changedValue = "Jamie Oliver the cook";
        taskManager.setUserValue(userToEdit, propertyToEdit, changedValue);
        return ((userToEdit.getName().equals(changedValue))&&(valueToEdit.equals("Jamie Oliver")));
    }
    
    public static boolean testEditTask(){
        TaskManager taskManager = new TaskManager();
        Task testTask1 = new Task("1,Organise a party,1,2020-12-01");
        Task testTask2 = new Task("2,Cook dinner,2,2020-12-02");
         taskManager.addTask(testTask1);
         taskManager.addTask(testTask2);
        String propertyToEdit = "priority";
        Task taskToEdit = taskManager.getTask("2");
        String intToEdit = taskManager.getTaskValue(taskToEdit, propertyToEdit);
        String changedInt = "1";
        taskManager.setTaskValue(taskToEdit, propertyToEdit, changedInt);
        return ((taskToEdit.getPriority() == 1)&&(intToEdit.equals("2")));
    }
    
    public static boolean testSubTaskAddedToPreExistingTask(){
        TaskManager taskManager = new TaskManager();
        User testUser1 = new User("1,Marge Simpson");
        User testUser2 = new User("2,Jamie Oliver");
        taskManager.addUser(testUser1);
        taskManager.addUser(testUser2);
        Task testTask1 = new Task("1,Organise a party,1,2020-12-01");
        Task testTask2 = new Task("2,Cook dinner,2,2020-12-02");
        taskManager.addTask(testTask1);
        taskManager.addTask(testTask2);
        taskManager.getUser("2").addTask(taskManager.getTask("2"));
        SubTask testSubTask1 = new SubTask("1,Buy Ingredients,false");
        Task targetTask = taskManager.getTask("2");
        boolean added = targetTask.addSubTask(testSubTask1);
        return ((targetTask.getSubTasks().contains(testSubTask1))&&(targetTask.getSubTasks().size() == 1));
    }
    
    public static boolean testUsersLoadedFromCsvFile(){
        String filename = "userList.csv";
        TaskManager fileTestTM = new TaskManager();
        fileTestTM.readUsersFromCsvFile(filename);
        return fileTestTM.getUsers().size() == 4;
    }
    
    public static boolean testUsersLoadedFromCsvFileAndContainsAllUsers(){
        String filename = "userList.csv";
        TaskManager fileTestTM = new TaskManager();
        fileTestTM.readUsersFromCsvFile(filename);
        return ((fileTestTM.getUsers().get(0).toString().equals("1,Marge Simpson"))&&(fileTestTM.getUsers().get(1).toString().equals("2,Jamie Oliver"))&&(fileTestTM.getUsers().get(2).toString().equals("3,Bart Simpson"))&&(fileTestTM.getUsers().get(3).toString().equals("4,Mary Poppins")));
    }
    
    public static boolean testTaskLoadedFromCsvFile(){
        String filename = "taskList.csv";
        TaskManager fileTestTM = new TaskManager();
        fileTestTM.readTasksFromCsvFile(filename);
        return fileTestTM.getTasks().size() == 4;
    }
    
     public static boolean testTasksLoadedFromCsvFileAndContainsAllUsers(){
        String filename = "taskList.csv";
        TaskManager fileTestTM = new TaskManager();
        fileTestTM.readTasksFromCsvFile(filename);
        return ((fileTestTM.getTasks().get(3).toString().equals("4,Fly a kite,4,2020-12-02"))&&(fileTestTM.getTasks().get(0).toString().equals("1,Cook dinner,1,2020-11-11"))&&(fileTestTM.getTasks().get(1).toString().equals("2,Bake a cake,2,2020-11-21"))&&(fileTestTM.getTasks().get(2).toString().equals("3,Draw a picture,3,2020-12-01")));
    }
     
    public static boolean testSubTaskLoadedFromCsvFile(){
        String filename = "subTasksList.csv";
        TaskManager fileTestTM = new TaskManager();
        Task testTask1 = new Task("4,Organise a party,1,2020-12-01");
        fileTestTM.addTask(testTask1);
        fileTestTM.readSubTasksFromCsvFile(filename);
        System.out.println(testTask1.getSubTasks().size());
        return testTask1.getSubTasks().size()== 6;
    }
     
     public static boolean testWriteUsersToCsvFile(){
        boolean presentInCSV = false;
        TaskManager fileTestTM = new TaskManager();
        User testUser1 = new User("2,Jamie Oliver");
        fileTestTM.addUser(testUser1);
        String filename = "UserWriteTest1.csv";
        
        fileTestTM.writeUsersToCsvFile(filename);
        
         try (BufferedReader in = new BufferedReader(new FileReader(filename))){
            while(in.ready()){
                String csvLine = in.readLine();
                if(csvLine.contains("2,Jamie Oliver")){  
                    presentInCSV=true;
                }
            }
            in.close();
        }catch(IOException e){
            e.printStackTrace();
        }  
         return presentInCSV;
     }
     public static boolean testWriteTasksToCsvFile(){
        boolean presentInCSV = false;
        TaskManager fileTestTM = new TaskManager();
        Task testTask1 = new Task("2,Cook dinner,2,2020-12-02");
        fileTestTM.addTask(testTask1);
        String filename = "TaskWriteTest1.csv";
        
        fileTestTM.writeTasksToCsvFile(filename);
        
         try (BufferedReader in = new BufferedReader(new FileReader(filename))){
            while(in.ready()){
                String csvLine = in.readLine();
                if(csvLine.contains("2,Cook dinner,2,2020-12-02")){  
                    presentInCSV=true;
                }
            }
            in.close();
        }catch(IOException e){
            e.printStackTrace();
        }  
         return presentInCSV;
     }
     
     public static boolean testWriteSubTasksToCsvFile(){
        boolean presentInCSV = false;
        TaskManager fileTestTM = new TaskManager();
        Task testTask1 = new Task("2,Cook dinner,2,2020-12-02");
        fileTestTM.addTask(testTask1);
        SubTask testSubTask1 = new SubTask("1,a,true");
        testTask1.addSubTask(testSubTask1);
        String filename = "SubTaskWriteTest1.csv";
        
        fileTestTM.writeSubTasksToCsvFile(filename);
        
         try (BufferedReader in = new BufferedReader(new FileReader(filename))){
            while(in.ready()){
                String csvLine = in.readLine();
                if(csvLine.contains("1,a,true")){  
                    presentInCSV=true;
                }
            }
            in.close();
        }catch(IOException e){
            e.printStackTrace();
        }  
         return presentInCSV;
     }
}
