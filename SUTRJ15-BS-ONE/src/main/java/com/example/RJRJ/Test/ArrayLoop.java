package com.example.RJRJ.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ArrayLoop
 * @Deseiption
 * @Author AYOU
 * @Date 2019/2/24 13:22
 * @Version 1.0
 **/ 
public class ArrayLoop {
    public static void main(String args[]) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String nStr = buff.readLine();
        int n = Integer.parseInt(nStr);
        String nStrs = buff.readLine();
        String[] arr = nStrs.trim().split(" ");
        int[] narr = new int[n];
        for (int i = 0; i < narr.length; i++) {
            narr[i] = Integer.parseInt(arr[i]);
        }
        String qStr = buff.readLine();
        int q = Integer.parseInt(qStr);
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<q;i++){
            int l=0;
            String qStrs = buff.readLine();
            String[] arrq = qStrs.trim().split(" ");
            int[] a = new int[3];
            for(int j=0;j<a.length;j++){
                a[j] = Integer.parseInt(arrq[j]);
            }
            for(int z=a[0]-1;z<=a[1]-1;z++){
                if(narr[z] == a[2]){
                    l++;
                }
            }
            list.add(l);
        }
        for(Integer g:list){
            System.out.println(g);
        }
        
        
//        ArrayLoop arrayLoop = new ArrayLoop();
//        int[][] a = new int[][]{{5, 2, 1, 3}, {2, 5, 6, 9}, {4, 3, 6, 7}};
//        arrayLoop.loop(a);
    }

    public void loop(int[][] a) {
        Map<String, String> map = new HashMap<>();
        //将下标和状态放入map(0没有被遍历到，1被遍历过)
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                map.put(i + "" + j, "0");
            }
        }
        int x = 0, y = 0;

        if (map.containsKey(x + "" + y) == true && map.get(x + "" + y).equals("0")) {
            y++;
            map.put(x + "" + y, "1");
            System.out.print(a[x][y] + " ");
        }
        if (map.containsKey(x + "" + y) == true && map.get(x + "" + y).equals("1")) {
            //转向
        }
        if (map.containsKey(x + "" + y) == false) {
            map.put(x + "" + (y--), "1");
            System.out.print(a[x][y] + " ");
            //转向
        }
    }
    
    
    public void diGui(int[][] a, int m, int n){
  //      for (int i = 0; i < ; i++) {
            
   //     }
    }
}