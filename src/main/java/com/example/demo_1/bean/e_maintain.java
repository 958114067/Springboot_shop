package com.example.demo_1.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//维修表
@Entity
public class e_maintain {
    @Id//主键注解
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键值的生成机制
    private Integer maintainid;
    private Integer e_dorm_num;
    private String type;
    private String remark;

    public Integer getMaintainid() {
        return maintainid;
    }

    public void setMaintainid(Integer maintainid) {
        this.maintainid = maintainid;
    }

    public Integer getE_dorm_num() {
        return e_dorm_num;
    }

    public void setE_dorm_num(Integer e_dorm_num) {
        this.e_dorm_num = e_dorm_num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
