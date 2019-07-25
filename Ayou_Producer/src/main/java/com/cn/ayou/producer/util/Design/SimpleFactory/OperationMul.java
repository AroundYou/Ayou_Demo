package com.cn.ayou.producer.util.Design.SimpleFactory;

/**
 * @ClassName OperationMul
 * @Deseiption 乘法类
 * @Author AYOU
 * @Date 2019/7/8 22:49
 * @Version 1.0
 **/
public class OperationMul extends Operation{
    @Override
    public double getResult() {
        return getNumberA() * getNumberB();
    }
}
