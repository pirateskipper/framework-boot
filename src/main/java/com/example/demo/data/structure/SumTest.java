package com.example.demo.data.structure;

import org.springframework.util.Assert;

public class SumTest {
    private static final int[] arr = {1,2,3,4,5,6,7};
    private static int[][] table = new int[arr.length][arr.length];
    private static int[] help = new int[arr.length];

    public static void main(String[] args) {
        System.out.println(tables(arr));
        System.out.println(tables1(arr));
    }

    /**
     * 二维数组求和
     * 无比大规模 优于 前缀和数组方式
     * @param arr
     * @return
     */
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

    /**
     * 前缀和数组求和(一般)
     * @param arr
     * @return
     */
    private static int[] tables1(int[] arr){
        int length = arr.length;
        int temp = 0 ;
        for (int i = 0; i < length; i++) {
            help[i] = temp + arr[i];
            temp = help[i];
        }
        return help;
    }


    private static int sum(int l, int r){
        Assert.isTrue(l > r,"error");
        return table[l][r];
    }

    private static int sum1(int l, int r){
        Assert.isTrue(l > r,"error");
        if (l == 0) {
            return help[r];
        }
        return help[r] - help[l - 1];
    }

}
