package com.example.thread.sleepwait;

/**
 * @ClassName TestD
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/11 14:11
 * @Version 1.0
 **/
public class TestD {
    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }
}
