package com.example.demo_1.dao;


import com.example.demo_1.bean.e_recharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

public interface e_chargeDao extends JpaRepository<e_recharge,Integer> {
    @Transactional
    @Modifying
    @Query(nativeQuery=true ,value="update e_recharge set e_recharge_detail = ? where e_dorm_num = ?")
    void updateBydorm_num(String state,int dorm_num);


}
