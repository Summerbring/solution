package com.code.queue;

/**
 * description
 *
 * @author Summer 2021/04/21 13:48
 */
public class Client {

    public static void main(String[] args) {

        SummerBlockingQueue<Integer> queue = new SummerBlockingQueue<>(100);


        Thread producerA = new Thread(() -> {

            Producer p = new Producer(queue);

            for(int i = 0; i < 10000; i++) {
                p.publish("this is msg" + i);
            }

        });

        Thread producerB = new Thread(() -> {

            Producer p = new Producer(queue);

            for(int i = 100; i < 20000; i++) {
                p.publish("this is msg" + i);
            }

        });

        Thread producerC = new Thread(() -> {

            Producer p = new Producer(queue);

            for(int i = 100; i < 20000; i++) {
                p.publish("this is msg" + i);
            }

        });

        Thread consumerA = new Thread(() -> {

            Consumer consumer = new Consumer(queue);
            consumer.setName("A");
            while (true){
                consumer.take();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread consumerB = new Thread(() -> {

            Consumer consumer = new Consumer(queue);
            consumer.setName("B");
            while (true){
                consumer.take();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        producerA.start();
        producerB.start();
        producerC.start();

//        consumerB.start();
//        consumerA.start();

    }


}
