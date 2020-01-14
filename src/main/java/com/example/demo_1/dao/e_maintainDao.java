package com.example.demo_1.dao;


import com.example.demo_1.bean.e_maintain;
import com.example.demo_1.bean.e_recharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface e_maintainDao extends JpaRepository<e_maintain,Integer> {


    @Query(nativeQuery=true ,value=" select * from e_maintain where e_dorm_num = ?")
    List<e_maintain> findByDormNum(Integer e_dorm_num);
}
