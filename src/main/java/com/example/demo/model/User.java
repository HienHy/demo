package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 45,name = "first_name")
    private String firstName;

    
    @Column(nullable = false, length = 45,name = "last_name")
    private String lastName;


    private  int blocked;
    private  int active;
    private String roles ="";
    private String permissions ="";


    private boolean enabled;


    public List<String> getRoleList(){
        if (this.roles.length() > 0) {

            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
    public List<String> getPermissionList(){
        if (this.permissions.length() > 0) {

            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }


}
