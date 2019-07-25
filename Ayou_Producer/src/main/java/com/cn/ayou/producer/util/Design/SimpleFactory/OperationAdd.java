package com.cn.ayou.producer.util.Design.SimpleFactory;

/**
 * @ClassName OperationAdd
 * @Deseiption 加法类
 * @Author AYOU
 * @Date 2019/7/8 22:49
 * @Version 1.0
 **/
public class OperationAdd extends Operation{
    @Override
    public double getResult() {
        return getNumberA() + getNumberB();
    }
}
