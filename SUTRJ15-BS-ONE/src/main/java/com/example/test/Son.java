package com.example.test;

/**
 * @ClassName Son
 * @Deseiption
 * @Author AYOU
 * @Date 2019/6/28 19:15
 * @Version 1.0
 **/
public class Son extends Father{
    public Son(){
        /*super();*/
        System.out.println("son");
    }
    public Son(int a){
        super(a);
        System.out.println("son: "+a);
    }
    {
        System.out.println("son 构造块");
    }
    static {
        System.out.println("son static块");
    }
    @Override
    public void test() {
        Father.a++;
        System.out.println("son：test");
    }
}
