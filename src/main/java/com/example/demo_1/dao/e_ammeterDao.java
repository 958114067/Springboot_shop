package com.example.demo_1.dao;


import com.example.demo_1.bean.e_ammeter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface e_ammeterDao extends JpaRepository<e_ammeter,Integer> {

    @Query(nativeQuery=true ,value="select * from e_ammeter where  type = ? ")
    List<e_ammeter> findbyStatus(String s);

    @Transactional
    @Modifying
    @Query(nativeQuery=true ,value="update e_ammeter set status =  ? where type = ?")
    void updatedianbiao( String s,String s1);

    @Transactional
    @Modifying
    @Query(nativeQuery=true ,value="update e_ammeter set status =  ? where bh = ?")
    void updatedianbiao1( String s,String id);

    @Transactional
    @Modifying
    @Query(nativeQuery=true ,value="update e_ammeter set e_ele = ? where e_dorm_num = ?")
    void updateele(double d,Integer num);

    @Query(nativeQuery=true ,value="select * from e_ammeter where  e_dorm_num = ? ")
    e_ammeter findbynum(Integer dorm_null);

    @Query(nativeQuery=true ,value="select type from e_ammeter where  e_dorm_num = ? ")
    String  findType(Integer dorm_null);

    @Transactional
    @Modifying
    @Query(nativeQuery=true ,value="update e_ammeter set e_ele = e_ele + ? where e_dorm_num = ?")
    void  updatemoney(Double a ,Integer no);

    @Query(nativeQuery=true ,value="select e_ele from e_ammeter where  e_dorm_num = ? ")
    Double findMoneyByDormNum(Integer i);

}
