package com.code.practise;

import org.springframework.stereotype.Service;

import java.util.*;
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


//        Deque deque = new LinkedList();
//
//        for(int i = 0; i < 5; i++) {
//            deque.add(i);
//        }
//        while (!deque.isEmpty()){
//            System.out.println(deque.pollLast());
//        }

        System.out.println(Arrays.toString(new Demo().MySort(new int[]{5,4,3,2,1})));

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



    public int[] MySort (int[] arr) {
        // write code here

        mergeSort(arr,0,arr.length - 1,new int[arr.length]);

        return arr;

    }

    private void mergeSort(int[] arr, int left, int right, int[] tmp){

        if(left >= right){
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr,left,mid,tmp);
        mergeSort(arr,mid + 1,right,tmp);

        merge(arr,left,mid,right,tmp);

    }

    private void merge(int [] arr, int left, int mid, int right, int[] tmp){

        int l = left;
        int r = mid + 1;

        int index = 0;

        while(l <= mid && r <= right){

            if(arr[l] > arr[r]){
                tmp[index++] = arr[r++];
            }else{
                tmp[index++] = arr[l++];
            }

        }

        while(l <= mid){
            tmp[index++] = arr[l++];
        }

        while(r <= right){
            tmp[index++] = arr[r++];
        }
        int i = 0;
        while(left <= right){
            arr[left++] = tmp[i++];
        }

        List<Integer> list = new ArrayList<>();

        Integer[] a = new Integer[list.size()];

        a = list.toArray(a);

    }



}
