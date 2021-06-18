package com.code.practise;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2021/06/16 14:33
 */
public class NumWays {

    public static void main(String[] args) {
        System.out.println(new NumWays().numWays(7));
    }

    /**
     * 假设青蛙位于n，那么青蛙只有可能从n-1或者n-2处而来，f(n) = f(n-1) + f(n-2) | n >= 2
     *  斐波那契数列
     * @param n
     * @author Summer 2021-06-16 14:51
     * @return int
     */
    public int numWays(int n) {

        if(n == 0 || n == 1){
            return 1;
        }
        //此方法会超时
//        return numWays(n-1) + numWays( n - 2);

        int s0 = 1;
        int s1 = 1;

        int result = 1;

        for(int i = 2; i <= n; i++) {
            s1 = s0;
            s0 = result;

            result = (s1 + s0) % 1000000007;

        }

        return result;
    }

}
