package com.database.altow.controller;

import com.database.altow.entity.UserInfo;
import com.database.altow.repository.UserRepository;
import com.database.altow.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController  {
    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/add")
    public Map<String,String> addUserByAdmin(@RequestBody UserInfo user){
        adminService.addUserByAdmin(user);
        Map<String, String> response = new HashMap<>();
        response.put("Status", "Saved");
        return response;
    }
}
