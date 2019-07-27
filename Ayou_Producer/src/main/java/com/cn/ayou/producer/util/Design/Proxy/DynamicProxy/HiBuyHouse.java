package com.cn.ayou.producer.util.Design.Proxy.DynamicProxy;

import com.cn.ayou.producer.util.Design.Proxy.BuyHouse;

/**
 * @ClassName HiBuyHouse
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/27 11:01
 * @Version 1.0
 **/
public class HiBuyHouse implements BuyHouse {
    @Override
    public void buy() {
        System.out.println("他要买房");
    }

    @Override
    public void look() {
        System.out.println("他要看房");
    }
}
