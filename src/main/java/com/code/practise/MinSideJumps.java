package com.code.practise;

import java.util.Arrays;

/**
 * description
 *
 * @author Summer 2021/04/13 9:42
 */
public class MinSideJumps {

//    public int minSideJumps(int[] obstacles) {
//
//        int[] dp = new int [obstacles.length];
//
//        if(obstacles.length <= 2){
//            return 0;
//        }
//
//        dp[0] = dp[1] = 0;
//
//        for(int i = 0; i < obstacles.length; i++) {
//
//        }
//
//    }

    public static void main(String[] args) {
        System.out.println(tableSizeFor(34));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }


}
