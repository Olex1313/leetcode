package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelVectorComputation {

    public static void main(String[] args) {
        AtomicInteger sum = new AtomicInteger();
        int threadNum = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        List<Integer> vector = Stream.generate(() -> new Random().nextInt())
                .limit(360)
                .toList();
        int length = vector.size() / threadNum;
        List<CompletableFuture<Integer>> subParts = new ArrayList<>();
        for (int i = 0; i < threadNum; i++) {
            int low = length * i;
            int high = length + low;
            subParts.add(CompletableFuture.supplyAsync(() -> computeSum(vector, low, high), executorService)
                    .thenApply(sum::addAndGet));
        }
        subParts.forEach(CompletableFuture::join);

        System.out.println(vector.stream().mapToInt(Integer::intValue).sum());
        System.out.println(sum.get());
    }

    private static int computeSum(List<Integer> vector, int low, int high) {
        int sum = 0;
        for (int i = low; i < high; i++) {
            sum += vector.get(i);
        }
        return sum;
    }

}
