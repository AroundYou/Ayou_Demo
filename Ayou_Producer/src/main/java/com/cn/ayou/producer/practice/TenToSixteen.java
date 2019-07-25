package com.cn.ayou.producer.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TenToSixteen
 * @Deseiption  10进制数字字符串转为16进制字符串
 * @Author AYOU
 * @Date 2019/7/18 21:47
 * @Version 1.0
 **/
@Slf4j
public class TenToSixteen {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");
        map.put(4,"4");
        map.put(5,"5");
        map.put(6,"6");
        map.put(7,"7");
        map.put(8,"8");
        map.put(9,"9");
        map.put(10,"A");
        map.put(11,"B");
        map.put(12,"C");
        map.put(13,"D");
        map.put(14,"E");
        map.put(15,"F");
        log.info(toC("799",map));
    }

    public static String toC(String ten, Map<Integer, String> map){
        int result = 0;
        int a = 0;
        int key = 0;
        StringBuffer sixteen = new StringBuffer("");
        for (int i = 0; i < ten.length(); i++) {
            char c =  ten.charAt(i);
            int d = c - '0';
            if(d < 0 || d > 9){
                throw new NumberFormatException();
            }else {
                a = a * 10 + (c - '0');
            }
        }
        while (a != 0){
            key++;
            int j = a % 2;
            int z = key % 4;
            a/=2;
            if(z == 0){
                result += 8*j;
                sixteen.append(map.get(result)).append(sixteen);
                result = 0;
            }else if(z == 3){
                result += 4*j;
            }else{
                result += z*j;
            }
        }
        if(key % 4 != 0){
            sixteen.append(map.get(result)).append(sixteen);
        }
        sixteen.append("0x").append(sixteen);
        return sixteen.toString();
    }
}
