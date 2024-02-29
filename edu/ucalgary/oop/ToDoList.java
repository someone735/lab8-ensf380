package edu.ucalgary.oop;

import java.util.*;

public class ToDoList implements IToDoList{
    private List<Task> tasks;
    private Stack<List<Task>> history;

    public ToDoList(){
        this.tasks = new ArrayList<Task>();
        this.history = new Stack<List<Task>>();
    }

    public void saveToHistory(){
        List<Task> event = new ArrayList<Task>();

        
    }
    @Override
    public List<Task> listTasks() {
        return this.tasks;
    }

    @Override
    public void undo() {
        if (!history.isEmpty()) {
            tasks = history.pop();
        }
    }
     @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void completeTask(String taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setCompleted(true);
                break;
            }
        }
    }

    @Override
    public void deleteTask(String id) {

        saveToHistory();

        Iterator<Task> iterator = tasks.iterator();
        if (iterator.hasNext()) {
            Task task = iterator.next();

            if (task.getId().equals(id)) {
                iterator.remove();
                break;
            }

        }
    }

}
