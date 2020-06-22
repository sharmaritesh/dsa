package com.rites.sample.dsa.array;

public class Interview {

    public static void main(String[] args) {

        int n = -2147483648;
        long x = (long) n;
        System.out.println((x & (-x)) == x);

    }

    static Double log(int x, int base) {
        return Math.log(x) / Math.log(base);
    }
}
