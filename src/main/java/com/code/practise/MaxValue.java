package com.code.practise;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2021/06/15 16:23
 */
public class MaxValue {

    public static void main(String[] args) {

        System.out.println(new MaxValue().maxValue(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
//                {1,2,5},
//                {3,2,1}
        }));

    }

    /**
     * 动态规划
     *
     *
     *
     * @param grid
     * @author Summer 2021-06-15 16:23
     * @return int
     */
    public int maxValue(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(i == 0 && j != 0){
                    grid[i][j] += grid[i][j-1];
                }
                if(j == 0 && i != 0){
                    grid[i][j] += grid[i-1][j];
                }

                if(i != 0 && j != 0){
                    grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
                }

            }
        }

        return grid[m-1][n-1];
    }

}
