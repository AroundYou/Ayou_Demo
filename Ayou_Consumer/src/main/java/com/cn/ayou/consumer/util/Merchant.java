package com.cn.ayou.consumer.util;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Merchant
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/12 23:16
 * @Version 1.0
 **/
@Data
public class Merchant implements Serializable{


    private static final long serialVersionUID = 1731297860536853732L;

    public Merchant(){
        super();
    }

    private String id;

    private String name;

    private String address;

    public Merchant(String id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

}
