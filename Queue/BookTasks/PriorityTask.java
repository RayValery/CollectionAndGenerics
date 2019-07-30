package Queue.BookTasks;

public class PriorityTask implements Comparable<PriorityTask> {
    public enum Priority { HIGH, MEDIUM, LOW }

    private final Task task;
    private final Priority priority;

    public PriorityTask(Task task, Priority priority){
        this.task = task;
        this.priority = priority;
    }

    public Task getTask() {return task;}
    public Priority getPriority() {return priority;}

    @Override
    public int compareTo(PriorityTask pt) {
        int c = this.priority.compareTo(pt.priority);
        return c != 0 ? c : this.task.compareTo(pt.task);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PriorityTask) {
            if ((this.priority.toString().equals(((PriorityTask) obj).priority.toString()))&&
                    (this.task.toString().equals(((PriorityTask) obj).task.toString()))){
                return true;}
        } return false;
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    @Override
    public String toString() {
        return task + ": " + priority;
    }

}

