//package com.code.practise;
//
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * 科学计算器
// *
// * 思路：
// *
// * 中缀转后缀
// *
// *
// * 遍历栈
// *
// * @author Summer 2021/05/27 14:20
// */
//public class Calculate {
//
//    public double calculate(String s){
//
//        LinkedList<String> list = new LinkedList<>();
//
//        List<String> numbers = new LinkedList<>();
//
//        StringBuffer temp = new StringBuffer();
//
//        for(int i = 0; i < s.length(); i++) {
//
//
//
//            if("-+*/()".contains(String.valueOf(s.charAt(i)))){
//                numbers.add((temp.toString()));
//                temp = new StringBuffer();
//                //栈为空或者为( 直接入栈
//                if(list.isEmpty() || s.charAt(i) == '('){
//                    list.addFirst(String.valueOf(s.charAt(i)));
//                }
//
//                if((s.charAt(i) == '*' || s.charAt(i) == '/') && (list.getFirst().equals("-") || list.getFirst().equals("*"))){
//                    numbers.
//                }
//
//                if(s.charAt(i) == '*' || s.charAt(i) == '/'){
//
//                }
//
//                if()
//
//
//
//            }else{
//                temp.append(s.charAt(i));
//            }
//
//        }
//
//        return 0;
//
//    }
//
//}
