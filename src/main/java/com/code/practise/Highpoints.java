package com.code.practise;

/**
 *
 * 1906. 寻找比周围都大的点
 *
 * 给一个n*m大小的矩阵，寻找矩阵中所有比邻居（上下左右，对角也算，不考虑边界就是8个咯）都严格大的点。
 * 返回一个n*m大小的矩阵，如果原矩阵中的点比邻居都严格大，则该位置为1，反之为0。
 *
 * 样例
 * 样例 1
 *
 * 输入:
 * 1 2 3
 * 4 5 8
 * 9 7 0
 * 输出:
 * 0 0 0
 * 0 0 1
 * 1 0 0
 * 注意事项
 *  1≤n,m≤100
 *
 * @author Summer 2020/10/28 9:45
 */
public class Highpoints {

    /**
     * @param grid: a matrix
     * @return: Find all points that are strictly larger than their neighbors
     */
    public int[][] highpoints(int[][] grid) {
        // write your code here

        int n = grid.length;
        int m = grid[0].length;

        int [][] result = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int k = 0; k < m; k++) {

                if(i - 1 >= 0 && k - 1 >= 0 && grid[i][k] < grid[i-1][k-1]){
                    result[i][k] = 0;
                    continue;
                }
                if(i - 1 >= 0 && grid[i][k] < grid[i-1][k]){
                    result[i][k] = 0;
                    continue;
                }
                if( i - 1 >= 0 && k + 1 < m && grid[i][k] < grid[i-1][k+1]){
                    result[i][k] = 0;
                    continue;
                }
                if(  k - 1 >= 0 && grid[i][k] < grid[i][k-1]){
                    result[i][k] = 0;
                    continue;
                }
                if(  k + 1 < m && grid[i][k] < grid[i][k+1]){
                    result[i][k] = 0;
                    continue;
                }
                if( i + 1 < n && k - 1 >=0 && grid[i][k] < grid[i+1][k-1]){
                    result[i][k] = 0;
                    continue;
                }
                if( i + 1 < n  && grid[i][k] < grid[i+1][k]){
                    result[i][k] = 0;
                    continue;
                }
                if( i + 1 < n && k + 1 < m  && grid[i][k] < grid[i+1][k+1]){
                    result[i][k] = 0;
                    continue;
                }

                result[i][k] = 1;
                if(k + 1 < m ){

                    result[i][k+1] = 0;
                    result[i][k+1] = 0;

                }
            }
        }
        return result;
    }

}
