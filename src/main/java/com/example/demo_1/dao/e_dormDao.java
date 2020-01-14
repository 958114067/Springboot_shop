package com.example.demo_1.dao;


import com.example.demo_1.bean.e_dorm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface e_dormDao extends JpaRepository<e_dorm,Integer> {

     @Query(nativeQuery=true ,value=" select e_dorm_num from e_dorm ")
     Integer [] findAllDormId();
     @Query(nativeQuery=true ,value=" select e_dorm_money from e_dorm where e_dorm_num = ? ")
     Double findMoneyByDormNum(int dorm_num);
     @Transactional
     @Modifying
     @Query(nativeQuery=true ,value="update e_dorm set e_dorm_money = e_dorm_money + ? where e_dorm_num = ?")
     void updateBydorm_num( Double setMoney,int dorm_num);


}
