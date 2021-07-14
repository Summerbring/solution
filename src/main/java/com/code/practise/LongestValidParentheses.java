package com.code.practise;

import java.util.Deque;
import java.util.LinkedList;

/**
 * NC49 最长的括号子串
 *  算法知识视频讲解
 * 较难  通过率：24.81%  时间限制：1秒  空间限制：64M
 * 知识点
 * 字符串
 * 动态规划
 * 题目
 * 描述
 * 给出一个仅包含字符'('和')'的字符串，计算最长的格式正确的括号子串的长度。
 * 对于字符串"(()"来说，最长的格式正确的子串是"()"，长度为2.
 * 再举一个例子：对于字符串")()())",来说，最长的格式正确的子串是"()()"，长度为4.
 * 示例1
 * 输入：
 * "(()"
 * 复制
 * 返回值：
 * 2
 *
 * @author Summer 2021/07/14 16:00
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(())()"));
    }


    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public int longestValidParentheses (String s) {
        // write code here
        Deque<Integer> deque = new LinkedList<>();

        int max = 0;

        deque.offer(-1);

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '('){
                deque.offerLast(i);
            }else{

                deque.pollLast();

                if(deque.isEmpty()){
                    deque.offerLast(i);
                }else{
                    max = Math.max(max,i - deque.peekLast());
                }

            }

        }

        return max;
    }


}
