package com.cn.ayou.producer.util.Design.Proxy.StaticProxy;

import com.cn.ayou.producer.util.Design.Proxy.BuyHouse;
import com.cn.ayou.producer.util.Design.Proxy.RealBuy;
import org.springframework.stereotype.Component;

/**
 * @ClassName Test
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/26 17:55
 * @Version 1.0
 **/
@Component
public class Test {
    public static void main(String[] args) {
        RealBuy realBuy = new RealBuy();
        realBuy.buy();
        BuyHouse buyHouse = new BuyProxy(realBuy);
        buyHouse.buy();
        buyHouse.look();
    }
}
