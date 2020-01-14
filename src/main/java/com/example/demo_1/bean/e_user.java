package com.example.demo_1.bean;

import javax.persistence.*;

@Entity
public class e_user {
    @Id//主键注解
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键值的生成机制
    private Integer e_id;
    private String e_name;
    private String e_phone;
    private Integer e_dorm_num;
    private Integer e_identity;
    private String e_password;
    private String e_image;

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_phone() {
        return e_phone;
    }

    public void setE_phone(String e_phone) {
        this.e_phone = e_phone;
    }

    public Integer getE_dorm_num() {
        return e_dorm_num;
    }

    public void setE_dorm_num(Integer e_dorm_num) {
        this.e_dorm_num = e_dorm_num;
    }

    public Integer getE_identity() {
        return e_identity;
    }

    public void setE_identity(Integer e_identity) {
        this.e_identity = e_identity;
    }

    public String getE_password() {
        return e_password;
    }

    public void setE_password(String e_password) {
        this.e_password = e_password;
    }

    public String getE_image() {
        return e_image;
    }

    public void setE_image(String e_image) {
        this.e_image = e_image;
    }

    @Override
    public String toString() {
        return "e_user{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", e_phone='" + e_phone + '\'' +
                ", e_dorm_num=" + e_dorm_num +
                ", e_identity=" + e_identity +
                ", e_password='" + e_password + '\'' +
                ", e_image='" + e_image + '\'' +
                '}';
    }
}