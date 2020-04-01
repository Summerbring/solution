package com.code.practise;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2020/04/01 10:19
 */
public class IsValid {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else {

                char a = stack.empty() ? '?' : stack.pop();

                if(s.charAt(i) == ')' && '(' != a){
                    return false;
                }
                if(s.charAt(i) == '}' && '{' != a){
                    return false;
                }
                if(s.charAt(i) == ']' && '[' != a){
                    return false;
                }
            }

            if(stack.size() > s.length() /2){
                return false;
            }

        }

        return stack.empty();

    }

}
