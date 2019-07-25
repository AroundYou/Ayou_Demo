package com.example.testetste;
import com.example.test.Father;
import org.omg.CosNaming.IstringHelper;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
    ******************************开始写代码******************************/
    static int main(int[] a) {
       return fun(a);
    }
    static int fun(int[] a){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(!map.containsKey(a[i])){
                map.put(a[i], 0);
            }else{
                map.put(a[i], map.get(a[i])+1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Integer i :map.values()){
            list.add(i);
        }
        Collections.sort(list);
        if(list.get(0) == list.get(list.size() - 1)){
            return list.size();
        }
        int key = list.get(list.size()-1);
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < list.size(); j++) {
                if(list.get(i)%key != 0){
                    break;
                }
            }
            key--;
        }
        int c = 0;
        if(key >= 2){
            for (int i = 0; i < list.size(); i++) {
                c += list.get(i);
            }
            return c/key;
        }else {
            return 0;
        }
        
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int res;

        res = main(arr);
        System.out.println(String.valueOf(res));*/
        dau dau = new dau();
        dau.bin();
        
    }
}

