package com.code.queue;

/**
 * description
 *
 * @author Summer 2021/04/21 13:24
 */
public class Producer {

    private SummerBlockingQueue<Message> queue;

    Producer(SummerBlockingQueue queue){
        this.queue = queue;
    }

    public void publish(String msg){

        Message m = new Message();
        m.setMsg(msg);
        queue.put(m);
//        System.out.println("publish:"+msg);

    }

}
