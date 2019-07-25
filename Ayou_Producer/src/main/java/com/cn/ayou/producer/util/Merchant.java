package com.cn.ayou.producer.util;

import java.io.Serializable;

/**
 * @ClassName Merchant
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/12 23:16
 * @Version 1.0
 **/
public class Merchant implements Serializable{


    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String address;

    public Merchant(String id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
