package com.example.RJRJ.thread;

public interface TestInterface {
    void a();
    default int b(int i){
        return i & 1;
    }
    static int c(){
        return 1;
    }
}
