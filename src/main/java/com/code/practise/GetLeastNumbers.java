package com.code.practise;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @author Summer 2021/07/14 12:40
 */
public class GetLeastNumbers {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers(new int[]{0,0,0,2,0,5},2)));
    }

    public int[] getLeastNumbers(int[] arr, int k) {

        if(k == 0){
            return new int[]{};
        }

        find(arr,0,arr.length - 1, k);

        int[] ans = new int[k];

        for(int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }

        return ans;

    }

    private int find(int[] a, int left, int right, int k){

        if(left < right){

            int index = getV(a,left,right,k);

            if(index == k - 1){
                return index;
            }else if(index > k - 1){
                return find(a,left,index,k);
            }else{
                return find(a,index + 1, right, k);
            }

        }

        return  -1;
    }

    private int getV(int[] a, int left, int right, int k){

        int l = left;
        int r = right;

        int tmp = a[left];

        while(l < r){
            while(tmp <= a[r] && l < r){
                r--;
            }
            a[l] = a[r];

            while(tmp > a[l] && l < r){
                l++;
            }
            a[r] = a[l];
        }

        a[l] = tmp;

        return l;
    }

}


