package com.code.practise;

import java.util.PriorityQueue;

/**
 * NC30 数组中未出现的最小正整数
 *
 * 中等  通过率：54.35%  时间限制：2秒  空间限制：256M
 * 知识点
 * 数组
 * 题目
 * 题解(17)
 * 讨论(99)
 * 排行
 * 描述
 * 给定一个无序数组arr，找到数组中未出现的最小正整数
 * 例如arr = [-1, 2, 3, 4]。返回1
 * arr = [1, 2, 3, 4]。返回5
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 *
 * 示例1
 * 输入：
 * [-1,2,3,4]
 * 复制
 * 返回值：
 * 1
 * 复制
 * 备注：
 * 1 \leq N \leq 10^61≤N≤10
 * 6
 *
 * |arr_i| \leq 10^9∣arr
 * i
 * ​
 *  ∣≤10
 * 9
 *
 * @author Summer 2021/07/14 10:06
 */
public class MinNumberdisappered {

    public static void main(String[] args) {
        System.out.println(new MinNumberdisappered().minNumberdisappered(new int[]{1,2,3,4}));
    }

    /**
     * 此方法空间复杂度不符合
     *  新方法： 将arr[i] < 0 = arr.length + 1
     *  将存在的值标为负数 如： arr[3] = 5,则 arr[4] = abs(arr[4]),说明5这个位置已经存在值
     *  int num = Math.abs(arr[i]);
     *  if(num < = arr.length)
     *  arr[arr[i] - 1] = -Math.abs(num - 1);
     *  遍历arr[i] > 0 return i+1
     * @param arr
     * @author Summer 2021-07-14 10:44
     * @return
     */
    public int minNumberdisappered (int[] arr) {
        // write code here
        PriorityQueue<Integer> q = new PriorityQueue();

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > 0){
                q.offer(arr[i]);
            }
        }

        int tmp = 0;

        while(!q.isEmpty()){
            int p = q.poll();
            if(tmp + 1 < p){
                return tmp + 1;
            }

            tmp++;
        }

        return ++tmp;
    }

}
