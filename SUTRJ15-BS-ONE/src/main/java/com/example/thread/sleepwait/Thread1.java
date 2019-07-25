package com.example.thread.sleepwait;

/**
 * @ClassName Thread1
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/11 14:10
 * @Version 1.0
 **/
public class Thread1 implements Runnable{
    @Override
    public void run() {
        synchronized (TestD.class){
            System.out.println("enter thread1..");
            System.out.println("thread1 is waiting.");
            try {
                TestD.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 is going on ....");
            System.out.println("thread1 is over!!!");
        }
    }
}
