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
        for (Task task : this.tasks){
            event.add(new Task(task));
        }
        this.history.push(event);
    }

    @Override
    public List<Task> listTasks() {
        return this.tasks;
    }

    @Override
    public void undo() {
        if (!this.history.isEmpty()) {
            this.tasks = this.history.pop();
        }
    }
     @Override
    public void addTask(Task task) {
        saveToHistory();
        this.tasks.add(task);
    }

    @Override
    public void completeTask(String taskId) {
        saveToHistory();
        for (Task task : this.tasks) {
            if (task.getId().equals(taskId)) {
                task.setCompleted(true);
                break;
            }
        }
    }


    public void deleteTask(String id) {
        saveToHistory();
        Iterator<Task> iterator = tasks.iterator();
        if (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId().equals(id)) {
                iterator.remove();
            }    
        }
    }

    public void editTask(String taskId, String newTitle, boolean newStatus){
        saveToHistory();
        for (Task task: this.tasks){
            String checkId = task.getId();
            if (checkId == taskId){
                task.setTitle(newTitle);
                task.setCompleted(newStatus);
                break;
            }
        }
    }

}
