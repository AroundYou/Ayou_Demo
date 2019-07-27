package com.cn.ayou.producer.util.Design.Proxy;

import com.cn.ayou.producer.util.Design.Proxy.BuyHouse;

/**
 * @ClassName RealBuy
 * @Deseiption 原对象
 * @Author AYOU
 * @Date 2019/7/26 17:52
 * @Version 1.0
 **/
public class RealBuy implements BuyHouse {
    @Override
    public void buy() {
        System.out.println("我要买房");
    }

    @Override
    public void look() {
        System.out.println("我要看房");
    }
}
