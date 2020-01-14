package com.example.demo_1.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class e_ammeter {
    @Id//主键注解
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键值的生成机制
    private Integer ammeterid;
    private Integer e_dorm_num;
    private double e_ele;
    private String type;
    private String status;
    private String bh;

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public Integer getAmmeterid() {
        return ammeterid;
    }

    public void setAmmeterid(Integer ammeterid) {
        this.ammeterid = ammeterid;
    }

    public Integer getE_dorm_num() {
        return e_dorm_num;
    }

    public void setE_dorm_num(Integer e_dorm_num) {
        this.e_dorm_num = e_dorm_num;
    }

    public double getE_ele() {
        return e_ele;
    }

    public void setE_ele(double e_ele) {
        this.e_ele = e_ele;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
