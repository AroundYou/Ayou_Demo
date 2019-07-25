package com.example.thread.sleepwait;

/**
 * @ClassName Thread2
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/11 14:13
 * @Version 1.0
 **/
public class Thread2 implements Runnable{
    @Override
    public void run(){
        synchronized (TestD.class) {
            System.out.println("enter thread2....");
            System.out.println("thread2 is sleep....");
            try {
                //在调用sleep()方法的过程中，线程不会释放对象锁。
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread2 is going on....");
            System.out.println("thread2 is over!!!");
            //如果我们把代码：TestD.class.notify();给注释掉，即TestD.class调用了wait()方法，但是没有调用notify()
            //方法，则线程永远处于挂起状态。
            TestD.class.notify();
        }
    }
}
