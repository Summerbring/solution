package com.code.practise;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * description
 *
 * @author Summer 2020/03/31 13:43
 */
@Service
public class Demo {

    private static String A = "A";

    private static String B = "B";

    public static void main(String[] args) {

//        Demo demo = new Demo();
//
//        demo.say();
//
//        DemoChild child = new DemoChild();
//        child.say();
//
//        Demo child2 = new DemoChild();
//
//        child2.say();
//
//        System.out.println(child2 instanceof Demo);
//
//        System.out.println(child2 instanceof DemoChild);
//
//        System.out.println(demo instanceof DemoChild);

//        Map map = new HashMap(8);
//
//        map.put("1","dou");
//
//        map.put("key","dou");
//
//        map.put("name1","dou");
//
//        map.put("name2","dou");
//
//        map.put("name3","dou");

//        Object o = new DiaoMao();
//        System.out.println(o);
//        Object n = o;
//        o = new DiaoMao();
//        System.out.println(n);
//
//        System.out.println(o);

//        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10000);
//
//        for(int i = 0; i < 10000; i++) {
//            blockingQueue.add(i);
//        }
//
//        for(int i = 0; i < 10000; i++) {
//            System.out.println(blockingQueue.poll());
//        }

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.add("d"));

    }

    public void say(){
        System.out.println(111);
    }

//    private void deadLock() {
//
//        Thread t1 = new Thread(){
//            @Override
//            public void run() {
//
//                synchronized (A){
//                    try {
//                        Thread.currentThread().sleep(2000);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                    synchronized (B){
//                        System.out.println("1");
//                    }
//                }
//
//            }
//        };
//
//        Thread t2 = new Thread(){
//            @Override
//            public void run() {
//
//                synchronized (B){
//
//                    synchronized (A){
//                        System.out.println("2");
//                    }
//                }
//
//            }
//        };
//
//        t1.start();
//        t2.start();
//
//    }


}
