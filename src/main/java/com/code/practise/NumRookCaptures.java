package com.code.practise;

/**
 * description
 *
 * @author Summer 2020/03/27 14:39
 */
public class NumRookCaptures {

    /**
     *
     * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
     *
     * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
     *
     * 返回车能够在一次移动中捕获到的卒的数量。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/available-captures-for-rook
     *
     *  思路：定位每一个车，查看该卒能否被捕获
     *
     * @param board
     * @author Summer 2020-03-26 9:39
     * @return
     */
    public int numRookCaptures(char[][] board) {

        int sum = 0;

        for(int i = 0; i < board.length; i++) {
            for( int k = 0; k < board[i].length; k++) {

                if(board[i][k] == 'R'){

                    //捕获条件
                    //存在卒
                    //与车之间无任何棋子


                    //查找卒，遇到象直接退出循环

                    int flagP = 0;
                    int flagR = 0;

                    //列
                    for(int m = 0; m < board.length; m++) {

                        if(board[m][k] == 'B' && flagP == 1  && flagR == 0){
                            sum--;
                            flagP = 0;
                        }else if(board[m][k] == 'B'  && flagR == 1) {
                            break;
                        }

                        if(board[m][k] == 'p' && flagP == 0){
                            sum++;
                            flagP = 1;
                        }

                        if (board[m][k] == 'R'){
                            flagP = 0;
                            flagR = 1;
                        }
                    }

                    flagP = 0;
                    flagR = 0;

                    //行
                    for(int n = 0; n < board.length; n++) {

                        if(board[i][n] == 'B' && flagP == 1 && flagR == 0){
                            sum--;
                            flagP = 0;
                        }else if(board[i][n] == 'B'  && flagR == 1){
                            break;
                        }

                        if(board[i][n] == 'p' && flagP == 0){
                            sum++;
                            flagP = 1;
                        }

                        if(board[i][n] == 'R'){
                            flagP = 0;
                            flagR = 1;
                        }
                    }

                    break;

                }

            }
        }

        return sum;
    }

}
