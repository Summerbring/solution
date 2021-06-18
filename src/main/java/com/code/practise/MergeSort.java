package com.code.practise;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author Summer 2021/06/18 13:08
 */
public class MergeSort {

    public static void main(String[] args) {
        new MergeSort().sort(new int [] {8,5,9,1,7,6});
    }

    public void sort( int[] a){

        int[] tmp = new int[a.length];

        sort(a,tmp,0,a.length-1);

        System.out.println(Arrays.toString(tmp));

    }

    private void sort(int[] a,int[] tmp, int left, int right){

        if(left < right){
            int mid = (left + right) / 2;

            sort(a,tmp,left,mid);
            sort(a,tmp,mid+1,right);

            merge(a,tmp,mid,left,right);
        }

    }

    private void merge(int[] a, int[] tmp ,int mid , int left ,int right){

        int i = left;
        int j = mid + 1;
        int n = right;
        int x = 0;

        while (i <= mid && j <= n){

            if(a[i] < a[j]){
                tmp[x++] = a[i++];
            }else {
                tmp[x++] = a[j++];
            }
        }

        while(i <= mid){
            tmp[x++] = a[i++];
        }

        while(j <= n){
            tmp[x++] = a[j++];
        }

        x = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            a[left++] = tmp[x++];
        }

    }


}
