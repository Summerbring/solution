package com.code.practise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description
 *
 * @author Summer 2021/04/19 14:40
 */
public class SumCountByThread {

    ReentrantLock reentrantLock = new ReentrantLock();
//
//    Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) throws InterruptedException {

//        for (int i = 0; i < 20; i++) {
//
//            int number = i;
//            Thread thread  = new Thread(){
//                @Override
//                public void run() {
//                    System.out.println(number);
//
//                }
//            };
//
//            thread.start();
//            thread.join();
//        }
        new SumCountByThread().order();

    }

    public void order() throws InterruptedException {



        for (int i = 0; i < 100; i++) {

            MyTask task = new MyTask(i);
            new Thread(() -> {
                task.task();
            }).start();

        }

//        condition.signal();
        
    }
    
    class MyTask{

        private ReentrantLock reentrantLock = new ReentrantLock();
        private int i;

        MyTask(int i){
            this.i = i;
        }

        public void task() {

            reentrantLock.lock();

            try{

                System.out.println(i);

            }catch (Exception e){

            }finally {
                reentrantLock.unlock();
            }


        }
    }




}
