package com.example.demo_1.dao;


import com.example.demo_1.bean.e_topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface e_topicDao extends JpaRepository<e_topic,Integer> {
    @Query(nativeQuery=true ,value="select * from e_topic")
    List<e_topic>  findAllList();


    @Query(nativeQuery=true ,value="insert into e_topic(title,content,e_name) values (?,?,?)")
    void inserttopic(String title,String content , String e_name);

    @Query(nativeQuery=true ,value="select * from e_topic where topicid = ?")
    e_topic findByTID(Integer topicid);
}
