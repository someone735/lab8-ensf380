package edu.ucalgary.oop;
import java.util.List;

public interface IToDoList {

    void addTask(Task task);


    void completeTask(String taskId);


    void deleteTask(String taskId);


    void editTask(String taskId, String newTitle, boolean newStatus);

    
    void undo();

    
    List<Task> listTasks();
}
