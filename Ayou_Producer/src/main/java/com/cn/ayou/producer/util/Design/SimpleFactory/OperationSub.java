package com.cn.ayou.producer.util.Design.SimpleFactory;

/**
 * @ClassName OperationSub
 * @Deseiption 减法类
 * @Author AYOU
 * @Date 2019/7/8 22:49
 * @Version 1.0
 **/
public class OperationSub extends Operation{
    @Override
    public double getResult() {
        return getNumberA() - getNumberB();
    }
}
