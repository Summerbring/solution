package com.code.practise;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2021/07/02 15:05
 */
public class CheckContain {

    public static void main(String[] args) {
//        System.out.println(new CheckContain().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
        System.out.println(new CheckContain().exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}},"AAB"));

    }

    /**
     *  深度优先搜索
     *  从第一个匹配的字符开始匹配
     *
     * @param board
     * @param word
     * @author Summer 2021-07-02 15:07
     * @return boolean
     */
    public boolean exist(char[][] board, String word) {

        if(board.length == 0 || word.length() == 0){
            return true;
        }

        char[] words = word.toCharArray();

        int m = board.length;
        int n = board[0].length;


        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {

                if(board[i][k] == word.charAt(0)){
                    if(dfs(board, words, i, k, 0)) return true;
                }

            }
        }

        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

}
