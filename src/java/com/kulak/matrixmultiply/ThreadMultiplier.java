package com.kulak.matrixmultiply;

public class ThreadMultiplier extends Thread {
    private int a[], b[], c[], i, n, j = 0;

    ThreadMultiplier(int[] a, int[] b, int[] c, int i, int n) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.i = i;
        this.n = n;
    }

    @Override
    public void run() {
        while (j != n) {
            c[i * n + j] += a[i * n + j] * b[i + n * j];
            j++;
        }
    }
}
