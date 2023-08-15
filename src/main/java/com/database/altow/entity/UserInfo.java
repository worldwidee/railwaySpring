package com.database.altow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "role_list")
    private String roleList;

   //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
   //@JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role"))
   //private Set<Role> roles;
}
