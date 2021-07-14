package com.code.practise;

/**
 * description
 *
 * @author Summer 2021/07/08 13:47
 */
public class BitMapSort {

    public static void main(String[] args) {
        new BitMapSort().sortByBit(new int[]{1,3,2,5,8,9,11},11);
    }

    byte[] bitmap;

    public void sortByBit(int[] a,int n){


        //int 32位
        bitmap = new byte[1 + n / 8];

        for(int i = 0; i < a.length; i++) {
            setBitmap(a[i]);
        }

        for(int i = 0; i <= n; i++) {
            if(test(i)){
                System.out.println(i);
            }
        }


    }

    public void setBitmap(int num){
        bitmap[num / 8 ] |= (1 << num % 8);
    }

    public void clear(int num){
        bitmap[num / 8 ] &= ( -1 << num % 8);
    }

    public boolean test(int num){
        return (bitmap[num / 8 ] & (1 << num % 8)) > 0;
    }

}
