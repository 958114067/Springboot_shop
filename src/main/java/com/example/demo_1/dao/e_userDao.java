package com.example.demo_1.dao;

import com.example.demo_1.bean.e_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface e_userDao extends JpaRepository<e_user,Integer> {
    @Query(nativeQuery=true ,value=" select * from e_user where e_id = ? ")
    e_user findByEid(Integer e_id);

    @Query(nativeQuery=true ,value=" select * from e_user where e_name = ? and e_password = ? ")
    e_user findByNameAndPwd(String name,String pwd);

    @Query(nativeQuery=true ,value="insert into e_user(eid,e_name,e_phone,e_dorm_num,e_identity,e_password,e_image) values(?,?,?,?,?,?,?)")
    void insertUser(Integer eid,String name,String tel,Integer dormnum,Integer identity,String password,String allFilepath);

    @Query(nativeQuery=true ,value=" select e_name from e_user where e_dorm_num = ? ")
    List<String> findNameByDormNum(int dorm_num);



}
