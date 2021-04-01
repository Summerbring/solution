package com.code.thread;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description
 *
 * @author Summer 2021/03/23 19:14
 */
public class ConnectPoolTest {

    static ConnectionPool pool = new ConnectionPool(10);

    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);

        int count = 20;

        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for(int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectionRunnerThread");
            thread.start();
        }

        start.countDown();
        System.out.println(1111);
        end.await();
        System.out.println("got:"+got);
        System.out.println("notGot:"+notGot);
    }

    static class ConnectionRunner implements Runnable{

        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0){
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if(connection != null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }
                end.countDown();
            }
        }
    }

}
