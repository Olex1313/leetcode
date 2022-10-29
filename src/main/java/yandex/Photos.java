package yandex;

import java.io.*;
import java.util.Arrays;

public class Photos {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int newWidth = Integer.parseInt(reader.readLine());
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        long[] newHeights = new long[n];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("x");
            int height = Integer.parseInt(line[1]);
            int width = Integer.parseInt(line[0]);
            newHeights[i] = computeNewHeight(height, width, newWidth);
        }

        Arrays.sort(newHeights);

        long maxHeight = 0, minHeight = 0;

        for (int i = 0; i < k; i++) {
            minHeight += newHeights[i];
        }

        for (int i = n - 1; i >= n - k; i--) {
            maxHeight += newHeights[i];
        }

        writer.write(String.format("%d\n", minHeight));
        writer.write(Long.toString((maxHeight)));

        reader.close();
        writer.close();
    }

    private static long computeNewHeight(float height, float width, float newWidth) {
        return (long) Math.ceil(height * newWidth / width);
    }

}
