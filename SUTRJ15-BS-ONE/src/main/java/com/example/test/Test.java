package com.example.test;

import ch.qos.logback.core.net.SyslogOutputStream;
import ch.qos.logback.core.pattern.FormatInfo;
import javafx.collections.transformation.TransformationList;
import org.springframework.core.task.support.ExecutorServiceAdapter;

import java.util.*;
import java.util.concurrent.*;

/**
 * @ClassName Test
 * @Deseiption
 * @Author AYOU
 * @Date 2019/6/28 19:12
 * @Version 1.0
 **/
public class Test implements Callable,Runnable  {
     
    /*public static Test test = new Test();
    public static Test test2 = new Test();
    {
        System.out.println("构造块");
    }*/
    Test(){
        System.out.println("构造函数");
    }
   /* static 
    {
        System.out.println("静态块");
    }*/
    static int a = 0;
    
    static int fun(){
        
        try {
            return a++;
        }catch (Exception e){

        }finally {
            return a++;
        }
    }
    public static void main(String[] args) throws  Exception{
        /*Set<Father> set = new TreeSet<>();
        Iterator<Father> iter = set.iterator();
        while (iter.hasNext()){  //迭代器遍历
            Father father = iter.next();
            System.out.println(father);
        }
        for(Father father: set){  //foreach遍历
            System.out.println(father);
        }
        Map<String, Object> hashmap = new HashMap<>();
        Map<String, Object> map = Collections.synchronizedMap(hashmap);
        map.forEach((k,v)-> System.out.println(k+" "+v));*/
        /*boxCount();*/ 
      //  int[] arr = {1,2,3,4,5,6};
        List<Integer> list = new ArrayList<>(0);
      //  Arrays.stream(arr).forEach((arrs) -> list.add(arrs));
        for (int i = 0; i < 11; i++) {
            list.add(i);
        } 
      //  list.forEach((k) -> System.out.println(k+" "));
        /*HashMap<String, Object> map = new HashMap<>();
        map.put("1",1);*/
        ExecutorService executor = Executors.newCachedThreadPool();
        //a.retain
        
    }

    /**
     * 空盒子
     */
    public static void boxCount(){
        int result = 0,c = 0;
        int[] a = {3,0,1,0,2};
        boolean cases = true;
        while(cases){
            cases = false;
            for (int i = 0; i < a.length - 1; i++) {
                c = 1;
                if(a[i] > 0){
                    int b = 0;
                    for (int j = i+1; j < a.length; j++) {
                        if(a[j] < 1){
                            b++;
                        }else{
                            if(b != 0) {
                                result += b;
                                cases = true;
                            }
                            i = j-1;
                            break;
                        }
                        if(j == a.length -1){
                            c = 0;
                            break;
                        }
                    }
                }
                if(c == 0){
                    break;
                }
            }
            for (int i = 0; i < a.length; i++) {
                a[i] -= 1;
            }
        }
        System.out.println("有"+result+"个空位");
    }
    
    
    @Override
    public Object call() throws Exception {
        return 1;
    }

    @Override
    public void run() {
        return;
    }
}
