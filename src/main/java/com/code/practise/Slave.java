package com.code.practise;

import java.util.*;

/**
 * 表达式求值
 *
 * 描述
 * 请写一个整数计算器，支持加减乘三种运算和括号。
 * 示例1
 * 输入：
 * "1+2"
 * 复制
 * 返回值：
 * 3
 * 复制
 * 示例2
 * 输入：
 * "(2*(3-4))*5"
 * 复制
 * 返回值：
 * -10
 * 复制
 * 示例3
 * 输入：
 * "3+2*3*4-1"
 * 复制
 * 返回值：
 * 26
 *
 * @author Summer 2021/07/12 9:56
 */
public class Slave {

    Deque<Character> deque = new LinkedList<>();
    Deque<Integer> numbers = new LinkedList<>();


    public static void main(String[] args) {
        System.out.println(new Slave().solve("2+1-2-3"));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve (String s) {
        // write code here

        Map<Character,Integer> map = new HashMap();

        map.put('*',2);
        map.put(')',2);
        map.put('(',0);
        map.put('+',1);
        map.put('-',1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            if(map.containsKey(s.charAt(i))){

                if(sb.length() > 0){

                    numbers.add(Integer.valueOf(sb.toString()));

                    sb.delete(0,sb.length());
                }

                if(s.charAt(i) == ')'){

                    while(!deque.peekLast().equals('(')){
                        doSlave(deque.pollLast());
                    }

                    deque.pollLast();

                    continue;
                }

                if(deque.isEmpty() || map.get(deque.peekLast()) == 1){
                    deque.add(s.charAt(i));
                    continue;
                }

                if(!deque.isEmpty() && map.get(deque.peekLast()) > map.get(s.charAt(i)) && map.get(s.charAt(i)) != 0 ){

                    while(deque.peekLast().equals('*')){
                        doSlave(deque.pollLast());
                    }

                }

                deque.add(s.charAt(i));

            }else{
                sb.append(s.charAt(i));
            }
        }

        if(sb.length() > 0){
            numbers.add(Integer.valueOf(sb.toString()));

            sb.delete(0,sb.length() - 1);
        }

        while(!deque.isEmpty()){
            doSlave(deque.pollLast());
        }

        return  numbers.peekLast();
    }

    private void doSlave(char c){

        int ans = 0;

        switch (c){
            case '*' : ans = numbers.pollLast() * numbers.pollLast();
                break;
            case '-' :

                if(!deque.isEmpty() && deque.peekLast() == '-'){
                    ans = numbers.pollLast() + numbers.pollLast();
                }else{
                    int x = numbers.pollLast();
                    ans = numbers.pollLast() - x;
                }

                break;
            case '+' : ans = numbers.pollLast() + numbers.pollLast();
                break;
        }

        numbers.add(ans);
    }

}
