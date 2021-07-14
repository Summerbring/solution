package com.code.practise;

import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 注：机器人移动的格子，必须是可达
 *
 * @author Summer 2020/04/08 14:39
 */
public class MovingCount {

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(16,8,4));

//        System.out.println(new MovingCount().getValue(1));
    }

    public int movingCount(int m, int n, int k) {

        boolean[][] vis = new boolean[m][n];

        Queue<int[]> q = new LinkedBlockingQueue();

        q.offer(new int[]{0,0});

        int result = 0;

        while(!q.isEmpty()){

            int[] current = q.poll();

            int x = current[0];
            int y = current[1];

            if(x + 1 > m || y + 1 > n || vis[x][y] || getValue(x) + getValue(y) > k){
                continue;
            }

            System.out.println("x = " + x);
            System.out.println("y = " + y);
            System.out.println("x ++ y = " + (getValue(x) + getValue(y)));


            result++;


            vis[x][y] = true;

            if(x + 1 < m ){
                q.offer(new int[]{x + 1,y});
            }
            if(y + 1 < n ){
                q.offer(new int[]{x,y + 1});
            }

        }

        return result;

    }

    private int getValue(int x){

        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;

    }



}
