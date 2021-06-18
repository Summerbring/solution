package com.code.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description
 *
 * @author Summer 2021/04/12 14:48
 */
public class EntrySet {

    public static void main(String[] args) {

        LinkedHashMap linkedHashMap = new LinkedHashMap<String,String>();
        
        linkedHashMap.put("红丑","hongchou");
        linkedHashMap.put("红丑1","hongchou1");
        linkedHashMap.put("红丑2","hongchou2");
        linkedHashMap.put("红丑3","hongchou3");
        linkedHashMap.put("红丑4","hongchou4");
        linkedHashMap.put("红丑5","hongchou5");

        Iterator<Map.Entry<String,String>> it = linkedHashMap.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<String ,String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println("key:"+key);
            System.out.println("value:"+value);
        }

    }

}
