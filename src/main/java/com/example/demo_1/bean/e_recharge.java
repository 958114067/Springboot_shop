package com.example.demo_1.bean;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//充电详细表
@Entity@Setter@Getter
public class e_recharge {
    @Id//主键注解
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键值的生成机制
    private Integer e_recharge_id;
    private Integer e_dorm_num;
    private Double e_insertmoney;
    private String e_recharge_detail;

    public Integer getE_recharge_id() {
        return e_recharge_id;
    }

    public void setE_recharge_id(Integer e_recharge_id) {
        this.e_recharge_id = e_recharge_id;
    }

    public Integer getE_dorm_num() {
        return e_dorm_num;
    }

    public void setE_dorm_num(Integer e_dorm_num) {
        this.e_dorm_num = e_dorm_num;
    }

    public Double getE_insertmoney() {
        return e_insertmoney;
    }

    public void setE_insertmoney(Double e_insertmoney) {
        this.e_insertmoney = e_insertmoney;
    }

    public String getE_recharge_detail() {
        return e_recharge_detail;
    }

    public void setE_recharge_detail(String e_recharge_detail) {
        this.e_recharge_detail = e_recharge_detail;
    }
}
