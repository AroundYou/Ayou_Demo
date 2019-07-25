package com.example.test;

/**
 * @ClassName Maopao
 * @Deseiption
 * @Author AYOU
 * @Date 2019/6/25 19:38
 * @Version 1.0
 **/
public class Maopao {
    
    public static void demo(){
        int[] a = {3,2,1,6,5,4};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if(a[j] < a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i]+" ");
        }
    }

    public static void main(String[] args) {
        demo();
    }
}
