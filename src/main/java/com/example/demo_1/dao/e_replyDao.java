package com.example.demo_1.dao;


import com.example.demo_1.bean.e_reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface e_replyDao extends JpaRepository<e_reply,Integer> {

    @Query(nativeQuery=true ,value="select * from e_reply where topicid = ?")
    List<e_reply> findAllByTopicid(Integer topicid);

}
