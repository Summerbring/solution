package com.code.thread;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * description
 *
 * @author Summer 2021/03/23 19:15
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public ConnectionPool(int init){
        if(init > 0){
            for(int i = 0; i < init; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if(connection != null){
            synchronized (pool){
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            if(mills < 0 ){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                long futrue = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (remaining > 0 && pool.isEmpty()){
                    pool.wait(remaining);
                    remaining = futrue - System.currentTimeMillis();
                }
                Connection result = null;

                if(!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }

        }
    }

}
