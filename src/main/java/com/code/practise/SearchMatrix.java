package com.code.practise;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 *
 * @author Summer 2020/10/20 9:38
 */
public class SearchMatrix {

    /**
     *  二分查找，首先元素数组的每个头元素都是有序的，划分半区元素数组，再在元素中二分
     *
     * @param matrix
     * @param target
     * @author Summer 2020-10-20 9:41
     * @return boolean
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        if(matrix[0][0] > target){
            return false;
        }

        int m = getM(matrix,target,0,matrix.length - 1);

        int n = getN(matrix,target,0,m);

        int tmp = m;

        m = Math.max(m,n);
        n = Math.min(tmp,n);

        for(int i = n; i <= m; i++) {
            if(find(matrix[i],target,0,matrix[i].length-1)){
                return true;
            }
        }

        return false;
    }

    private int getM(int[][] matrix, int target,int a, int b){

        if(matrix[b][0] <= target){
            return b;
        }

        if(matrix[a][0] <= target && matrix[a+1][0] > target){
            return a;
        }

        int x = (a + b + 1) / 2;

        if(matrix[x][0] <= target){
            return getM(matrix,target,x,b);
        } else{
            return getM(matrix,target,a,x);
        }

    }

    private int getN(int[][] matrix, int target,int a, int b){

        if(a == b){
            return a;
        }

        if(matrix[a][matrix[0].length-1] >= target){
            return a;
        }

        if(matrix[a][matrix[0].length-1] <= target && matrix[a+1][matrix[0].length-1] > target){
            return a + 1;
        }

        int x = (a + b + 1) / 2;

        if(matrix[x][matrix[0].length-1] <= target){
            return getN(matrix,target,x,b);
        } else{
            return getN(matrix,target,a,x);
        }

    }

    public boolean find (int[] a, int target, int begin, int end){

        if(end == begin){
            return a[begin] == target;
        }

        if( end - begin == 1 ){
            return a[begin] == target || a[end] == target;
        }

        int x = (begin + end + 1) / 2;

        if(a[x] == target){
            return true;
        }

        if(a[x] < target){
            return find(a,target,x,end);
        }else{
            return find(a,target,begin,x);
        }


    }

    /**
     *  官方牛逼的解决方案
     *      左下方或右上方开始搜索
     *
     * @param matrix
     * @param target
     * @author VDI 2020-10-21 14:06
     * @return boolean
     */
    public boolean search(int[][] matrix, int target){

        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }


        int col = 0;
        int row = matrix[0].length -1;

        while (col < matrix[0].length && row > 0){

            if(matrix[col][row] > target){
                row--;
            }else if(matrix[col][row] > target){
                col++;
            }else if(matrix[col][row] == target){
                return true;
            }

        }

        return false;
    }


}
