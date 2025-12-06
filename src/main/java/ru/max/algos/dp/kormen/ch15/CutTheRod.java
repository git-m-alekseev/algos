package ru.max.algos.dp.kormen.ch15;

import java.security.SecureRandom;

public class CutTheRod {

    public static SecureRandom RAND = new SecureRandom();

    public static int[] randomArray(int len) {
        var start = System.nanoTime();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = RAND.nextInt(21);
        }
        var end = System.nanoTime();
        System.out.println("Generated random array of length " + len + " in " + (end - start) / 1_000+ " mcs");
        System.out.println("----------------");
        return res;
    }

    public static void main(String[] args) {

        for (int i = 10; i <= 50; i += 2) {
            var start = System.nanoTime();
            final int[] p = randomArray(i);
            var max1 = Solutions.usingTabulation(p, i);
            var max2 = Solutions.usingMemoization(p, i);
            if (max1 != max2) {
                throw new RuntimeException("max1 != max2: %s, %s".formatted(max1, max2));
            }
            var end = System.nanoTime();
            System.out.println("Computed max for length " + i + " in " + (end - start) / 1_000_000 + " ms");
            System.out.println("Max for length " + i + " is " + max1);
            System.out.println("----------------");
        }
    }
}
