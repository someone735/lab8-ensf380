package edu.ucalgary.oop;

import java.util.List;

public class ToDoList {

    @Override
    public List<Task> listTasks() {
        return tasks;
    }

    @Override
    public void undo() {
        if (!history.isEmpty()) {
            tasks = history.pop();
        }
    }

    @Override
    public void deleteTask(String id) {

        saveState();

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
