package com.kulak.matrixmultiply;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixMultiply {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(1900) + 100;
        int upperBound = random.nextInt(899) + 1;
        int downBound = random.nextInt(99) + 1;
        int A[] = new int[n * n];
        int B[] = new int[n * n];
        int C[] = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            A[i] = random.nextInt(upperBound) + downBound;
            B[i] = random.nextInt(upperBound) + downBound;
        }

        List<ThreadMultiplier> threads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            threads.add(new ThreadMultiplier(A, B, C, i, n));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i * n + j] + " ");
            }
            System.out.println("\n");
        }
    }
}
