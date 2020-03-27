package com.code.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * description
 *
 * @author Summer 2020/03/27 14:40
 */
public class LengthOfLongestSubstring {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @author Summer 2020-03-26 16:28
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        Set<Character> set = new HashSet<>();

        int i = 0 ,j = 0 , result = 0;


        while( j < n ){

            if(!set.contains(s.charAt(j))){

                set.add(s.charAt(j++));

                result = Math.max(result,set.size());

            }else{

                set.remove(s.charAt(i++));

            }

        }

        return result;

    }

}
