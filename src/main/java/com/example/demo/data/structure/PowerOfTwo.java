package com.example.demo.data.structure;

/**
 * @author blindskipper
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo0(2));
        System.out.println(isPowerOfTwo1(2));
    }

    private static boolean isPowerOfTwo0(int num) {
        if (num < 0)
            return false;
        while (num % 2 == 0) {
            num /= 2;
        }
        return num == 1;
    }

    private static boolean isPowerOfTwo1(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((num >>> i) & 1) == 1) {
                count++;
            }
        }
        return num > 0 && count == 1;
    }
}
