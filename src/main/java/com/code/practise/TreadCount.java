package com.code.practise;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程找出数组最大值
 *
 * @author Summer 2020/06/04 16:04
 */
public class TreadCount {



    public static void main(String[] args) {

        int a[] = new int[10000];

        Random random = new Random();

        int result[] = new int[10];

        for(int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(3000);
        }

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10,new Thread(){
            @Override
            public void run(){
                int max = 0;
                for(int i = 0; i < result.length; i++) {
                    System.out.println(result[i]);
                    max = Math.max(max,result[i]);
                }
                System.out.println(max);
            }
        });

        ExecutorService executors = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 10; i++) {

            Task task = new Task(a,i,result,cyclicBarrier);

            executors.execute(task);

        }

    }

}
