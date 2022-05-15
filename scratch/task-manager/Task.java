import java.time.LocalDateTime;
import java.util.Random;

public class Task {

    private static Random random = new Random();
    private static int lowerBound = 1;
    private static int upperBound = Integer.MAX_VALUE;

    private int taskId;
    private String taskName;
    private String description;
    private LocalDateTime taskDate;
    private TaskStatus status;
    private boolean active;

    public Task(String taskName) {
        this.taskId = random.nextInt(upperBound - lowerBound) + lowerBound;
        this.taskDate = LocalDateTime.now();
        this.taskName = taskName;
        this.status = TaskStatus.PENDING;
        this.active = true;
    }

    public Task(int id, String taskName) {
        this(taskName);
        this.taskId = id;
    }

    public Task(String taskName, String description) {

        this.taskId = random.nextInt(upperBound - lowerBound) + lowerBound;
        this.taskName = taskName;
        this.description = description;
        this.taskDate = LocalDateTime.now();
        this.status = TaskStatus.PENDING;
        this.active = true;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDateTime taskDate) {
        this.taskDate = taskDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        sb.append(this.taskId + " ");
        sb.append(this.taskName + " ");
        sb.append(this.description + " ");
        sb.append(this.active + " ");
        sb.append(this.status + " ");
        return sb.toString();
    }

}
