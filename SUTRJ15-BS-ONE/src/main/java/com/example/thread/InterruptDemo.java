package com.example.thread;

/**
 * @ClassName InterruptDemo
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/10 17:55
 * @Version 1.0
 **/
public class InterruptDemo {

    private volatile static boolean isRunning = true;

    public static void main(String[] args) throws  Exception{
        new Thread(() -> {
            while (isRunning){
                System.out.println("TODO");
            }
        }, "unterrupTest").start();
        Thread.sleep(500);
        isRunning = false;
        System.out.println("end");

        /*Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("TODO");
            }
        }, "unterrupTest");
        t.start();
        Thread.sleep(500);
        t.interrupt();
        System.out.println("end");*/

    }
}
