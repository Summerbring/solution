package com.code.practise;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2021/07/05 16:22
 */
public class MedianFinder {

    Queue<Integer> litail;
    Queue<Integer> mall;

    /** initialize your data structure here. */
    public MedianFinder() {
        litail = new PriorityQueue<>((x,y) -> {return y-x;});
        mall = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(litail.size() != mall.size()){
            litail.add(num);
            mall.add(litail.poll());
        }else{
            mall.add(num);
            litail.add(mall.poll());
        }
    }

    public double findMedian() {
        return mall.size() == litail.size() ? (litail.poll() + mall.poll()) / 2 : mall.poll();
    }

}
