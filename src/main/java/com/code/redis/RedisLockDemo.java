package com.code.redis;

import org.redisson.Redisson;

/**
 * description
 *
 * @author Summer 2021/07/07 13:24
 */
public class RedisLockDemo {

    public static void main(String[] args) {
//
//        Config config = new Config();
//        //config.useClusterServers().addNodeAddress("127.0.0.1:6379");
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//        return Redisson.create(config);

        System.out.println(new RedisLockDemo().getNum(20));

    }

    public int getNum(int n){
        if(n == 1){
            return 0;
        }
        return getNum(n-1) + 2*n;
    }

}
