package com.database.altow.repository;

import com.database.altow.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo,Integer> {
    UserInfo findById(int id);
    @Query(value = "SELECT * FROM user_info WHERE mobile_phone=? LIMIT 1",nativeQuery = true)
    UserInfo findByMobilePhone(String phoneNumber);
    Optional<UserInfo> findByUsername(String username);
}
