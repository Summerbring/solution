package com.code.practise;

import java.util.Arrays;

/**
 * 快排
 *
 * @author Summer 2021/06/18 14:09
 */
public class QuickSort {


    public static void main(String[] args) {
        new QuickSort().sort(new int[]{0,0,0,0,0});

    }


    public void sort(int[] a){

        quickSort(a,0,a.length-1);

        System.out.println(Arrays.toString(a));

    }

    private void quickSort(int[] a ,int low, int high){

        if(low < high){

            int index = getIndex(a,low,high);

            quickSort(a,low,index);
            quickSort(a,index+1,high);

        }

    }

    private int getIndex(int[] a ,int low, int high){

        int tmp = a[low];

        while(low < high){

            while (low < high && a[high] >= tmp){
                high--;
            }

            a[low] = a[high];

            while(low < high && a[low] < tmp){
                low++;
            }

            a[high] = a[low];

        }

        a[low] = tmp;

        return low;

    }

}
