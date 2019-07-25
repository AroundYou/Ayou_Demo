package com.cn.ayou.producer.util.Design.SimpleFactory;

/**
 * @ClassName Operation
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/8 22:42
 * @Version 1.0
 **/
public class Operation {
    
    private double numberA;
    
    private double numberB;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }
    public double getResult(){
        return 0.0;
    }
}
