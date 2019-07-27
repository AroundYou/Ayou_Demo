package com.cn.ayou.producer.util.Design.Proxy.StaticProxy;

import com.cn.ayou.producer.util.Design.Proxy.BuyHouse;
import com.cn.ayou.producer.util.Design.Proxy.RealBuy;

/**
 * @ClassName BuyProxy
 * @Deseiption 静态代理类
 * @Author AYOU
 * @Date 2019/7/26 17:53
 * @Version 1.0
 **/
public class BuyProxy implements BuyHouse {


    private RealBuy realBuy;

    public BuyProxy(final RealBuy realBuy){
        this.realBuy = realBuy;
    }

    @Override
    public void buy() {
        System.out.println("没权利买");
    }

    @Override
    public void look() {
        realBuy.look();
    }
}
