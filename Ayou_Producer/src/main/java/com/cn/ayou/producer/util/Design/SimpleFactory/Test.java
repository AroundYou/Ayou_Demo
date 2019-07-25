package com.cn.ayou.producer.util.Design.SimpleFactory;

/**
 * @ClassName Test
 * @Deseiption  ：通过 +-/*和开根的基础计算 演示简单工厂模式
 * @Author AYOU
 * @Date 2019/7/8 22:41
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        Operation operation = create("*");
        operation.setNumberA(5);
        operation.setNumberB(10);
        System.out.println(operation.getResult());
    }
    
    public static Operation create(String operate){
        Operation operation = null;
        
        switch (operate){
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
        }
        return operation;
    }
}
