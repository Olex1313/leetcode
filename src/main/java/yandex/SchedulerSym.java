package yandex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class SchedulerSym {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmk = reader.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        Map<Integer, Scheduler> schedulers = new HashMap<>();
        Map<Integer, TaskQueue> queues = new HashMap<>();
        for (int i = 1; i <= m; i++) schedulers.put(i, new Scheduler(i));

        List<Task> tasks = new LinkedList<>();
        for (int j = 0; j < n; j++) {
            String[] sqi = reader.readLine().split(" ");
            int s = Integer.parseInt(sqi[0]);
            int q = Integer.parseInt(sqi[1]);
            int i = Integer.parseInt(sqi[2]);
            tasks.add(new Task(j, s, i, q));
        }

        var ref = new Object() {
            int currentTime = 1;
        };
        Set<Integer> finishedTaskIds = new HashSet<>();
        while (!queues.values().stream().allMatch(TaskQueue::isEmpty)) {
            List<Task> taskToQueue = new ArrayList<>();
            for (Task task : tasks) {
                if (task.queuedTime <= ref.currentTime && !finishedTaskIds.contains(task.id)) taskToQueue.add(task);
            }
            Optional<Scheduler> readyScheduler = schedulers.values().stream().filter(Scheduler::ready).sorted().findFirst();
            if (readyScheduler.isEmpty()) {
                ref.currentTime++;
                continue;
            }
            readyScheduler.ifPresent(s -> {
                Optional<TaskQueue> queue = queues.values().stream().filter(q -> !q.isEmpty()).sorted(Comparator.comparingInt(a -> a.lastTaken)).findFirst();
                queue.ifPresent(q -> {
                    Task t = q.queue.poll();
                    s.takeTask(t);
                    try {
                        writer.write(String.format("%d %d\n", s.id, ref.currentTime));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            });
            schedulers.values().forEach(s -> s.mineTask());
            ref.currentTime++;
        }

        reader.close();
        writer.close();
    }

    static class TaskQueue {
        Queue<Task> queue;
        int lastTaken;

        public TaskQueue(Queue<Task> queue) {
            this.queue = queue;
            this.lastTaken = 0;
        }

        void enqueue(Task task) {
            queue.add(task);
        }

        boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    static class Scheduler {
        Task currentTask;
        int id;

        public Scheduler(int id) {
            this.id = id;
        }

        void mineTask() {
            if (currentTask == null) return;
            if (currentTask.timeToComplete == 0) currentTask = null;
            currentTask.timeToComplete--;
        }

        void takeTask(Task task) {
            this.currentTask = task;
        }

        boolean ready() {
            return currentTask == null;
        }

    }

    static class Task {

        int id;
        int queuedTime;
        int timeToComplete;
        int scheduler;

        public Task(int id, int queuedTime, int timeToComplete, int scheduler) {
            this.queuedTime = queuedTime;
            this.timeToComplete = timeToComplete;
            this.scheduler = scheduler;
            this.id = id;
        }

    }

}
