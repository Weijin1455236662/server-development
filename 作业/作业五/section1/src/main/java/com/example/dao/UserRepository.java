package com.example.dao;

import com.example.domain.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Cacheable("userCache")
    User findUserByUserName(String userName);

    @Query("select count(userName) from User where userName=?1 and password=?2")
    Long getMatchCount(String userName,String password);

    @Query("update User set lastVisit=?1,lastIp=?2 where userId=?3")
    void updateLoginInfo(Date lastVisit,String lastIp,int userId);

    @CacheEvict("userCache")
    @Modifying
    @Query("delete from User where userName=?1")
    void deleteByUserName(String userName);

}
