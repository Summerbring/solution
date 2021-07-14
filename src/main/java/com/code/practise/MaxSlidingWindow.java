package com.code.practise;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2021/06/22 13:03
 */
public class MaxSlidingWindow {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},2)));
    }

    /**
     * 窗口为一点点推进，把下一个推进的值与当前窗口最大值比较，得到下一个窗口的最大值
     *
     * @param nums
     * @param k
     * @author Summer 2021-06-22 13:04
     * @return int[]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0 ){
            return nums;
        }

        int[] r = new int[nums.length + 1 - k];

        LinkedBlockingDeque<Integer> d = new LinkedBlockingDeque<>();

        int x = 0;

        for(int i = 0; i < k; i++) {
            while (!d.isEmpty() && d.peekLast() < nums[i]){
                d.pollLast();
            }
            d.offerLast(nums[i]);
        }

        r[x++] = d.peekFirst();

        for(int i = k; i < nums.length; i++) {

            while (!d.isEmpty() && d.peekLast() < nums[i]){

                d.pollLast();

            }

            d.offerLast(nums[i]);

            if(d.peekFirst() == nums[x-1]){
                d.pollFirst();
            }

            r[x++] = d.peekFirst();

        }

//        r[x] = d.peekFirst();

        return r;

    }

}
