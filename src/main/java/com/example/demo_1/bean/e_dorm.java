package com.example.demo_1.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//寝室类
@Setter@Getter
@Entity
public class e_dorm {
    @Id//主键注解
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键值的生成机制
    private Integer e_dorm_id;//寝室id
    private Integer e_dorm_num;//寝室号
    private Double e_dorm_money;//寝室剩余电费

    public Integer getE_dorm_id() {
        return e_dorm_id;
    }

    public void setE_dorm_id(Integer e_dorm_id) {
        this.e_dorm_id = e_dorm_id;
    }

    public Integer getE_dorm_num() {
        return e_dorm_num;
    }

    public void setE_dorm_num(Integer e_dorm_num) {
        this.e_dorm_num = e_dorm_num;
    }

    public Double getE_dorm_money() {
        return e_dorm_money;
    }

    public void setE_dorm_money(Double e_dorm_money) {
        this.e_dorm_money = e_dorm_money;
    }

    @Override
    public String toString() {
        return "e_dorm{" +
                "e_dorm_id=" + e_dorm_id +
                ", e_dorm_num=" + e_dorm_num +
                ", e_dorm_money=" + e_dorm_money +
                '}';
    }
}
