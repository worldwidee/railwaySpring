package com.database.altow.controller;
import com.database.altow.dto.AuthRequest;
import com.database.altow.entity.UserInfo;
import com.database.altow.entity.phoneNumber;
import com.database.altow.exception.CheckOtpException;
import com.database.altow.exception.UserNotFoundException;
import com.database.altow.service.JwtService;
import com.database.altow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/public/register")
    public Map<String,Object > addUserByUser(@RequestBody UserInfo user){
        user.setUsername(user.getMobilePhone());
        userService.addUserByUser(user);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "success");
        response.put("data", "true");
        return response;
    }
    @PutMapping("/public/renew-password")
    public UserInfo updateUserPassword(@RequestBody Map<String, String> numberPassword){
        return userService.updateUserPassword(numberPassword);
    }

    @DeleteMapping("/public/user/delete/{id}")
    public Map<String,Object > removeUserByUser(@PathVariable int id){
        userService.removeUserByUser(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "success");
        response.put("data", "true");
        return response;
    }

    @GetMapping("/public/check-user")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
    public Map<String,Object> checkUser (@RequestBody phoneNumber number){
        Map<String, Object> response = new HashMap<>();
        if(userService.checkUser(number) != null ){
            response.put("status", "success");
            response.put("message", "success");
            response.put("data", true);
        }else {
            response.put("status", "failure");
            response.put("message", "failure");
            response.put("data", false);
        }
        return  response;
    }


    @GetMapping("/public/login")
    public Map<String,String> AuthAndGenerateToken(@RequestBody AuthRequest authRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),
                authRequest.getPassword()));

        if(authentication.isAuthenticated()){
            Map<String, String> response = new HashMap<>();
            response.put("token", jwtService.generateToken(authRequest.getUsername()));
            return response;
        }
        else{
            throw new UsernameNotFoundException("Invalid request!");
        }

    }
    @GetMapping("/public/login/version:2")
    public ResponseEntity<Map<String,Object>>  AuthAndGenerateTokenV2(@RequestBody AuthRequest authRequest) throws UserNotFoundException {

        try {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()));
            Map<String, Object> response = new HashMap<>();
            response.put("token", jwtService.generateToken(authRequest.getUsername()));

            return ResponseEntity.ok(response);

        }catch (Exception e){

            throw new UserNotFoundException();

        }

    }
    @PostMapping("/public/check-otp")
    public ResponseEntity<Map<String,Object>>  CheckUserOtp(@RequestBody Map<String,String> otpCode) throws CheckOtpException {
            if(Objects.equals(otpCode.get("otpCode"), "123456")){
                Map<String, Object> response = new HashMap<>();
                response.put("status", "success");
                response.put("message", "success");
                response.put("data", true);
                return ResponseEntity.ok(response);
            }else {
                throw new CheckOtpException();
            }
    }

    @PostMapping("public/send-otp")
    public ResponseEntity<Map<String,Object>>  sendOtp(@RequestBody Map<String,String> otpCode) throws CheckOtpException {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "success");
        response.put("data", true);
        return ResponseEntity.ok(response);

    }
    @PostMapping ("public/re-send-otp")
    public ResponseEntity<Map<String,Object>>  reSendOtp(@RequestBody Map<String,String> otpCode) throws CheckOtpException {

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "success");
        response.put("data", true);
        return ResponseEntity.ok(response);

    }

    }
