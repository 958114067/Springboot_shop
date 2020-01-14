package com.example.demo_1.dao;


import com.example.demo_1.bean.e_announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface e_announcementDao extends JpaRepository<e_announcement,Integer> {

    @Query(nativeQuery=true ,value="select * from e_announcement order by announcementid desc ")
    List<e_announcement> findAllnotice();

    @Query(nativeQuery=true ,value="select * from e_announcement where  announcementid = ? ")
    e_announcement  findbyannid(Integer announcementid);
}
