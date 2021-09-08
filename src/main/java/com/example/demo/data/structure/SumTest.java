package com.example.demo.data.structure;

import org.springframework.util.Assert;

public class SumTest {
    private static final int[] arr = {1,2,3,4,5,6,7};
    private static int[][] table = new int[arr.length][arr.length];

    public static void main(String[] args) {
        System.out.println(tables(arr));
    }

    private static int[][] tables(int[] arr){
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int temp = 0;
            for (int j = 0; j < length; j++) {
                if (j >= i) {
                    table[i][j] = temp + arr[j];
                    temp = table[i][j];
                }
            }
        }
        return table;
    }

    private static int sum(int l, int r){
        Assert.isTrue(l > r,"error");
        return table[l][r];
    }

}
