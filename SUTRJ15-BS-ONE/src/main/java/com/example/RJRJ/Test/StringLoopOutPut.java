package com.example.RJRJ.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: StringLoopOutPut
 * @description:
 * @author: GZ.L
 * @create: 2019-03-12 21:14
 */
public class StringLoopOutPut {

    public static void main(String[] args) {
        String result = loopOutPut("a", "561237861236");
        System.out.println("循环结果："+result);
    }

    public static String loopOutPut(String a, String b) {
        StringBuffer result = new StringBuffer();
        String repeat = "";
        int aLength = a.length();
        int bLength = b.length();
        if (aLength > bLength) {
           return loopOutPut(b, a);
        }
        for (int i = 0; i < aLength; i++) {
            char c = a.charAt(i);
            char d = b.charAt(i);
            result.append(c).append(d);
        }
        for (int i = aLength; i < bLength; i++) {
            char d = b.charAt(i);
            result.append(d);
        }
        //算b的重复子串
        for (int i = 0; i < bLength - 1; i++) {
            int sign = i;
            int k = 0;
            int head = 0;
            String repeatClone = "";
            for (int j = i + 1; j < bLength; j++) {
                if(k == 1 && b.charAt(sign) != b.charAt(j)){
                    if(repeatClone.length() > repeat.length()){
                        repeat = repeatClone;
                    }
                    break;
                }
                if (b.charAt(sign) == b.charAt(j)) {
                    if("".equals(repeatClone) && head == 0){
                        head = j;
                    }
                    if(sign >= head){
                        sign = i;
                        repeatClone = "";
                        j=head;
                        head=0;
                        continue;
                    }
                    k = 1;
                    repeatClone += b.charAt(sign);
                    sign++;
                }
                if(repeatClone.length() > repeat.length()){
                    repeat = repeatClone;
                }
            }
        }
        System.out.println("b的重复子串："+repeat);
        return result.toString();
    }
}