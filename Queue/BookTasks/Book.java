package Queue.BookTasks;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class Book {

    public abstract class Task implements Comparable<Task> {
        protected Task() {}
        public boolean equals(Object o) {
            if (o instanceof Task) {
                return toString().equals(o.toString());
            } else return false;
        }
        public int compareTo(Task t) {
            return toString().compareTo(t.toString());
        }
        public int hashCode() {
            return toString().hashCode();
        }
        public abstract String toString();
    }

    public final class CodingTask extends Task {
        private final String spec;
        public CodingTask(String spec) {
            this.spec = spec;
        }
        public String getSpec() { return spec; }
        public String toString() { return "code " + spec; }
    }


    public final class PhoneTask extends Task {
        private final String name;
        private final String number;
        public PhoneTask(String name, String number) {
            this.name = name;
            this.number = number;
        }
        public String getName() { return name; }
        public String getNumber() { return number; }
        public String toString() { return "phone " + name; }
    }

    public class EmptyTask extends Task {
        public EmptyTask() {}
        public String toString() { return ""; }
    }




    public enum Priority { HIGH, MEDIUM, LOW }
    public final class PriorityTask implements Comparable<PriorityTask> {
        private final Task task;
        private final Priority priority;
        PriorityTask(Task task, Priority priority) {
            this.task = task;
            this.priority = priority;
        }
        public Task getTask() { return task; }
        public Priority getPriority() { return priority; }
        public int compareTo(PriorityTask pt) {
            int c = priority.compareTo(pt.priority);
            return c != 0 ? c : task.compareTo(pt.task);
        }
        public boolean equals(Object o) {
            if (o instanceof PriorityTask) {
                PriorityTask pt = (PriorityTask)o;
                return task.equals(pt.task) && priority.equals(pt.priority);
            } else return false;
        }
        public int hashCode() { return task.hashCode(); }
        public String toString() { return task + ": " + priority; }
    }


    public class StoppableTaskQueue {
        private final int MAXIMUM_PENDING_OFFERS = Integer.MAX_VALUE;
        private final BlockingQueue<PriorityTask> taskQueue =
                new PriorityBlockingQueue<PriorityTask>();
        private boolean isStopped = false;
        private Semaphore semaphore = new Semaphore(MAXIMUM_PENDING_OFFERS);
        // return true if the task was successfully placed on the queue, false
        // if the queue has been shut down.
        public boolean addTask(PriorityTask task) {
            synchronized (this) {
                if (isStopped) return false;
                if (! semaphore.tryAcquire()) throw new Error("too many threads");
            }
            try {
                return taskQueue.offer(task);
            } finally {
                semaphore.release();
            }
        }
        // return the head task from the queue, or null if no task is available
        public PriorityTask getTask() {
            return taskQueue.poll();
        }
        // stop the queue, wait for producers to finish, then return the contents
        public Collection<PriorityTask> shutDown() {
            synchronized(this) { isStopped = true; }
            semaphore.acquireUninterruptibly(MAXIMUM_PENDING_OFFERS);
            Set<PriorityTask> returnCollection = new HashSet<PriorityTask>();
            taskQueue.drainTo(returnCollection);
            return returnCollection;
        }
    }


    public class TaskScheduler {
        private List<StoppableTaskQueue> schedule;
        private final int FORWARD_PLANNING_DAYS = 365;
        public TaskScheduler() {
            List<StoppableTaskQueue> temp = new ArrayList<StoppableTaskQueue>();
            for (int i = 0 ; i < FORWARD_PLANNING_DAYS ; i++) {
                temp.add(new StoppableTaskQueue());
            }
            schedule = new CopyOnWriteArrayList<StoppableTaskQueue>(temp); //1
        }
        public PriorityTask getTask() {
            for (StoppableTaskQueue daysTaskQueue : schedule) {
                PriorityTask topTask = daysTaskQueue.getTask();
                if (topTask != null) return topTask;
            }
            return null; // no outstanding tasks - at all!?
        }
        // at midnight, remove and shut down the queue for day 0, assign its tasks
        // to the new day 0, and create a new day's queue at the planning horizon
        public void rollOver() throws InterruptedException{
            StoppableTaskQueue oldDay = schedule.remove(0);
            Collection<PriorityTask> remainingTasks = oldDay.shutDown();
            StoppableTaskQueue firstDay = schedule.get(0);
            for (PriorityTask t : remainingTasks) {
                firstDay.addTask(t);
            }
            StoppableTaskQueue lastDay = new StoppableTaskQueue();
            schedule.add(lastDay);
        }
        public void addTask(PriorityTask task, int day) {
            if (day < 0 || day >= FORWARD_PLANNING_DAYS)
                throw new IllegalArgumentException("day out of range");
            StoppableTaskQueue daysTaskQueue = schedule.get(day);
            if (daysTaskQueue.addTask(task)) return; //2
                                        // StoppableTaskQueue.addTask returns false only when called on
                                        // a queue that has been shut down. In that case, it will also
                                        // have been removed by now, so it's safe to try again.
            if (! schedule.get(0).addTask(task)) {
                throw new IllegalStateException("failed to add task " + task);

            }
        }
    }
}

