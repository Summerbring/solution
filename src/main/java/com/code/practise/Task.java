package com.code.practise;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 计算任务
 *
 * @author Summer 2020/06/04 16:38
 */
public class Task implements Runnable{

    private CyclicBarrier cyclicBarrier;

    int max = 0;

    int no;

    int [] result;

    int array[];

    public Task(int[] array, int no, int[] result, CyclicBarrier cyclicBarrier){
        this.array = array;
        this.cyclicBarrier = cyclicBarrier;
        this.no = no;
        this.result = result;
    }

    @Override
    public void run() {
        try {
            for(int i = no; i < array.length; i += 10) {
                max = Math.max(max,array[i]);
            }
            result[no] = max;
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}