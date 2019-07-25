package com.example.RJRJ.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NoRepeatSubString
 * @Deseiption 不重复最长子串
 * @Author AYOU
 * @Date 2019/3/14 0:26
 * @Version 1.0
 **/
public class NoRepeatSubString {
    public static void main(String[] args) throws IOException {
       // String str = noRepeatStr("abcadcb");
     //   boolean is = isRepeat("adcab",0,4);
      //  System.out.println(str);
    //    System.out.println(is);
        int[] data ={1,2,2,3,4,4};
        int target = 2;
        System.out.println(a(data, target));
    }
    
    public static int a(int[] data, int target){
        int left = 0;
        int right = data.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        if (data[right] == target)
            return right;
        return -1;
    }
    
    public static String noRepeatStr(String  str){
        int strLength = str.length();
        String subStr = "";
        for (int i = 0; i < strLength; i++) {
            for (int j = i; j < strLength; j++) {
                if(isRepeat(str, i, j) && subStr.length()<str.substring(i,j+1).length()){
                    subStr = str.substring(i, j+1);
                }
            }
        }
        return subStr;
    }
    
    public static boolean isRepeat(String s, int i, int j){
        Set<String> a = new HashSet<>();
        for (int k = i; k <= j; k++) {
            a.add(s.charAt(k)+"");
        }
        if(a.size() == j-i+1){
            return true;    
        }
        return false;
    }
}
