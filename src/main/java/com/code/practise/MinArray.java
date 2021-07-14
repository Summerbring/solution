package com.code.practise;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2021/07/08 8:55
 */
public class MinArray {

    public static void main(String[] args) {
        System.out.println(new MinArray().minArray2(new int[]{1,1,1}));
    }


    public int minArray(int[] numbers) {

        Deque<Integer> deque = new LinkedList<>();

        if(numbers.length == 0 ){
            return 0;
        }

        for(int i = 0; i < numbers.length ; i++){

            if(!deque.isEmpty() && deque.peekLast() > numbers[i]){
                return numbers[i];
            }

            deque.offerLast(numbers[i]);
        }

        return deque.peekFirst();
    }

    /**
     *  二分法
     *
     * @param numbers
     * @author Summer 2021-07-08 9:01
     * @return int
     */
    public int minArray2(int[] numbers) {


        int low = 0;
        int high = numbers.length;

        while (low < high){
            int pivt = (low + (high - low)) / 2;

            if(numbers[pivt] > numbers[low]){
                low = pivt;
            }else if(numbers[pivt] < numbers[low]){
                high = pivt;
            }else {
                high--;
            }

        }

        return numbers[low];
    }

}
