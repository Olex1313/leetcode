package parallel;

public class ThreadsSample {

    public static void main(String[] args) {
        int threadsCount = 5;
        String template = "I am %d thread from %d threads!";
        for (int i = 0; i < threadsCount; i++) {
            final int threadNum = i;
            var t = new Thread(() -> {
                if (threadNum == 0) {
                    System.out.printf("I am main thread from %d threads" + "%n", threadsCount);
                } else {
                    System.out.printf((template) + "%n", threadNum, threadsCount);
                }
            });
            t.start();
        }
    }

}
