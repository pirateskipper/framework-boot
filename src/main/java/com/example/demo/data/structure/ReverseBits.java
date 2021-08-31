package com.example.demo.data.structure;

/**
 * @author blindskipper
 */
public class ReverseBits {

    public static void main(String[] args) {
        int num = 1;
        for (int i = 31; i >= 0  ; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();

        System.out.println(reverse0(num));
        System.out.println(reverse1(num));
        System.out.println(reverse2(num));
    }

    /**
     * original:1000010
     * reverse:0100001
     * @param num
     * @return
     */
    private static int reverse0(int num) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= num & 1;
            num >>= 1;
        }
        return result;
    }

    private static int reverse1(int num) {

        num = (num >>> 16) | (num << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);

        return num;
    }

    private static int reverse2(int num) {
        int result = 0;
        for (int i = 0; i < 16; i++) {
            result |= (num & (1 << i)) << (31 - i * 2);
        }
        for (int i = 16; i < 32; i++) {
            result |= (num & (1 << i)) << (i * 2 - 31);
        }
        return result;
    }
}
