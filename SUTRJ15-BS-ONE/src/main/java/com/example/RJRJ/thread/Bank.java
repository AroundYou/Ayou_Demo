package com.example.RJRJ.thread;

import java.sql.SQLOutput;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Bank
 * @Deseiption
 * @Author AYOU
 * @Date 2019/4/13 19:39
 * @Version 1.0
 **/
public class Bank {
    
    private Lock lock = new ReentrantLock();
    
    private Condition suff;
    
    TestInterface test = new Test();
//    TestInterface.c();
    Bank(){
        suff = lock.newCondition();
        test.a();
    }

    public static void main(String[] args) {
        int i  = TestInterface.c();
        System.out.println(i);
        Bank bank = new Bank();
    }
    
}
