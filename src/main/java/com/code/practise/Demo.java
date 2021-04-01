package com.code.practise;

import org.springframework.stereotype.Service;

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

        Demo demo = new Demo();

        demo.say();

        DemoChild child = new DemoChild();
        child.say();

        Demo child2 = new DemoChild();

        child2.say();

        System.out.println(child2 instanceof Demo);

        System.out.println(child2 instanceof DemoChild);

        System.out.println(demo instanceof DemoChild);

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
