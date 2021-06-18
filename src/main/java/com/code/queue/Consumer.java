package com.code.queue;

/**
 * description
 *
 * @author Summer 2021/04/21 13:25
 */
public class Consumer {

    private SummerBlockingQueue<Message> queue;

    private boolean status;

    private String name;

    Consumer(SummerBlockingQueue queue){
        this.queue = queue;
    }

    int count = 0;

    public void take(){

        Message s = queue.take();
        System.out.println(s.getMsg().toString());
        count++;
        System.out.println("cusomer" + this.name + " count:" + count);

    }


    public void setName(String name) {
        this.name = name;
    }
}
