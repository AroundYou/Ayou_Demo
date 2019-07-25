package com.example.test;

/**
 * @ClassName Father
 * @Deseiption
 * @Author AYOU
 * @Date 2019/6/28 19:14
 * @Version 1.0
 **/
public class Father implements  Comparable{
    protected static int a = 1;
    private static int b = 1;
    public Father(){
        System.out.println("father");
    }
    {
        System.out.println("father 构造块");
    }
    static {
        System.out.println("father static块");
    }
    public Father(int a){
        System.out.println("father: "+a);
    }
    public void test(){
        System.out.println("father：test");
    }
    protected void test1(){
        System.out.println("father：test");
    }

    void test2(){
        System.out.println("father: 默认方法");
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
