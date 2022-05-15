import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/* Create a menu driven application "TaskManager" to manage your day-to-day tasks. 
You can create a class Task with fields like taskId, taskName, description, taskDate, status, active. 

taskId should be unique and generated automatically. 

status should be either PENDING, IN PROGRESS or COMPLETED. 

active should be either true or false. Deleted task will have active=false 
Newly added task should have default status as PENDING and active=true 
You can use suitable data structure to store data in memory. 


Following functionalities are expected -
a. Add New Task 
b. Delete a task 
c. Update task status 
d. Display all pending tasks 
e. Display all pending tasks for today 
f. Display all tasks sorted by taskDate  

* Basic structure of program 
* Java Coding conventions */

public class TaskManagerDriver {
    public static void main(String[] args) {
        System.out.println("Main");

        List<Task> tasks = new ArrayList<Task>();

        // Add tasks
        tasks.add(new Task("Play Guitar"));
        tasks.add(new Task("Go for walk"));
        tasks.add(new Task("Write notes"));
        tasks.add(new Task(123, "Dummy Task"));
        System.out.println(tasks);

        // Delete a task by id
        int id = 123;
        for (Task task : tasks) {
            if (task.getTaskId() == id) {
                task.setActive(false);
            }
        }
        System.out.println(tasks);

        // Update task status
        TaskStatus status = TaskStatus.COMPLETED;
        id = 123;
        for (Task task : tasks) {
            if (task.getTaskId() == id) {
                task.setStatus(status);
            }
        }
        System.out.println(tasks);

        // Display all Pending tasks
        for (Task task : tasks) {
            if (task.getStatus() == TaskStatus.PENDING) {
                System.out.println(task);
            }
        }

        // Display all pending tasks for today
        LocalDateTime tempDate = LocalDateTime.now();
        for (Task task : tasks) {
            LocalDateTime taskDate = task.getTaskDate();
            if (taskDate.getDayOfYear() == tempDate.getDayOfYear() && taskDate.getYear() == tempDate.getYear()
                    && task.getStatus() == TaskStatus.PENDING) {
                System.out.println(task);
            }
        }
    }
}
