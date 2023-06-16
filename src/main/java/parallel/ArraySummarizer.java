package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArraySummarizer {

    private final int threadsCount;
    private final ExecutorService executorService;

    public ArraySummarizer(int threadsCount) {
        this.threadsCount = threadsCount;
        executorService = Executors.newFixedThreadPool(threadsCount);
    }

    public int summarize(int[] array) {
        System.out.printf("Summarizing array with size %d, with thread count %d\n", array.length, threadsCount);
        int chunk = array.length / threadsCount;
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            int low = chunk * i;
            int high = low + chunk;
            futures.add(CompletableFuture.supplyAsync(() -> sumChunk(low, high, array), executorService));
        }
        int sum = 0;
        for (var future : futures) {
            try {
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return sum;
    }

    private int sumChunk(int low, int high, int[] array) {
        int sum = 0;
        for (int i = low; i < high && i < array.length; i++) sum += array[i];
        return sum;
    }

}
