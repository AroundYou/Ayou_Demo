package com.example.Design.SimpleFactory;

/**
 * @ClassName OperationDiv
 * @Deseiption 除法类
 * @Author AYOU
 * @Date 2019/7/8 22:50
 * @Version 1.0
 **/
public class OperationDiv extends Operation{
    @Override
    public double getResult() {
        return getNumberA() / getNumberB();
    }
}
