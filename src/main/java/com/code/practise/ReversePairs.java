package com.code.practise;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2021/06/22 14:18
 */
public class ReversePairs {

    public static void main(String[] args) {
        System.out.println(new ReversePairs().reversePairs(new int[]{7,5,6,4}));
    }

    public int reversePairs(int[] nums) {
        //超时
//        int n = nums.length;
//
//        if(n < 2){
//            return 0;
//        }
//
//        int[] dp = new int[n];
//
//        dp[0] = 0;
//
//        for(int i = 1; i < n; i++) {
//            int sum = 0;
//
//            for(int j = 0; j < i; j++) {
//                if(nums[j] > nums[i]){
//                    sum++;
//                }
//            }
//
//            dp[i] = dp[i-1] + sum;
//        }


        int[] tmp = new int[nums.length];

        return reversePairs(nums,tmp,0,nums.length - 1);

    }

    private int reversePairs(int[] nums , int[] tmp , int left , int right){

        if(right <= left){
            return 0;
        }

        int mid = (right + left) / 2;
        int leftCount = reversePairs(nums,tmp,left,mid);
        int rightCount = reversePairs(nums,tmp,mid + 1,right);

        return merge(nums,tmp,right,mid,left) + rightCount + leftCount;
    }

    private int merge(int[] nums , int[] tmp , int right , int mid , int left){

        int i = left;
        int j = mid + 1;

        int count = 0;

        int x = 0;

        while( i <= mid && j <= right){

            if(nums[i] <= nums[j]){

                tmp[x++] = nums[i];
                count += j - mid - 1;
                i++;

            }else{
                tmp[x++] = nums[j];
                j++;
            }

        }

        while(i <= mid){
            tmp[x++] = nums[i++];
            count++;
        }

        while(j <= right){
            tmp[x++] = nums[j++];
        }

        x = 0;

        while(left <= right){
            nums[left++] = tmp[x++];
        }

        return count;
    }

}
