package com.code.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * fifo 阻塞队列
 *
 * @author Summer 2021/04/21 10:16
 */
public class SummerBlockingQueue<T> {

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition notEmpty = lock.newCondition();

    private final Condition notFull = lock.newCondition();

    private int size;

    private volatile int ctl;

    private Node<T> head;

    private Node<T> tail;

    private class Node<T> {

        T item;

        Node<T> next;

        Node(T item){
            this.item = item;
        }

    }

    SummerBlockingQueue(){
        this(Integer.MAX_VALUE);
    }

    SummerBlockingQueue(int size){
        this.size = size;
        ctl = 0;
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.next = head;
    }

    /**
     * 元素插入队列尾部，若达最大长度，则阻塞
     *
     * @param v
     * @author Summer 2021-04-21 13:17
     * @return
     */
    public void put(T v){

        lock.lock();
        try {

            if(ctl >= size){
                notFull.await();
            }

            Node<T> node = new Node<>(v);
            Node<T> tmp = tail.next;
            tmp.next = node;
            tail.next = node;
            ctl++;
            notEmpty.signal();
            System.out.println("put e:" + node.item);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    /**
     * 从队列头取出元素，若队列为空，则阻塞
     *
     * @param
     * @author Summer 2021-04-21 13:20
     * @return
     */
    public T take(){

        lock.lock();

        try{
            if(ctl == 0){
                notEmpty.await();
            }
            if(ctl < 0){
                throw new RuntimeException();
            }
            Node<T> node = head.next;
            Node<T> tmp = node.next == null ? tail : node.next;
            head.next = tmp;
            System.out.println("take e :" + node.item);
            T v = node.item;
            node = null;
            ctl--;
            if(ctl == 0){
                tail.next = head;
            }
            notFull.signal();

            return v;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        return null;

    }

}
