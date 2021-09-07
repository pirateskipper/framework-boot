package com.example.demo.data.structure;

import org.springframework.util.Assert;

public class PrintBinaryInt {
    public static void main(String[] args) {
        print(5);
        print(2);
        print(3);

        print(-1);

        // &
        print(5 & 2);
        // |
        print(5 | 2);
        // ^
        print(5 ^ 3);

        print(5 & -1);

        print(1 << 4);
        print(Integer.MIN_VALUE);
        /**
         * 在计算机中，负数以其正值的补码形式表达
         * 5 原码：0000 0000 0000 0000 0000 0000 0000 0101
         *   反码：1111 1111 1111 1111 1111 1111 1111 1010
         *   补码：1111 1111 1111 1111 1111 1111 1111 1011
         */
        print(-5);
        print(~5);
        System.out.println(~5);

        print(5 >> 2);
        print(-5 >> 2);
        print(-5 >>> 2);
        print(-5 << 2);

        int[] arr = {1,3,5,2,4};
        final int[] selector = selectorMin(arr);
        for (int i = 0; i < selector.length; i++) {
            System.out.print(selector[i]);
        }
        System.out.println();

        final int[] selectorMax = selectorMax(arr);
        for (int i = 0; i < selectorMax.length; i++) {
            System.out.print(selectorMax[i]);
        }
        System.out.println();

        final int[] m = m(arr);
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i]);
        }
        System.out.println();
    }

    private static void print(int num) {
        for (int i = 31; i >= 0  ; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    /**
     *  计算N阶乘
     * @param n
     * @return
     */
    private static long print1(int n) {
        Assert.isTrue(n <= 0 ,"error");
        long cur = 1;
        long result = 0;
        for (int i = 1; i <= n ; i++) {
            cur = cur * n;
            result += cur;
        }
        return result;
    }

    /**
     * 选择排序
     * @param arr
     */
    private static int[] selectorMin(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int low = arr[i];
                    arr[i] = arr[j];
                    arr[j] = low;
                }
            }
        }
        return arr;
    }

    private static int[] selectorMax(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    int high = arr[j];
                    arr[j] = arr[i];
                    arr[i] = high;
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int high = arr[j];
        arr[j] = arr[i];
        arr[i] = high;
    }

    private static int[] m(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
