package com.cn.ayou.producer.util.Design.Proxy.DynamicProxy;

import com.cn.ayou.producer.util.Design.Proxy.BuyHouse;
import com.cn.ayou.producer.util.Design.Proxy.RealBuy;

import java.lang.reflect.Proxy;

/**
 * @ClassName Test
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/27 10:47
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        BuyHouse buyHouse = new RealBuy();
        BuyHouse buyProxy = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),
                new Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));
        buyProxy.buy();

        BuyHouse buyHouse1 = new HiBuyHouse();
        BuyHouse buyProxy1 = (BuyHouse)Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),
                new Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse1));
        buyProxy1.buy();
    }
}
