package com.example.testetste;

import com.example.test.Father;

/**
 * @ClassName dau
 * @Deseiption
 * @Author AYOU
 * @Date 2019/6/30 17:09
 * @Version 1.0
 **/
public class dau extends Father {
    
    //protected 
    public void bin(){
        a++;
        Father.a++;
        System.out.println(Father.a);
        test1();
    }
}
