package com.database.altow.service;

import com.database.altow.entity.UserInfo;
import com.database.altow.repository.AdminRepository;
import com.database.altow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void addUserByAdmin (UserInfo user){
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }
}
