package yandex;

import java.io.*;

public class Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int size = 2 * n + 1;
        int[][] matrix = new int[size][size];
        int pos = 1;
        int neg = -1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) matrix[i][j] = 0;
                else if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
                    matrix[i][j] = pos++;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j && ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0))) {
                    matrix[j][i] = neg--;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                writer.write(String.format("%d ", matrix[i][j]));
            }
            writer.write('\n');
        }
        reader.close();
        writer.close();
    }
}
