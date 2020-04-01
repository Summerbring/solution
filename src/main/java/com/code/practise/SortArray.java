package com.code.practise;

/**
 * 给你一个整数数组 nums，将该数组升序排列。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 2 -50000 <= nums[i] <= 50000
 *
 * @author Summer 2020/03/31 9:43
 */
public class SortArray {

    /**
     * 解法一，冒泡
     *
     * @param nums
     * @return
     * @author Summer 2020-03-31 9:44
     */
    public int[] sortArray1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                if (nums[i] > nums[j]) {

                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;

                }

            }
        }

        return nums;
    }

    /**
     * 解法二，借助一个新的数组
     * <p>
     * 限制：当数组中有复数是不可用
     *
     * @param nums
     * @return
     * @author Summer 2020-03-31 9:44
     */
    public int[] sortArray2(int[] nums) {

        int[] tmp = new int[10000];

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]]++;
        }

        int j = 0;

        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != 0) {
                for (int m = 0; m < tmp[i]; m++) {
                    result[j++] = i;
                }
            }
        }

        return result;
    }

    /**
     * 解法三：快排
     *
     * @param nums
     * @return
     * @author Summer 2020-03-31 14:00
     */
    public void quickSort(int[] nums,int low,int high) {

        int left = low;
        int right = high;

        if (left >= right){
            return ;
        }

        int tmp = nums[left];

        while (left < right) {

            while(left < right && tmp <= nums[right]){
                right--;
            }
            if(left < right){
                nums[left] = nums[right];
            }
            while (left < right && tmp > nums[left]){
                left++;
            }
            if(left < right){
                nums[right] = nums[left];
            }

        }

        nums[left] = tmp;

        quickSort(nums,low,left-1);
        quickSort(nums,left+1,high);

    }

//    public int[] quickSort(int a[], int left, int right) {
//
//        int i = left;
//        int j = right;
//
//        int temp = a[left];
//
//        if (left >= right){
//            return a;
//        }
//
//        while (i != j) {
//
//            while (i < j && a[j] >= temp){
//                j--;
//            }
//
//            if (j > i){
//                //a[i]已经赋值给temp,所以直接将a[j]赋值给a[i],赋值完之后a[j],有空位
//                a[i] = a[j];
//
//            }
//
//            while (i < j && a[i] <= temp){
//                i++;
//            }
//
//            if (i < j){
//                a[j] = a[i];
//            }
//
//        }
//
//        //把基准插入,此时i与j已经相等R[low..pivotpos-1].keys≤R[pivotpos].key≤R[pivotpos+1..high].keys
//        a[i] = temp;
//
//        /*递归左边*/
//        quickSort(a, left, i - 1);
//        /*递归右边*/
//        quickSort(a, i + 1, right);
//
//        return a;
//    }


}
