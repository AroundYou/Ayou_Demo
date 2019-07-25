package com.cn.ayou.producer.util.Design.Singleton;


import java.util.concurrent.locks.Lock;

/**
 * @ClassName LockSingleton
 * @Deseiption 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 * @Author AYOU
 * @Date 2019/7/21 12:53
 * @Version 1.0
 **/
public class LockSingleton {

    private static volatile LockSingleton instance;

    private LockSingleton(){}

    public static LockSingleton getInstance(){
        if(instance == null){
            synchronized (LockSingleton.class){
                if(instance == null){
                    instance = new LockSingleton();
                }
            }
        }
        return instance;
    }
}
