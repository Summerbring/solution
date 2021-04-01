package com.code.practise;

import java.util.*;

/**
 * description
 *
 * @author Summer 2021/03/19 15:44
 */
public class FindSum {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList();

        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);


        FindSum findSum = new FindSum();
        System.out.println(findSum.check(list,4));
    }

    public Boolean check(List<Integer> list ,  Integer a){

        Set set = new HashSet();

        for(int i = 0; i < list.size(); i++) {
            if(set.contains(a-list.get(i))){
                return true;
            }
            set.add(list.get(i));
        }
        
        return false;
    }
}
