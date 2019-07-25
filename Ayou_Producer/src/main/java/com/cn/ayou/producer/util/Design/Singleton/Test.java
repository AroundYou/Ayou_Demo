package com.cn.ayou.producer.util.Design.Singleton;

/**
 * @ClassName Test
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/21 12:34
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        SimpleSingleton simpleSingleton = SimpleSingleton.getInstance();
        System.out.println(simpleSingleton);
        SimpleSingleton simpleSingleton1 = SimpleSingleton.getInstance();
        System.out.println(simpleSingleton1);
    }
}
