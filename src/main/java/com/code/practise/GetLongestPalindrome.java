package com.code.practise;

/**
 * 最长回文子串
 *
 * @author Summer 2021/07/12 8:44
 */
public class GetLongestPalindrome {

    public static void main(String[] args) {

        System.out.println(new GetLongestPalindrome().getLongestPalindrome("abbaaccbbcc",11));

    }

    public int getLongestPalindrome(String A, int n) {
        // write code here
        int ans = 0;

        boolean[][] dp  = new boolean[n][n];

        for(int i = 0 ; i < n ; i++){
            dp[i][i] = true;
        }

        for(int l = 2 ; l <= n ; l++){
            for(int i = 0; i <= n - l ; i++){

                int j = i + l - 1;

                if(A.charAt(i) != A.charAt(j)){
                    dp[i][j] = false;
                }else {

                    if(j - i < 2){
                        dp[i][j] = A.charAt(i) == A.charAt(j);
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if(dp[i][j]){
                        ans = Math.max(ans,l);
                    }
                }

            }
        }

        return ans;
    }

}
