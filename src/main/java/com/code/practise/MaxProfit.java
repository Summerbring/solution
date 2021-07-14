package com.code.practise;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2021/06/21 15:00
 */
public class MaxProfit {


    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7,6,4,3,1}));
    }

    /**
     * 题意为找到最大相差正值
     *  最简单为双层for，找到每个相差的值，得到最大的值 dp
     *
     * @param prices
     * @author Summer 2021-06-21 15:01
     * @return int
     */
    public int maxProfit(int[] prices) {

        if(prices.length <= 1){
            return 0;
        }

        int r = 0;

        for(int i = 0; i < prices.length - 1; i++) {
            for(int j = i + 1; j < prices.length; j++) {

                r = Math.max(r,prices[j] - prices[i]);

            }
        }

        return r;
    }

    public int maxProfit2(int[] prices) {

        if(prices.length <= 1){
            return 0;
        }

        int r = 0;

        int min = prices[0];

        for(int i = 1; i < prices.length; i++) {

            min = Math.min(min,prices[i]);
            r = Math.max(r,prices[i] - min);

        }

        return r;
    }

}
